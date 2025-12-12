package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.theme.FinalProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProjectTheme {
                val navController = rememberNavController()

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = "medical"
                    ) {
                        composable("medical") {
                            MedicalScreen(navController = navController)
                        }

                        composable("details") {
                            val hospital = HospitalStore.selectedHospital

                            hospital?.let {
                                HospitalDetailScreen(
                                    navController = navController,
                                    hospital = it
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
