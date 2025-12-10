
package com.example.finalproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.ui.theme.FinalProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Search Bar
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFF0F0F0), // Example color
                focusedContainerColor = Color(0xFFF0F0F0) // Example color
            )
        )

        // Map Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("Map data ©2025", style = MaterialTheme.typography.bodySmall, modifier = Modifier.align(Alignment.BottomEnd).padding(4.dp))
        }

        // Location List
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            //to make more cards, use the LocationItem function
            item {
                LocationItem(
                    title = "12311 Hospital One Ave",
                    time = "20 mins",
                )
            }
            item {
                LocationItem(
                    title = "5153 Urgent Care Rd",
                    time = "13 mins",
                )
            }
            item {
                LocationItem(
                    title = "31357 Hospital Way",
                    time = "46 mins",
                )
            }
            item {
                LocationItem(
                    title = "Pingo Bango Pongo",
                    time = "67 mins",
                )
            }
            item {
                LocationItem(
                    title = "Booboo bee boo boop",
                    time = "567 mins",
                )
            }
        }
    }
}

@Composable
fun LocationItem(title: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = null, modifier = Modifier.padding(end = 16.dp))
                    Icon(Icons.Outlined.Place, contentDescription = null, modifier = Modifier.padding(end = 16.dp))
                    Icon(Icons.Outlined.Share, contentDescription = null)
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = time, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFFE8DFF5), shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("GO", color = Color(0xFF673AB7), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicalScreenPreview() {
    FinalProjectTheme {
        MedicalScreen()
    }
}
