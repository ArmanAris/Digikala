package ir.aris.digikala.ui.screen.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aris.digikala.R
import ir.aris.digikala.data.network.NetworkResult
import ir.aris.digikala.ui.theme.darkText
import ir.aris.digikala.ui.theme.selectedBottomBar
import ir.aris.digikala.ui.theme.spacing
import ir.aris.digikala.util.InputValidation.isValidPassword
import ir.aris.digikala.viewmodel.ProfileViewModel


@Composable
fun RegisterScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.digi_settings
                    ), contentDescription = "",
                    modifier = Modifier
                        .padding(
                            MaterialTheme.spacing.small
                        )
                        .size(MaterialTheme.spacing.semiLarge),
                    tint = MaterialTheme.colors.selectedBottomBar
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small),
                    tint = MaterialTheme.colors.selectedBottomBar
                )
            }
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))

        Text(
            text = stringResource(id = R.string.set_password_text),
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.semiLarge
            ),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.darkText,
            fontWeight = FontWeight.Bold
        )

        MyEditText(
            value = profileViewModel.inputPhoneState,
            placeholder = stringResource(id = R.string.phone_and_email),
            onValueChange = {},
        )


        MyEditText(
            value = profileViewModel.inputPasswordState,
            placeholder = stringResource(id = R.string.set_password),
            onValueChange = {
                profileViewModel.inputPasswordState = it
            }
        )


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))


        MyButton(text = stringResource(id = R.string.digikala_login)) {
            if (isValidPassword(profileViewModel.inputPasswordState)) {

                profileViewModel.login()

            } else {
                Toast.makeText(
                    context,
                    context.resources.getText(R.string.password_format_error),
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }


    var loading by remember {
        mutableStateOf(false)
    }

    val loginResponse by profileViewModel.loginResponse.collectAsState()
    when (loginResponse) {
        is NetworkResult.Success -> {
            profileViewModel.screenState = ProfileScreenState.PROFILE_STATE
            Toast.makeText(
                context,
                loginResponse.message,
                Toast.LENGTH_LONG
            ).show()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "loginResponse error : ${loginResponse.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

}
