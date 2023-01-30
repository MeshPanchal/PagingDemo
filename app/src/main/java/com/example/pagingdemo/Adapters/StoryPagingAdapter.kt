package com.example.pagingdemo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingdemo.R
import com.example.pagingdemo.dataClass.Hit

class StoryPagingAdapter : PagingDataAdapter<Hit, StoryPagingAdapter.StoryViewHolder>(COMPARATOR) {


	class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		val authorText = itemView.findViewById<TextView>(R.id.authorTextview)

	}

	companion object {
		private val COMPARATOR = object : DiffUtil.ItemCallback<Hit>() {
			override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
				return oldItem.objectID == newItem.objectID
			}

			override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
				return oldItem == newItem
			}
		}
	}

	override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
		val item = getItem(position)
		if (item != null) {
			if(item.author!=null){
				holder.authorText.text = item.author
			}else{
				holder.authorText.text = "no author name"
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
		val view =
			LayoutInflater.from(parent.context).inflate(R.layout.item_story_layout, parent, false)
		return StoryViewHolder(view)
	}
}