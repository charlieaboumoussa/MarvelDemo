package com.demo.characters.characterlisting

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.demo.characters.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun CharacterListingScreen(
    viewModel: CharacterListingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val isRefreshing = viewModel.isRefreshing.collectAsState().value
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)
    Scaffold(content = { padding ->
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                text = stringResource(R.string.marvel_characters),
                style = MaterialTheme.typography.h4
            )
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = viewModel::refresh,
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    uiState.characters?.let {
                        items(it, key = { listItem -> listItem.id }) { item ->
                            Card(modifier = Modifier.fillMaxWidth(),
                                elevation = Dp(6f),
                                onClick = {
                                    viewModel.navigateToCharacterDetails(item.id)
                                }) {
                                Row {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("${item.thumbnailPath}.${item.thumbnailExtension}")
                                            .crossfade(true).build(),
                                        contentDescription = "avatar",
                                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                        modifier = Modifier
                                            .size(64.dp)
                                            .clip(CircleShape)                       // clip to the circle shape
                                            .border(
                                                2.dp, Color.Transparent, CircleShape
                                            )   // add a border (optional)
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp)
                                    ) {
                                        Text(
                                            text = item.name,
                                            style = MaterialTheme.typography.h6
                                        )
                                        Text(
                                            text = item.description,
                                            minLines = 2,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    })
}