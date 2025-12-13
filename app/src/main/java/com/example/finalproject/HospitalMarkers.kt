package com.example.finalproject

import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.NavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMapComposable
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.rememberUpdatedMarkerState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.CameraPositionState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import kotlinx.coroutines.launch

@Composable
@GoogleMapComposable
fun HospitalMapMarker(
    hospitalViewState: List<Hospital>,
    navController: NavController,
    mapViewModel: MapViewModel
){
    // Coroutine for Map transition
    val scope = rememberCoroutineScope()
    val hospitalIcon = remember { BitmapDescriptorFactory.fromResource(R.drawable.hospital)}

    hospitalViewState.forEach { hospital ->
        Marker(
            state = rememberUpdatedMarkerState(position = LatLng(hospital.lat, hospital.lng)),
            title = hospital.name,
            snippet = hospital.address,
            tag = hospital,
            icon = hospitalIcon,
            onClick = {
                HospitalStore.selectedHospital = hospital
                scope.launch {
                    mapViewModel.cameraPositionState.animate(
                        update = CameraUpdateFactory.newCameraPosition(
                            CameraPosition(LatLng(hospital.lat, hospital.lng), 12f, 0f, 0f) // zoom, tilt, bearing
                        ),
                        durationMs = 1000 // Animation duration in milliseconds
                    )

                    navController.navigate("details")
                }
                false
            }
        )
    }
}