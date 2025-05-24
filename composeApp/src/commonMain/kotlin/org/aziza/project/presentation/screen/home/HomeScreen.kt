package org.aziza.project.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter
import org.koin.compose.getKoin
import androidx.compose.runtime.getValue

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = getKoin().get()
    val state by viewModel.state.collectAsState()

    HomeContent(state = state, onRetry = viewModel::loadUsers, onRefresh = viewModel::refresh)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    onRefresh: () -> Unit,
    onRetry: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        " Random Users",
                    )
                },
                actions = {
                    IconButton(onClick = { onRefresh() }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.isError != "" -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = state.isError ?: "Unknown error occurred",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { onRetry() }) {
                            Text("Retry")
                        }
                    }
                }

                state.users.isEmpty() -> {
                    Text(
                        text = "No users found",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier.background(Color(0xFFF2F2F2)),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 4.dp
                        )
                    ) {
                        itemsIndexed(items = state.users) { _, user ->
                            UserItem(user.image, user.name, user.phone)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun UserItem(
    image: String,
    name: String,
    phone: String,
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(url = image),
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .size(50.dp).clip(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
            )
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = name, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = phone)
            }
        }
    }
}