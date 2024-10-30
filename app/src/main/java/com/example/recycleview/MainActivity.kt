package com.example.recycleview

import Adapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var newBookList: ArrayList<DataClass>
private lateinit var newRecycleView: RecyclerView
private lateinit var bookAdapter: Adapter



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        newRecycleView = findViewById(R.id.newRecycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)

        newBookList = arrayListOf()

        getBookData()

        bookAdapter = Adapter(newBookList)
        newRecycleView.adapter = bookAdapter
    }

    private fun getBookData() {
        newBookList.add(DataClass(R.drawable.img, "Cyberpunk 2077", "Игра1"))
        newBookList.add(DataClass(R.drawable.img2, "Cuphead", "Игра2"))
        newBookList.add(DataClass(R.drawable.img3, "Hollow Knight", "Игра3"))


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}