package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalScreen(navController: NavController) {
    val (searchQuery, setSearchQuery) = remember { mutableStateOf("") }
    // Sort hospitals by distance and filter by search query
    val hospitals = sampleHospitalData()
        .sortedBy { it.distanceInMeters }
        .filter { it.name.contains(searchQuery, ignoreCase = true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = setSearchQuery,
            placeholder = { Text("Search...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFF0F0F0),
                focusedContainerColor = Color(0xFFF0F0F0)
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Map data ©2025",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            itemsIndexed(hospitals) { index, hospital ->
                val cardColor = if (index % 2 == 0) Color(0xFFF0F0F0) else Color.White
                // really rough estimate of time based on distance. will be fised with api
                val timeInMinutes = (hospital.distanceInMeters / 1000) * 2.5
                LocationItem(
                    title = hospital.name,
                    time = "${timeInMinutes.toInt()} mins",
                    cardColor = cardColor,
                    onGoClick = {
                        navController.navigate("details/${hospital.name}")
                    }
                )
            }
        }
    }
}

@Composable
fun LocationItem(
    title: String,
    time: String,
    cardColor: Color,
    onGoClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Icon(
                        Icons.Outlined.Place,
                        contentDescription = "Place",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Icon(
                        Icons.Outlined.Share,
                        contentDescription = "Share"
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = time, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFE8DFF5), shape = RoundedCornerShape(12.dp))
                        .clickable { onGoClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "GO",
                        color = Color(0xFF673AB7),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MedicalScreenPreview() {
    FinalProjectTheme {
        val navController = rememberNavController()
        MedicalScreen(navController = navController)
    }
}
