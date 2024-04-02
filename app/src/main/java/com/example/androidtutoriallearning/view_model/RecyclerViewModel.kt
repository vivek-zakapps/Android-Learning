package com.example.androidtutoriallearning.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class RvDataModel(val name: String);

class RecyclerViewModel : ViewModel() {
    private val _recyclerDataList = MutableLiveData<MutableList<RvDataModel>>(mutableListOf())
    val recyclerViewModelList: LiveData<MutableList<RvDataModel>> = _recyclerDataList

    fun addToList(data: RvDataModel) {
        // Get current value of LiveData or initialize with empty list if null
        val currentList = _recyclerDataList.value ?: mutableListOf()
        currentList.add(data)
        _recyclerDataList.value = currentList // Update LiveData with new list
    }


    fun removeFromList(index: Int) {
        println("Im gonna remove it")
        val currentList = _recyclerDataList.value ?: return // Return if null
        if (index >= 0 && index < currentList.size) {
            currentList.removeAt(index)
            _recyclerDataList.value = currentList

        }

        println( _recyclerDataList.value )

    }

    fun updateData(index: Int, updatedItem: RvDataModel) {
        val currentList = _recyclerDataList.value ?: return // Return if null
        if (index >= 0 && index < currentList.size) {
            currentList[index] = updatedItem
            _recyclerDataList.value = currentList // Update LiveData with new list
        }
    }

}