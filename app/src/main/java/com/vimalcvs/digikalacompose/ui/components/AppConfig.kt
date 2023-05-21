package com.vimalcvs.digikalacompose.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.vimalcvs.digikalacompose.util.Constants.USER_LANGUAGE
import com.vimalcvs.digikalacompose.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    getDataStoreVariables(dataStore)
}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
}