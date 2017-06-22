package com.example.shathru.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.shathru.photoapp.models.Photo

class MainAdapter(var photos : List<Photo>,
                  var listener : View.OnClickListener) :
        RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position] // even though photos is a list kotlin allows you to use it as an array
        holder?.tags?.text = photo.tags
        holder?.tags?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo?.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                    .load(photo.previewURL)
                    .into(holder?.photo_item)
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).
                inflate(R.layout.photo_item, parent, false))
    }

    fun getPhoto(position : Int) : Photo { // will be used by MainActivity
        return photos[position]
    }

    inner class PhotoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tags : TextView
        var likes : TextView
        var favorites: TextView
        var photo_item : ImageView

        init {
            if (listener != null) {
                itemView.setOnClickListener(listener)
            }
                itemView.tag = this
                tags = itemView.findViewById(R.id.tags) as TextView
                likes = itemView.findViewById(R.id.likes) as TextView
                favorites = itemView.findViewById(R.id.favorites) as TextView
                photo_item = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }
}