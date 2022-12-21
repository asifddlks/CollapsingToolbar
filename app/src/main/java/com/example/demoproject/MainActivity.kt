package com.example.demoproject

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.children
import androidx.viewpager.widget.ViewPager
import com.example.demoproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //for trade button animation
    private var clicked = false
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.buy_sell_enter_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.buy_sell_exit_anim
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.appBar.children.forEach {
//            (it as? AppCompatButton)?.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
//            it.refreshDrawableState()
//        }

        binding.appBar.navigationIcon?.setTint(Color.GREEN)


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab 1"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab 2"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab 3"))

        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val pagerAdapter = PagerAdapter(
            supportFragmentManager, binding.tabLayout.tabCount
        )
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tabLayout))
       binding.tabLayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        binding.appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.e("TAG", "offset: $verticalOffset" )
            Log.e("TAG", "onCreate: ${appBarLayout.totalScrollRange}" )
           // testCaseView.alpha = (abs(verticalOffset)/(appBarLayout.totalScrollRange)).toFloat()
            val percentage = abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange
            Log.e("TAG", "onCreate: $percentage" )
           // binding.OneTwo.alpha = 1 - percentage
           binding.toolbarText.alpha = percentage
            binding.liLay.alpha = 1 - percentage * 2

        }

        binding.buttonTrade.setOnClickListener {
            showTradeButtonAnimation()
        }
    }

    //trade animation starts here
    private fun showTradeButtonAnimation() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.buttonBuy.isClickable = !clicked
            binding.buttonSell.isClickable = !clicked
            binding.buttonAdvance.isClickable = !clicked
        } else {
            binding.buttonBuy.isClickable = !clicked
            binding.buttonSell.isClickable = !clicked
            binding.buttonAdvance.isClickable = !clicked
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.buttonBuy.visibility = View.VISIBLE
            binding.buttonBuy.startAnimation(fromBottom)
            binding.buttonSell.visibility = View.VISIBLE
            binding.buttonSell.startAnimation(fromBottom)
            binding.buttonAdvance.visibility = View.VISIBLE
            binding.buttonAdvance.startAnimation(fromBottom)
           // changeTradeButtonState(clicked)
        } else {
            binding.buttonBuy.visibility = View.INVISIBLE
            binding.buttonBuy.startAnimation(toBottom)
            binding.buttonSell.visibility = View.INVISIBLE
            binding.buttonSell.startAnimation(toBottom)
            binding.buttonAdvance.visibility = View.INVISIBLE
            binding.buttonAdvance.startAnimation(toBottom)
           // changeTradeButtonState(clicked)
        }
    }
}