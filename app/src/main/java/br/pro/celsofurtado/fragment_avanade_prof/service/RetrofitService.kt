package br.pro.celsofurtado.fragment_avanade_prof.service

import br.pro.celsofurtado.fragment_avanade_prof.model.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("users")
    fun getUsers(): Call<List<User>>
}