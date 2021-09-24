package com.jintin.contactscompose.ui.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jintin.contactscompose.data.ContactData


@Composable
fun ContactRow(data: ContactData) {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Click: ${data.name}", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(8.dp)
    ) {
        Text(
            data.name,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(data.number)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactRow(ContactData(name = "Peter", number = "0983927894"))
}