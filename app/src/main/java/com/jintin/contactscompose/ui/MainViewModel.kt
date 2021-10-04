package com.jintin.contactscompose.ui

import androidx.lifecycle.MutableLiveData
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

    val list = MutableLiveData<List<ContactData>>() //mutableStateOf(listOf<ContactData>())

    val filter = MutableLiveData<String>()// mutableStateOf("")

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
        val filterValue = filter.value
        list.value = if (filterValue != null) {
            oriList.filter { it.name.contains(filterValue) || it.number.contains(filterValue) }
        } else {
            oriList
        }
    }

    fun updateFilter(filter: String) {
        this.filter.value = filter
        updateData()
    }
}