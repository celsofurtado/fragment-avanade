package br.pro.celsofurtado.fragment_avanade_prof

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pro.celsofurtado.fragment_avanade_prof.factory.RetrofitFactory
import br.pro.celsofurtado.fragment_avanade_prof.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsersFragment : Fragment() {

    lateinit var adapter: UsersAdapter
    lateinit var rvUsers: RecyclerView

    private var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_users, container, false)

        rvUsers = view.findViewById(R.id.rv_users)
        rvUsers.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        adapter = UsersAdapter(requireActivity().applicationContext)
        rvUsers.adapter = adapter

        listarUsers()

        return view
    }

    private fun listarUsers() {

        val call = RetrofitFactory().retrofitService().getUsers()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                response.body().let {
                    users = it as MutableList<User>
//                    Log.i("xpto", users.toString())
//                    Log.i("xpto", users[2].email)
                    adapter.update(users)
                }

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.i("xpto", "Falhou!!")
            }

        })



    }

}