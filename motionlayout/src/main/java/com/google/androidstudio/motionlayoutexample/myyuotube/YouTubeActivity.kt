package com.google.androidstudio.motionlayoutexample.myyuotube

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.androidstudio.motionlayoutexample.R
import com.google.androidstudio.motionlayoutexample.youtubedemo.FrontPhotosAdapter
import com.google.androidstudio.motionlayoutexample.youtubedemo.YouTubeDemoViewHolder.CatRowViewHolder
import com.google.androidstudio.motionlayoutexample.youtubedemo.YouTubeDemoViewHolder.TextHeaderViewHolder
import com.google.androidstudio.motionlayoutexample.youtubedemo.YouTubeDemoViewHolder.TextDescriptionViewHolder

class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion5_activity)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout).apply {
            savedInstanceState
        }

        findViewById<RecyclerView>(R.id.recyclerview_front).apply {
            adapter = FrontPhotosAdapter().apply {
                itemClickListener = {
                    Toast.makeText(this@YouTubeActivity,"${it.adapterPosition}", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment, YouTubeFragment()).commit()
                }
            }

            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@YouTubeActivity)
        }

        val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
            MotionLayout.DEBUG_SHOW_PATH
        } else {
            MotionLayout.DEBUG_SHOW_NONE
        }
        motionLayout.setDebugMode(debugMode)
    }
}