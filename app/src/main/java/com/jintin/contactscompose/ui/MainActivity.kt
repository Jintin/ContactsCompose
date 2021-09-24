package com.jintin.contactscompose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jintin.contactscompose.data.ContactData
import com.jintin.contactscompose.ui.theme.ContactsTheme
import com.jintin.contactscompose.ui.view.ContactRow
import com.jintin.contactscompose.ui.view.Hint
import com.jintin.contactscompose.ui.view.SearchBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val list: List<ContactData> by viewModel.list
            val filter: String by viewModel.filter

            ContactsTheme {
                Surface {
                    ContactList(list, filter, viewModel::updateFilter)
                }
            }
        }
    }
}

@Composable
fun ContactList(list: List<ContactData>, filter: String, filterChange: (String) -> Unit) {
    Column {
        SearchBar(filter, filterChange, Modifier.padding(8.dp))

        if (list.isEmpty()) {
            Hint(
                if (filter.isEmpty()) {
                    "No result for now!!"
                } else {
                    "No result for now, try to adjust filter!!"
                }
            )
        } else {
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(8.dp),
            ) {
                items(list, key = { it.name + it.number }) { item ->
                    ContactRow(item)
                }
            }
        }

    }
}
