package com.example.cm.mynewapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var datas: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

        textView.setText("Hello Kotlin")

        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        var adapter: RecyclerAdapter = RecyclerAdapter(datas)
        mRecyclerView!!.setAdapter(adapter)
    }

    public fun getData(): Unit {
        datas = ArrayList<String>()
        for (i in 1..100) {
            datas!!.add(i.toString())
        }
    }

}
