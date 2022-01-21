package com.chyngyz.goratest.screens.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chyngyz.goratest.data.DataOrException
import com.chyngyz.goratest.model.photos.Album
import com.chyngyz.goratest.model.user.Users
import com.chyngyz.goratest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

   val data: MutableState<DataOrException<Album, Boolean, Exception>> =
      mutableStateOf(DataOrException(Album(), true, Exception("")))

   fun getPhotos(id: Int) {
      viewModelScope.launch {
         data.value.loading = true
         data.value = repository.getAllPhotos(id)
         if (!data.value.data.isNullOrEmpty()) data.value.loading = false
      }
   }
}