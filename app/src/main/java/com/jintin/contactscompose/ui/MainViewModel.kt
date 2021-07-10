package com.jintin.contactscompose.ui

import androidx.lifecycle.LiveData
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

    private var list = emptyList<ContactData>()
    private val _listLiveData = MutableLiveData<List<ContactData>>()
    val listLiveData: LiveData<List<ContactData>> = _listLiveData

    private var filter: String = ""
    private val _filterLiveData = MutableLiveData<String>()
    val filterLiveData: LiveData<String> = _filterLiveData

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            list = repo.getList()
            updateData()
        }
    }

    private fun updateData() {
        _listLiveData.value =
            list.filter { it.name.contains(filter) || it.number.contains(filter) }
    }

    fun updateFilter(filter: String) {
        this.filter = filter
        _filterLiveData.value = filter
        updateData()
    }
}