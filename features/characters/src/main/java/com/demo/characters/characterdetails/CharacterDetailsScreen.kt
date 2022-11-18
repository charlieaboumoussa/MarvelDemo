package com.demo.characters.characterlisting

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel = viewModel()
) {
    Text("Marvel Characters")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        LazyColumn {
            viewModel.uiState.value.characterComics?.let {
                items(it) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = Dp(6f)
                    ) {
                        Column {
                            Text(
                                text = item.title
                            )
                            Text(
                                text = item.description
                            )
                        }
                    }
                }
            }
        }
    }
}