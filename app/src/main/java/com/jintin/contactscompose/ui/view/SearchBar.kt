package com.jintin.contactscompose.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
        colors = customTextColors(),
        modifier = modifier
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

@Composable
private fun customTextColors(): TextFieldColors =
    TextFieldDefaults.outlinedTextFieldColors(
        textColor = MaterialTheme.colorScheme.onBackground,
        disabledTextColor = MaterialTheme.colorScheme.onBackground,
        backgroundColor = MaterialTheme.colorScheme.background,
        cursorColor = MaterialTheme.colorScheme.onBackground,
        errorCursorColor = MaterialTheme.colorScheme.error,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
        disabledBorderColor = MaterialTheme.colorScheme.onBackground,
        errorBorderColor = MaterialTheme.colorScheme.error,
        leadingIconColor = MaterialTheme.colorScheme.onBackground,
        disabledLeadingIconColor = MaterialTheme.colorScheme.onBackground,
        errorLeadingIconColor = MaterialTheme.colorScheme.error,
        trailingIconColor = MaterialTheme.colorScheme.onBackground,
        disabledTrailingIconColor = MaterialTheme.colorScheme.onBackground,
        errorTrailingIconColor = MaterialTheme.colorScheme.error,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
        disabledLabelColor = MaterialTheme.colorScheme.onBackground,
        errorLabelColor = MaterialTheme.colorScheme.error,
        placeholderColor = MaterialTheme.colorScheme.onBackground,
        disabledPlaceholderColor = MaterialTheme.colorScheme.primary,
    )