package com.example.pagingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingdemo.Adapters.LoadAdapter
import com.example.pagingdemo.Adapters.StoryPagingAdapter
import com.example.pagingdemo.ViewModel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	lateinit var recyclerView: RecyclerView
	lateinit var userText:EditText
	lateinit var enterBtn : Button
	lateinit var adapter: StoryPagingAdapter
	lateinit var viewModel: StoryViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		recyclerView = findViewById(R.id.storylist)
		userText = findViewById(R.id.userText)
		enterBtn = findViewById(R.id.enterBtn)
		adapter = StoryPagingAdapter()

		viewModel = ViewModelProvider(this).get(StoryViewModel::class.java)

		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.setHasFixedSize(true)
		recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
			LoadAdapter(), LoadAdapter()
		)

		viewModel.list.observe(this , Observer {
			adapter.submitData(lifecycle,it)
		})

		enterBtn.setOnClickListener {
			val text:String?= userText.text.toString()
			if (text !="") {

			}else{
				Toast.makeText(this, "enter the text", Toast.LENGTH_SHORT).show()
			}
		}
	}
}