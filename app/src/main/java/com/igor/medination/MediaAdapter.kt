package com.igor.medination

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaAdapter(val mediaItems: List<Media>): RecyclerView.Adapter<MediaAdapter.MediaViewHolder>(){


    inner class MediaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val mediaLayoutBackground = itemView.findViewById<LinearLayout>(R.id.ll_item_holder)
        val mediaImage = itemView.findViewById<ImageView>(R.id.iv_category)
        val mediaTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val mediaCategory = itemView.findViewById<TextView>(R.id.tv_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_home,parent,false)
        return MediaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val mediaList =mediaItems[position]
        holder.mediaLayoutBackground.setBackgroundResource(mediaList.backgroundResource)
        holder.mediaImage.setImageResource(mediaList.image)
        holder.mediaTitle.text = mediaList.title
        holder.mediaCategory.text = mediaList.category
    }

    override fun getItemCount(): Int {
        return mediaItems.size
    }
}