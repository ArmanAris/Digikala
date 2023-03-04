package ir.aris.digikala.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.util.Constants.USER_LANGUAGE
import ir.aris.digikala.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel(),
) {
    getDataStoreVariable(dataStore)
}


private fun getDataStoreVariable(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
}