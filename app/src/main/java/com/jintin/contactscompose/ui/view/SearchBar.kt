package com.jintin.contactscompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchBar(
    filter: String,
    filterChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = filter,
        label = { Text("Filter:") },
        onValueChange = filterChange,
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth(),
        trailingIcon = {
            if (filter.isNotEmpty()) {
                IconButton(onClick = { filterChange("") }) {
                    Icon(Icons.Default.Close, contentDescription = "close")
                }
            }
        }

    )
}