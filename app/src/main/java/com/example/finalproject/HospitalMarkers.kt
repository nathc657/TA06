package com.example.finalproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.NavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMapComposable
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.rememberUpdatedMarkerState
import androidx.navigation.compose.rememberNavController

@Composable
@GoogleMapComposable
fun HospitalMapMarker(
    hospitalViewState: List<Hospital>,
    navController: NavController){
    hospitalViewState.forEach { hospital ->
        Marker(
            state = rememberUpdatedMarkerState(position = LatLng(hospital.lat, hospital.lng)),
            title = hospital.name,
            snippet = hospital.address,
            tag = hospital,
            onClick = {
                HospitalStore.selectedHospital = hospital
                navController.navigate("details")
                false
            }
        )
    }
}