package com.example.finalproject

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.theme.FinalProjectTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import kotlin.random.Random

@Composable
fun HospitalDetailScreen(
    navController: NavController,
    hospital: Hospital,
    mapViewModel: MapViewModel,
    cameraPositionState : CameraPositionState,
    hospitals: List<Hospital> = sampleHospitalData()

) {

    // Boolean for Google Map Rendering
    var isMapLoaded by remember { mutableStateOf(false) }

    // 1. Use a Box as the root to allow layering.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 2. Create a scrollable Column for the main content.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                // 3. Add padding at the bottom so content doesn't scroll under the phone number.
                .padding(bottom = 80.dp)
        ) {
            // Map Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.BottomEnd
            ) {
                // Google Maps Composable
                GoogleMap (
                    modifier = Modifier
                        .fillMaxSize(),
                    onMapLoaded = { isMapLoaded = true },
                    cameraPositionState = cameraPositionState
                ){
                    // Calls the marker function to add the markers to the map
                    HospitalMapMarker(hospitals, navController,mapViewModel)
                }


                // (Visuals) If the map isn't loaded, transition to a gray screen
                androidx.compose.animation.AnimatedVisibility(
                    visible = !isMapLoaded,
                    enter = EnterTransition.None,
                    exit = fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        // (Visuals) While the map is loading, show a progress indicator
                        CircularProgressIndicator()
                    }
                }

                Text(
                    "Google Maps ©2025",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // This Column now holds just the inner details.
            Column(
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth()
            ) {

                // Back button
                Button(
                    onClick = { navController.popBackStack() },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF3D7E5)
                    ),
                    modifier = Modifier.width(90.dp)
                ) {
                    Text("Back", color = Color.Black)
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Hospital Name
                Text(
                    text = hospital.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Available Beds: " + ((0..250).random().toString()),
                    fontWeight = FontWeight.Bold,
                    fontSize =25.sp
                )


                Spacer(modifier = Modifier.height(20.dp))

                hospital.services.forEach { service ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Text("•", fontSize = 18.sp, modifier = Modifier.padding(end = 12.dp))
                        Text(service, fontSize = 16.sp)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Website
                Text(
                    text = hospital.website,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
                val context = LocalContext.current
                //NAVIGATE TO GOOGLE MAPS AND USE ADDRESS DATA
                Button(
                    onClick = {
                        val uri = Uri.parse(
                            "google.navigation:q=${Uri.encode(hospital.address)}&mode=d"
                        )
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.setPackage("com.google.android.apps.maps")
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF673AB7)
                    )
                ) {
                    Text(
                        text = "Navigate",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

        // 4. Place the Phone Text directly inside the Box.
        //    Now Modifier.align(Alignment.BottomCenter) works correctly.
        Text(
            text = hospital.phone,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter) // This is now valid inside a Box
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HospitalDetailScreenPreview() {
    val sampleHospital = sampleHospitalData().first()
    FinalProjectTheme {
        HospitalDetailScreen(
            navController = rememberNavController(),
            hospital = sampleHospital,
            hospitals = sampleHospitalData(),
            mapViewModel = MapViewModel(),
            cameraPositionState = rememberCameraPositionState()
        )
    }
}
