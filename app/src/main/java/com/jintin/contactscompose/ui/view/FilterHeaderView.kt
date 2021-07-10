package com.jintin.contactscompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterHeaderView(filter: String, filterChange: (String) -> Unit) {
    OutlinedTextField(
        value = filter,
        label = { Text("Filter:") },
        onValueChange = filterChange,
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    )
}