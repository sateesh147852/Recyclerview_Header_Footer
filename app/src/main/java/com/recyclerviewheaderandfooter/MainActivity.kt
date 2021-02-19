package com.recyclerviewheaderandfooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewheaderandfooter.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var names : ArrayList<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initViews()
    }

    private fun initViews(){
        val linearLayoutManager = LinearLayoutManager(this)
        val headerFooterAdapter = HeaderFooterAdapter(names)
        binding.rvHeaderFooter.layoutManager = linearLayoutManager
        binding.rvHeaderFooter.adapter = headerFooterAdapter

    }

    private fun initData(){
        names = ArrayList()
        names.add("Sateesh")
        names.add("Ramesh")
        names.add("Sumit")
        names.add("aravind")
        names.add("ananya")
        names.add("kartik")
        names.add("Suresh")
        names.add("hardik")
        names.add("kalmesh")
        names.add("Sudeep")
        names.add("Dharshan")
        names.add("Akash")
        names.add("Anand")
    }
}