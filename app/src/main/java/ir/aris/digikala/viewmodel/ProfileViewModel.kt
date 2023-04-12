package ir.aris.digikala.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aris.digikala.data.model.profile.LoginRequest
import ir.aris.digikala.data.model.profile.LoginResponse
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.repository.ProfileRepository
import ir.aris.digikala.ui.screen.profile.ProfileScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) :
    ViewModel() {
    //sharedViewModel
    var screenState by mutableStateOf(ProfileScreenState.LOGIN_STATE)

    var inputPhoneState by mutableStateOf("")
    var inputPasswordState by mutableStateOf("")

    val loginResponse = MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Loading())

    fun login() {
        viewModelScope.launch {
            val loginRequest = LoginRequest(inputPhoneState, inputPasswordState)
            loginResponse.emit(repository.login(loginRequest))
        }
    }


}