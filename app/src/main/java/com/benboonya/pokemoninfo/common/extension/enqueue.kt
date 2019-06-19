package com.benboonya.pokemoninfo.common.extension

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

inline fun <T> Call<T>.enqueue(
        crossinline successHandler: (T?) -> Unit,

        crossinline failureHandler: (String?) -> Unit
) {
    this.enqueue(object : Callback<T> {

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.let {
                if (it.isSuccessful) {

                    successHandler(it.body())
                } else {
                    failureHandler(it.message())
                }
            } ?: run {
                failureHandler(null)
            }
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failureHandler(null)
        }
    })
}
