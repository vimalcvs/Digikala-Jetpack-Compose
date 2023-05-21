package com.vimalcvs.digikalacompose.repository

import com.vimalcvs.digikalacompose.data.model.home.Slider
import com.vimalcvs.digikalacompose.data.remote.BaseApiResponse
import com.vimalcvs.digikalacompose.data.remote.HomeApiInterface
import com.vimalcvs.digikalacompose.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HomeApiInterface
) : BaseApiResponse() {
    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }
}