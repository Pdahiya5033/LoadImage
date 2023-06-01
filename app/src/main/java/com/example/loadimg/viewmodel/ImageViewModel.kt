package com.example.loadimg.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loadimg.model.ImgData
import com.example.loadimg.networking.MakeUrl
import kotlinx.coroutines.launch
class ImageViewModel : ViewModel() {
    val myResponseList: MutableLiveData<List<ImgData>> = MutableLiveData()
    fun getPics() {
        viewModelScope.launch {
            myResponseList.value = MakeUrl.retrofit?.getPics()
        }
    }
}