package com.example.gallery1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.gallery1.databinding.ActivityMainBinding
import com.example.gallery1.utils.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout
    private lateinit var vp2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = binding.tabLayout
        vp2 = binding.vp2
        val adapter = ViewPagerAdapter(this)
        val table_names = arrayOf(
            "ALL",
            "NEW",
            "TECHNOLOGY",
            "NATURE",
            "ANIMALS")

        vp2.adapter = adapter

        TabLayoutMediator(tabLayout, vp2) {
                tab, pos ->
            tab.text = table_names[pos]
        }.attach()
    }
}