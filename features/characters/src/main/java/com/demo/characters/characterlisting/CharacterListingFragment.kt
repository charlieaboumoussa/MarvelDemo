package com.demo.characters.characterlisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.characters.databinding.FragmentCharacterListingBinding
import com.demo.ui.base.BaseFragment
import com.demo.ui.base.BaseViewModel

class CharacterListingFragment : BaseFragment() {

    private var _binding: FragmentCharacterListingBinding? = null
    private val binding get() = _binding!!

    private val _viewModel: CharacterListingViewModel by viewModels()

    override fun attachViewModel(): BaseViewModel = _viewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListingBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        val view = binding.root
        binding.composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                DefaultPreview(_viewModel)
            }
        }
        return view
    }

    override fun onViewCreatedBase(view: View, savedInstanceState: Bundle?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    viewModel: CharacterListingViewModel = viewModel()
) {
    Text("Marvel Characters")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        LazyColumn {
            items(viewModel.uiState.value.characters) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = Dp(6f)
                ) {
                    Text(
                        text = item.name
                    )
                }
            }
        }
    }
}