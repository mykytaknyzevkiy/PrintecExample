package com.printec_example.app.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.printec_example.app.unit.MState
import com.printec_example.app.R
import com.printec_example.app.ui.NewsViewHolder
import com.printec_example.app.ui.TicketViewHolder
import com.printec_example.app.ui.TopNewsViewHolder
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(mViewModel: MainViewModel = viewModel()) {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            val errorState by mViewModel.errorState.collectAsState()

            Text(
                text = stringResource(
                    id = when (errorState) {
                        MState.MError.NoInternet -> R.string.global_error_no_internet_lable

                        else -> R.string.global_error_no_unknown
                    }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                mViewModel.clearError()
                mViewModel.reloadFull()
            }) {
                Text(text = stringResource(id = R.string.global_error_reload_btn_label))
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            val news = mViewModel.news.collectAsLazyPagingItems()

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                stickyHeader {
                    Text(text = stringResource(id = R.string.main_screen_list_tickets_header_label))
                }

                item {
                    val tickets = mViewModel.tickets.collectAsLazyPagingItems()

                    LazyRow {
                        items(tickets) { ticket ->
                            if (ticket != null) {
                                TicketViewHolder(ticket)
                            } else {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }

                stickyHeader {
                    Text(text = stringResource(id = R.string.main_screen_list_top_news_header_label))
                }

                item {
                    LazyRow {
                        items(6) { index ->
                            if (index < news.itemCount) {
                                val n = news[index]

                                if (n != null) {
                                    TopNewsViewHolder(newsModel = n)
                                } else {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                    }
                }

                stickyHeader {
                    Text(text = stringResource(id = R.string.main_screen_list_news_header_label))
                }

                items(news) { n ->
                    if (n != null)
                        NewsViewHolder(newsModel = n)
                    else
                        CircularProgressIndicator()
                }
            }

            val loadingState by mViewModel.state.collectAsState()

            if (loadingState == MState.LoadingState) {
                CircularProgressIndicator()
            }
        }
    }

    LaunchedEffect(key1 = state) {
        mViewModel.errorState
            .onEach {
                if (it == MState.MError.Empty) {
                    state.hide()
                } else {
                    state.show()
                }
            }.launchIn(scope)
    }
}
