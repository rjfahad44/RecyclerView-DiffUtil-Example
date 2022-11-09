package com.ft.recyclerview_diffutil_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ft.recyclerview_diffutil_example.R
import com.ft.recyclerview_diffutil_example.data.adapder.RvAdapter
import com.ft.recyclerview_diffutil_example.data.model.Person
import com.ft.recyclerview_diffutil_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val rvAdapter by lazy { RvAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val adapter = rvAdapter
        binding.rvList.adapter = adapter

        val p1 = Person(1, "Mohammad Fahad Alam", 26)
        val p2 = Person(2, "Mohammad Safatur-rasul", 26)
        val p3 = Person(3, "MD. Tarikul Islam", 26)
        val p4 = Person(4, "MD. Mesva ul-Islam", 26)
        val p5 = Person(5, "Tanvirul Rahman Sakib", 26)

        rvAdapter.setData(listOf(p1, p2, p3, p4, p5))
        var id: Int = 6
        var name: Int= 97
        var age:Int = 1
        binding.efabtnAddPerson.setOnClickListener {
            val p = Person(id++, name++.toChar().toString(), age++)
            rvAdapter.setData(listOf(p1, p2, p3, p4, p5, p))
        }
    }
}