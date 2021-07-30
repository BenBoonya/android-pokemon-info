package com.benboonya.pokemoninfo.pokemon

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.benboonya.pokemoninfo.common.ui.PaginatedList
import com.benboonya.pokemoninfo.drawer.TopBar
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel

@Composable
fun PokemonScreen(
    openDrawer: () -> Unit,
    viewModel: PokemonListViewModel,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Pokemon",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )

        PaginatedList(
            viewModel.pokemonListResult
        )
    }
}

