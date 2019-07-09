package com.benboonya.pokemoninfo.common.extension

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> List<*>.checkItemInstance() =
        if (all { it is T })
            this as List<T>
        else null