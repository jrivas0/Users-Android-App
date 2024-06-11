package com.example.userssp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.R
import com.example.userssp.User
import com.example.userssp.onClickListener

class UserAdapter (private val users: MutableList<User>, private val listener:onClickListener) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_alt, parent, false)

        return UserViewHolder(view,parent.context,listener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = users[position]
        holder.render(item,position)
    }

    override fun getItemCount(): Int = users.size


    fun remove(adapterPosition: Int) {
        users.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }


}