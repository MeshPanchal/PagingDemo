package com.example.pagingdemo.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingdemo.R

class LoadAdapter: LoadStateAdapter<LoadAdapter.LoadStateViewholder>() {

	class LoadStateViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)

		fun bind(loadState: LoadState) {
			progressBar.isVisible = loadState is LoadState.Loading
			if (loadState is LoadState.NotLoading) {
				Log.d("load", "bind: Not loading")
			}
		}
	}

	override fun onBindViewHolder(holder: LoadStateViewholder, loadState: LoadState) {
		holder.bind(loadState)
	}

	override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewholder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.load_page_layout, parent,false)
		return LoadStateViewholder(view)
	}

}