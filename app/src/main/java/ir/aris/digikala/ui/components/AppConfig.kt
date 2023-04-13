package ir.aris.digikala.ui.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.util.Constants.USER_ID
import ir.aris.digikala.util.Constants.USER_LANGUAGE
import ir.aris.digikala.util.Constants.USER_PASSWORD
import ir.aris.digikala.util.Constants.USER_PHONE
import ir.aris.digikala.util.Constants.USER_TOKEN
import ir.aris.digikala.viewmodel.DataStoreViewModel
import ir.aris.digikala.viewmodel.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppConfig(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel(),
) {

    getDataStoreVariables(dataStore)

    profileViewModel.refreshToken(USER_PHONE, USER_PASSWORD)


    LaunchedEffect(Dispatchers.Main) {
        profileViewModel.loginResponse.collectLatest { loginResponse ->
            when (loginResponse) {
                is NetworkResult.Success -> {
                    loginResponse.data?.let { user ->
                        if (user.token.isNotEmpty()) {
                            dataStore.saveUserToken(user.token)
                            dataStore.saveUserId(user.id)
                            dataStore.saveUserPhoneNumber(user.phone)
                            dataStore.saveUserPassword(USER_PASSWORD)

                            getDataStoreVariables(dataStore)

                            Log.e("7171", "refresh token")
                        }

                    }
                }
                else -> {}
            }
        }

    }

}


private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
    // If the language does not change the first time, we add the following code
    // create data store:
    // dataStore.saveUserLanguage(USER_LANGUAGE)

    USER_PHONE = dataStore.getUserPhoneNumber().toString()
    USER_PASSWORD = dataStore.getUserPassword().toString()
    USER_TOKEN = dataStore.getUserToken().toString()
    USER_ID = dataStore.getUserId().toString()

}