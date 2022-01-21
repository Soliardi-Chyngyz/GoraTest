package com.chyngyz.goratest.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chyngyz.goratest.data.DataOrException
import com.chyngyz.goratest.model.user.Users
import com.chyngyz.goratest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel()  {


   val data: MutableState<DataOrException<Users, Boolean, Exception>> =
      mutableStateOf(DataOrException(Users(), true, Exception("")))

   init {
      getAllUsers()
   }

   private fun getAllUsers() {
      viewModelScope.launch {
         data.value.loading = true
         data.value = repository.getAllUsers()
         if (!data.value.data.isNullOrEmpty()) data.value.loading = false
      }
   }
}