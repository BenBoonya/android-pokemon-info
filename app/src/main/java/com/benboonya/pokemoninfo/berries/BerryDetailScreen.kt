package com.benboonya.pokemoninfo.berries


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.benboonya.pokemoninfo.berries.model.Berry
import com.benboonya.pokemoninfo.berries.ui.detail.BerryDetailViewModel


@Composable
fun BerryDetailScreen(
    viewModel: BerryDetailViewModel
) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val berry: Berry? by viewModel.berryDetail.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Pokemon") })
        },
        content = {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                BerryDetailView(berry = berry)
            }
        }
    )
}

@Composable
fun BerryDetailView(berry: Berry?) {
    berry?.let {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 4.dp
        ) {
            Column {
                Text(text = berry.name, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Size: ${berry.size} Millimeter")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Growth Time: ${berry.growthTime} Hour")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Max harvest: ${berry.maxHarvest}")
            }
        }
    }
}