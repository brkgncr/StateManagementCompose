package com.burak.statemanagementcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.burak.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    var username = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpecialText("Register Form")
        Spacer(modifier = Modifier.padding(10.dp))
        SpecialTextField(string = username.value, onValueChangeFunction = {
            username.value = it
        })
        Spacer(modifier = Modifier.padding(10.dp))
        SpecialPasswordField(string = password.value, onValueChangeFunction = {
            password.value = it
        })
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {}) {
            Text("Register")
        }
    }
}

@Composable
fun SpecialTextField(string : String, onValueChangeFunction: (String) -> Unit) {
    OutlinedTextField(
        value = string,
        onValueChange = onValueChangeFunction,
        label = { Text("Username") },
        modifier = Modifier.padding(5.dp),
    )
}

@Composable
fun SpecialPasswordField(string: String, onValueChangeFunction: (String) -> Unit) {
    OutlinedTextField(
        value = string,
        onValueChange = onValueChangeFunction,
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.padding(5.dp)
    )
}


@Composable
fun SpecialText(string: String) {
    Text(text = string,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}