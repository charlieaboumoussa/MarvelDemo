package com.demo.characters.characterlisting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun CharacterListingScreen(
    viewModel: CharacterListingViewModel = hiltViewModel()
) {
    Text("Marvel Characters")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        LazyColumn {
            viewModel.uiState.value.characters?.let {
                items(it) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = Dp(6f)
                    ) {
                        Column {
                            Text(
                                text = item.name
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