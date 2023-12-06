package com.juandiegogarcia.loginusertimetonic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.runBlocking

@Composable
fun UserScreen(){
    val emailValue = rememberSaveable{ mutableStateOf("") }
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var sessionKey by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val name = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf(0)
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Enter your email and password to registered with Timetonic", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))


        TransparentTextField(
            textFieldValue = emailValue,
            textLabel = "Email",
            keyboardType = KeyboardType.Email,
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            imeAction = ImeAction.Next
        )

        TransparentTextField(
            textFieldValue = passwordValue,
            textLabel = "Password",
            keyboardType = KeyboardType.Password,
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    //TODO("LOGIN")
                }
            ),
            imeAction = ImeAction.Done,
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        imageVector = if(passwordVisibility) {
                            Icons.Default.Visibility
                        } else {
                            Icons.Default.VisibilityOff
                        },
                        contentDescription = "Toggle Password Icon"
                    )
                }
            },
            visualTransformation = if(passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Forgot Password?",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End
        )

        Button(onClick = {
            val session = runBlocking {
                val sessionResponse = loginApp(emailValue.value, passwordValue.value)
                return@runBlocking sessionResponse
            }
            sessionKey = session?.sesskey.toString()

        }) {
            Text(text = "Sign Up")
        }
    }
}

