package com.example.hurgadhotel.hotelPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hurgadhotel.databinding.ItemPhotoBinding

class PhotoCarouselAdapter(private val photos: ArrayList<String>) : RecyclerView.Adapter<PhotoCarouselAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: String) {
            Glide.with(binding.photo.context)
                .load(photo)
                .centerCrop()
                .into(binding.photo)

            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}