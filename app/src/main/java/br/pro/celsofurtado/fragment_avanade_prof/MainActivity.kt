package br.pro.celsofurtado.fragment_avanade_prof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import br.pro.celsofurtado.fragment_avanade_prof.factory.RetrofitFactory
import br.pro.celsofurtado.fragment_avanade_prof.model.User
import br.pro.celsofurtado.fragment_avanade_prof.service.RetrofitService
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var usersFragment: UsersFragment
    private lateinit var postFragment: PostFragment

    private lateinit var bottomNavigationView: BottomNavigationView

    private var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersFragment = UsersFragment()
        postFragment = PostFragment()

        bottomNavigationView = findViewById(R.id.nav_bottom)

        //listarUsers()

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.menu_users -> {
                    setFragment(usersFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_posts -> {
                    setFragment(postFragment)
                    return@setOnItemSelectedListener true
                }
            }

            false
        }

    }

//    private fun listarUsers() {
//
//        val call = RetrofitFactory().retrofitService().getUsers()
//
//        call.enqueue(object : Callback<List<User>> {
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//
//                response.body().let {
//                    users = it as MutableList<User>
//                    Log.i("xpto", users.toString())
//                    Log.i("xpto", users[2].email)
//                }
//
//            }
//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//
//
//    }

    private fun setFragment(fragment: Fragment) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragment, fragment)
        fragmentTransaction.commit()

    }


}