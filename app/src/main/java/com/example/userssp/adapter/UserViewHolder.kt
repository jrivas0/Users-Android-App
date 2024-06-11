package com.example.userssp.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.userssp.User
import com.example.userssp.databinding.ItemUserAltBinding
import com.example.userssp.onClickListener

class UserViewHolder(view: View, private val context: Context, private val listener: onClickListener) : RecyclerView.ViewHolder(view) {

    private val binding = ItemUserAltBinding.bind(view)


    fun setListener(user: User,position: Int){
        binding.root.setOnClickListener{
            listener.onClick(user,position)
        }
    }

    fun render(user: User, position: Int) {
        val humanPosition = position + 1
        setListener(user,humanPosition)
        binding.tvOrder.text = (humanPosition).toString()
        binding.tvName.text = user.getFullName()
        Glide.with(context)
            .load(user.url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(binding.ivProfile)
    }
}
