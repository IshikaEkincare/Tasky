package com.raywenderlich.android.taskie.networking

import com.raywenderlich.android.taskie.model.Task
import com.raywenderlich.android.taskie.model.UserProfile
import com.raywenderlich.android.taskie.model.request.AddTaskRequest
import com.raywenderlich.android.taskie.model.request.UserDataRequest
import com.raywenderlich.android.taskie.model.response.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RemoteApiService {

    @POST("/api/register")
    fun registerUser(@Body request: UserDataRequest): Call<RegisterResponse>

    @GET("/api/note")
    suspend fun getNotes(): GetTasksResponse

    @POST("/api/login")
    fun loginUser(@Body request: UserDataRequest): Call<LoginResponse>

    @GET("/api/user/profile")
    suspend fun getMyProfile(): UserProfileResponse

    @POST("/api/note/complete")
    suspend fun completeTask(@Query("id") noteId: String): CompleteNotesResponse

    @POST("/api/note")
    suspend fun addTask(@Body request: AddTaskRequest): Task

    @DELETE("/api/note")
    suspend fun deleteTask(@Query("id") noteId: String): DeleteNoteResponse
}