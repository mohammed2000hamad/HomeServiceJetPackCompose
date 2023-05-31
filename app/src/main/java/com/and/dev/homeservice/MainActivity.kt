package com.and.dev.homeservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.and.dev.homeservice.navigation.Navigation
import com.and.dev.homeservice.ui.theme.HomeServiceTheme
import com.and.dev.homeservice.viewModel.AllWorkViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            HomeServiceTheme {

                // A surface container using the 'background' color from the theme
                Navigation()

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeServiceTheme {
        Greeting("Android")
    }
}