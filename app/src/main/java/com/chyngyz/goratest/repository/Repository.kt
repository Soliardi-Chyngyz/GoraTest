package com.chyngyz.goratest.repository

import com.chyngyz.goratest.data.DataOrException
import com.chyngyz.goratest.model.photos.Album
import com.chyngyz.goratest.model.user.Users
import com.chyngyz.goratest.network.GoraApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: GoraApi){

   suspend fun getAllUsers(): DataOrException<Users, Boolean, Exception> {
      val response = try {
         api.getAllUsers()
      } catch (e: Exception) {
         return DataOrException(e = e)
      }
      return DataOrException(data = response)
   }

   suspend fun getAllPhotos(id: Int): DataOrException<Album, Boolean, Exception> {
      val response = try {
         api.getAllPhotos(id)
      } catch (e: Exception) {
         return DataOrException(e = e)
      }
      return DataOrException(data = response)
   }

}