package br.pro.celsofurtado.fragment_avanade_prof

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.pro.celsofurtado.fragment_avanade_prof.model.User

class UsersAdapter(var context: Context): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var usersList = emptyList<User>()

    fun update(list: List<User>) {
        this.usersList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_users_layout, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = usersList[position]
        holder.tvNome.text = user.name
        holder.tvEmail.text = user.email
        holder.tvPhone.text = user.phone

        holder.itemView.setOnClickListener {
            val activity: AppCompatActivity = it.context as AppCompatActivity
            val postFragment = PostFragment()

            val bundle = Bundle()
            bundle.putString("user_id", user.id.toString())
            bundle.putString("user_name", user.name)

            postFragment.arguments = bundle

            activity.supportFragmentManager.beginTransaction().replace(R.id.frame_fragment, postFragment).addToBackStack(null).commit()
        }

    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class UsersViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var tvNome = view.findViewById<TextView>(R.id.tv_nome)
        var tvEmail = view.findViewById<TextView>(R.id.tv_email)
        var tvPhone = view.findViewById<TextView>(R.id.tv_phone)
        var cardUsers = view.findViewById<CardView>(R.id.card_users)

    }

}