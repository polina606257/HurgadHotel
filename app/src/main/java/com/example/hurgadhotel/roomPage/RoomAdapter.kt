package com.example.hurgadhotel.roomPage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hurgadhotel.R
import com.example.hurgadhotel.databinding.RoomBinding
import com.example.domain.modul.Room
import com.example.hurgadhotel.hotelPage.PhotoCarouselAdapter
import com.example.hurgadhotel.utils.createAndUpdateDotIndicator

class RoomAdapter(val roomsList: List<Room>, val context: Context) : RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = RoomBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        getRoom(position).also {
            viewHolder.bind(it)
        }
    }
    override fun getItemCount() = roomsList.size

    private fun getRoom(position: Int): Room {
        return roomsList[position]
    }
    inner class ViewHolder(val binding: RoomBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(room: Room) {
            binding.room = room
            val photos = room.imageUrls
            val adapter = PhotoCarouselAdapter(photos)
            binding.photoPager.adapter = adapter
            createAndUpdateDotIndicator(photos, context, binding.indicatorLayout, binding.photoPager)
            binding.roomName.text = room.name
            binding.price.text = "${room.price}р"
            binding.priceInfo.text = room.pricePer

            for (peculiar in room.peculiarities) {
                val peculiarView = LayoutInflater.from(context).inflate(
                    R.layout.peculiar_item,
                    binding.peculiarContainer,
                    false
                ).apply {
                    id = View.generateViewId()
                } as TextView

                peculiarView.text = peculiar
                binding.peculiarContainer.addView(peculiarView)
                binding.peculiar.addView(peculiarView)
            }
        }
    }
}