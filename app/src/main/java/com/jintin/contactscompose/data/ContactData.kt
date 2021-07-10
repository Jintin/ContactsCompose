package com.jintin.contactscompose.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactData(val name: String, val number: String) : Parcelable