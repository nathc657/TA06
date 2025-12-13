package com.example.finalproject

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState

class MapViewModel : ViewModel() {
    // Default Starting Location
    private val defaultLocation = LatLng(39.6586243, -75.7390809) // Newark, DE

    // Shared camera position state across screens
    val cameraPositionState = CameraPositionState(
        position = CameraPosition.fromLatLngZoom(defaultLocation, 10f)
    )
}