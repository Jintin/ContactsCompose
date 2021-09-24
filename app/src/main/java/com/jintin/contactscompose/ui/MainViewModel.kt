package com.jintin.contactscompose.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jintin.contactscompose.data.ContactData
import com.jintin.contactscompose.data.ContactRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ContactRepo
) : ViewModel() {

    val list = mutableStateOf(listOf<ContactData>())

    val filter = mutableStateOf("")

    private var oriList = listOf<ContactData>()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            oriList = repo.getList()
            updateData()
        }
    }

    private fun updateData() {
        list.value =
            oriList.filter { it.name.contains(filter.value) || it.number.contains(filter.value) }
    }

    fun updateFilter(filter: String) {
        this.filter.value = filter
        updateData()
    }
}