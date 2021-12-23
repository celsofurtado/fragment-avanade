package br.pro.celsofurtado.fragment_avanade_prof

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        val args = this.arguments

        val userId = args!!.get("user_id")
        val userName = args!!.get("user_name")

        Log.i("xpto", "O id do usuario é: $userId")
        Log.i("xpto", "O nome do usuario é: $userName")

        return view
    }

}