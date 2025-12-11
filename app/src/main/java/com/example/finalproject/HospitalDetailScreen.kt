package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.theme.FinalProjectTheme

@Composable
fun HospitalDetailScreen(
    navController: NavController,
    hospital: Hospital
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Map Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                "Map data ©2025",
                modifier = Modifier.padding(6.dp),
                fontSize = 10.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
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
                fontSize = 22.sp
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
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Phone
            Text(
                text = hospital.phone,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HospitalDetailScreenPreview() {
    // Get the first hospital from the sample data for the preview
    val sampleHospital = sampleHospitalData().first()
    FinalProjectTheme {
        HospitalDetailScreen(
            navController = rememberNavController(),
            hospital = sampleHospital
        )
    }
}
