package br.pro.celsofurtado.fragment_avanade_prof.factory

import br.pro.celsofurtado.fragment_avanade_prof.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val URL: String = "https://jsonplaceholder.typicode.com/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userService(): UserService {
        return retrofitFactory.create(UserService::class.java)
    }

}