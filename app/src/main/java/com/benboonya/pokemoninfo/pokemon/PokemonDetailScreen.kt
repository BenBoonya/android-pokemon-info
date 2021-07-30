package com.benboonya.pokemoninfo.pokemon


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.benboonya.pokemoninfo.pokemon.model.Pokemon
import com.benboonya.pokemoninfo.pokemon.ui.detail.PokemonDetailViewModel


@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel
) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val pokemon: Pokemon? by viewModel.pokemonDetail.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Pokemon") })
        },
        content = {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                PokemonDetailView(pokemon = pokemon)
            }
        }
    )
}

@Composable
fun PokemonDetailView(pokemon: Pokemon?) {
    pokemon?.let {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 4.dp
        ) {
            Column {
                Text(text = pokemon.name, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Height: ${pokemon.heightInMetre} Metre")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Weight: ${pokemon.weightInKilogram} Kg")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Base Exp: ${pokemon.baseExperience}")
            }
        }
    }
}