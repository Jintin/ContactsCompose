package com.jintin.contactscompose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.jintin.contactscompose.data.ContactData
import com.jintin.contactscompose.ui.theme.ContactsComposeTheme
import com.jintin.contactscompose.view.ContactRow
import com.jintin.contactscompose.view.FilterHeaderView
import com.jintin.contactscompose.view.LoadingView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel by viewModels<MainViewModel>()
            val list: List<ContactData> by viewModel.list
            val filter: String by viewModel.filter

            ContactsComposeTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ContactList(list, filter) {
                        viewModel.updateFilter(it)
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ContactList(list: List<ContactData>, filter: String, filterChange: (String) -> Unit) {
    if (list.isEmpty() && filter.isEmpty()) {
        LoadingView()
    } else {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(12.dp, 8.dp, 12.dp, 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            stickyHeader {
                FilterHeaderView(filter, filterChange)
            }
            items(list) { item ->
                ContactRow(item)
            }
        }
    }
}
