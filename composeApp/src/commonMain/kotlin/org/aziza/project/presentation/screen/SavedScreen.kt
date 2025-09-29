package org.aziza.project.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

data class CarItem(
    val id: Int,
    val make: String,
    val model: String,
    val variant: String,
    val year: Int,
    val mileage: String,
    val engine: String,
    val transmission: String,
    val fuelType: String,
    val price: String,
    val rating: Float,
    val imageRes: String = "car_placeholder"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    
    val sampleCars = remember {
        listOf(
            CarItem(
                id = 1,
                make = "Make",
                model = "model",
                variant = "model variant",
                year = 2011,
                mileage = "29,000 Km's",
                engine = "1.6 litres",
                transmission = "Automatic",
                fuelType = "Petrol",
                price = "150,000,000 IQD",
                rating = 4.7f
            ),
            CarItem(
                id = 2,
                make = "Make",
                model = "model",
                variant = "model variant",
                year = 2011,
                mileage = "29,000 Km's",
                engine = "1.6 litres",
                transmission = "Automatic",
                fuelType = "Petrol",
                price = "150,000,000 IQD",
                rating = 4.7f
            ),
            CarItem(
                id = 3,
                make = "Make",
                model = "model",
                variant = "model variant",
                year = 2011,
                mileage = "29,000 Km's",
                engine = "1.6 litres",
                transmission = "Automatic",
                fuelType = "Petrol",
                price = "150,000,000 IQD",
                rating = 4.7f
            ),
            CarItem(
                id = 4,
                make = "Make",
                model = "model",
                variant = "model variant",
                year = 2011,
                mileage = "29,000 Km's",
                engine = "1.6 litres",
                transmission = "Automatic",
                fuelType = "Petrol",
                price = "150,000,000 IQD",
                rating = 4.7f
            ),
            CarItem(
                id = 5,
                make = "Make",
                model = "model",
                variant = "model variant",
                year = 2011,
                mileage = "29,000 Km's",
                engine = "1.6 litres",
                transmission = "Automatic",
                fuelType = "Petrol",
                price = "150,000,000 IQD",
                rating = 4.7f
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Top App Bar
        TopAppBar(
            title = {
                Text(
                    text = "Saved",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        // Tab Row
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White,
            contentColor = Color(0xFF2196F3),
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = {
                    Text(
                        text = "Adverts",
                        fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = {
                    Text(
                        text = "Recent",
                        fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }

        // Compare Cars Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = Color.Black.copy(alpha = 0.05f),
                    spotColor = Color.Black.copy(alpha = 0.1f)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White.copy(alpha = 0.2f))
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Handle compare cars */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    ),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(
                        text = "Compare cars",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                IconButton(onClick = { /* Handle menu */ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            }
        }

        // Car List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleCars) { car ->
                CarItemCard(car = car)
            }
        }
    }
}

@Composable
fun CarItemCard(car: CarItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color.Black.copy(alpha = 0.05f),
                spotColor = Color.Black.copy(alpha = 0.1f)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White.copy(alpha = 0.2f))
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Car Image
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.Black.copy(alpha = 0.06f),
                        spotColor = Color.Black.copy(alpha = 0.12f)
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFFF8F8F8),
                                Color(0xFFEEEEEE)
                            ),
                            radius = 60.dp.value
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                // Placeholder for car image
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Car Image",
                    modifier = Modifier.size(60.dp),
                    tint = Color.Gray.copy(alpha = 0.6f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Car Details
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Title and Rating Row
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${car.make} ${car.model} ${car.variant}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = car.rating.toString(),
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Year, Mileage, Engine
                Text(
                    text = "${car.year}    ${car.mileage}    ${car.engine}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Transmission, Fuel Type
                Text(
                    text = "${car.transmission}    ${car.fuelType}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Price
                Text(
                    text = car.price,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3)
                )
            }

            // Bookmark Icon
            IconButton(
                onClick = { /* Handle bookmark toggle */ }
            ) {
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Bookmark",
                    tint = Color(0xFF2196F3),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}