package com.example.blureffect

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.appcompat.app.AppCompatActivity
import com.example.blureffect.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        blurEffect()
    }

    private fun blurEffect() {
      //  blurEffect управление 
        val radius = 20f;
        val decorView = window.decorView;
        val rootView = decorView.findViewById<ViewGroup>(android.R.id.content);
        val windowBackground = decorView.background;
        binding.blurView.setupWith(rootView, RenderScriptBlur(this)) // or RenderEffectBlur
            .setFrameClearDrawable(windowBackground) // Optional
            .setBlurRadius(radius)
        binding.blurView.outlineProvider = ViewOutlineProvider.BACKGROUND;
        binding.blurView.clipToOutline = true
    }
}