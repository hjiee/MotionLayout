package com.google.androidstudio.motionlayoutexample.myyuotube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.androidstudio.motionlayoutexample.R
import com.google.androidstudio.motionlayoutexample.youtubedemo.FrontPhotosAdapter

class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion5)
        supportFragmentManager.beginTransaction().replace(R.id.fragment,YouTubeFragment()).commit()

        findViewById<RecyclerView>(R.id.recyclerview_front).apply {
            adapter = FrontPhotosAdapter()
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@YouTubeActivity)
        }
    }
}