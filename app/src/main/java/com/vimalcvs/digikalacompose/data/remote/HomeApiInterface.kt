package com.vimalcvs.digikalacompose.data.remote

import com.vimalcvs.digikalacompose.data.model.ResponseResult
import com.vimalcvs.digikalacompose.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>
}