package ir.aris.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aris.digikala.data.datastore.DataStoreRepository
import ir.aris.digikala.util.Constants.PERSIAN_LANG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository,
) : ViewModel() {

    companion object {
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
    }

    fun saveUserLanguage(language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.putString(USER_LANGUAGE_KEY, language)
        }
    }

    fun getUserLanguage(): String = runBlocking {
        repository.getString(USER_LANGUAGE_KEY) ?: PERSIAN_LANG
    }

}