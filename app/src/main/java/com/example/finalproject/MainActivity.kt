package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.theme.FinalProjectTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.awaitAll
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProjectTheme {
                val navController = rememberNavController()
                val mapViewModel: MapViewModel = viewModel()


                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = "medical"
                    ) {
                        composable("medical") {
                            MedicalScreen(
                                navController = navController,
                                mapViewModel = mapViewModel,
                                cameraPositionState = mapViewModel.cameraPositionState
                            )
                        }

                        composable("details") {
                            val hospital by HospitalStore.selectedHospital.collectAsState()

                            hospital?.let {
                                HospitalDetailScreen(
                                    navController = navController,
                                    hospital = it,
                                    mapViewModel = mapViewModel,
                                    cameraPositionState = rememberCameraPositionState {
                                        position = CameraPosition.fromLatLngZoom(LatLng(hospital!!.lat, hospital!!.lng), 14f)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
