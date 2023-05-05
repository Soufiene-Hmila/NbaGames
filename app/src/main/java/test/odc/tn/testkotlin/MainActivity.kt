package test.odc.tn.testkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import test.odc.tn.testkotlin.databinding.ActivityMainBinding
import test.odc.tn.testkotlin.fragment.GamesFragment
import test.odc.tn.testkotlin.fragment.MyFragmentPagerAdapter
import test.odc.tn.testkotlin.fragment.TeamsFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() {

        val adapter = MyFragmentPagerAdapter(supportFragmentManager)

        adapter.addFragment(GamesFragment(), "Games")
        adapter.addFragment(TeamsFragment(), "Teams")

        binding.viewpager.adapter = adapter

        binding.tabs.setupWithViewPager(binding.viewpager)

    }


}