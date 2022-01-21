package com.chyngyz.goratest.network

import com.chyngyz.goratest.model.photos.Album
import com.chyngyz.goratest.model.user.Users
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface GoraApi {

   @GET("users")
   suspend fun getAllUsers(): Users

   @GET("albums/{id}/photos")
   suspend fun getAllPhotos(@Path("id") id: Int): Album
}