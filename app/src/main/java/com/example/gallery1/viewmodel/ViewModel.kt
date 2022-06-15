package com.example.gallery1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.model.AllPhotos

class MainViewModel : ViewModel() {
    val error = MutableLiveData<String>()
    val res = MutableLiveData<AllPhotos>()
    val allPhotos = MutableLiveData<AllPhotos>()



    fun getPhotoFromRep(query: String) {

    }





}