package com.demo.characters.characterlisting

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

@Preview(showBackground = true)
@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
    characterId : Int? = null
) {
    LaunchedEffect(Unit) {
        characterId?.let {
            viewModel.getCharacterByIdFromDB(it)
            viewModel.getCharacterComics()
            viewModel.getCharacterEvents()
            viewModel.getCharacterSeries()
            viewModel.getCharacterStories()
        }
    }
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.character))
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.popNavigation() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    ){
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = Dp(6f),
                ) {
                    Row {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("${uiState.character?.thumbnailPath}.${uiState.character?.thumbnailExtension}")
                                .crossfade(true)
                                .build(),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,            // crop the image if it's not a square
                            modifier = Modifier
                                .size(72.dp)
                                .clip(CircleShape)                       // clip to the circle shape
                                .border(
                                    2.dp,
                                    Color.Transparent,
                                    CircleShape
                                )   // add a border (optional)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                text = uiState.character?.name ?: "",
                                style = MaterialTheme.typography.h6
                            )
                            Text(
                                text = uiState.character?.description ?: "",
                                minLines = 2,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
                Text(stringResource(R.string.comics), style = MaterialTheme.typography.h6)
                LazyRow{
                    viewModel.uiState.value.characterComics?.let {
                        items(it, key = { listItem -> listItem.id }) { item ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = Dp(6f),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        text = item.title,
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

                Text(stringResource(R.string.events), style = MaterialTheme.typography.h6)
                LazyRow{
                    viewModel.uiState.value.characterEvents?.let {
                        items(it, key = { listItem -> listItem.id }) { item ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = Dp(6f),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        text = item.title,
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

                Text(stringResource(R.string.series), style = MaterialTheme.typography.h6)
                LazyRow{
                    viewModel.uiState.value.characterSeries?.let {
                        items(it, key = { listItem -> listItem.id }) { item ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = Dp(6f),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        text = item.title,
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

                Text(stringResource(R.string.stories), style = MaterialTheme.typography.h6)
                LazyRow{
                    viewModel.uiState.value.characterStories?.let {
                        items(it, key = { listItem -> listItem.id }) { item ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = Dp(6f),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp)
                                ) {
                                    Text(
                                        text = item.title,
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
    )
}