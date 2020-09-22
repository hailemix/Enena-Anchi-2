package com.afc_quotes.amharic_love_quotes

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.*
import androidx.core.content.ContextCompat
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import java.io.IOException

class MainActivity : AppCompatActivity() {


    private lateinit  var viewPager: ViewPager2

    companion object {
        private var mySound: MediaPlayer? = null
        var musicButton : Button ? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicButton = findViewById(R.id.toggle)
        viewPager = findViewById(R.id.pager)
        val myAdapter = MyPagerAdapter(this)
        viewPager.adapter = myAdapter
        val statusBarSetting: Window = this.window

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            statusBarSetting.statusBarColor = ContextCompat.getColor(this, R.color.deep_dark)
        }

        musicButton!!.setOnClickListener {
            go()
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF454545")))
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val url = "https://ethiocoderzone.wordpress.com/2018/10/11/%E1%88%9D%E1%88%AD%E1%8C%A5-%E1%8B%A8%E1%8A%A0%E1%88%88%E1%88%9D-%E1%8C%A5%E1%89%85%E1%88%B6%E1%89%BD-world-quotes-for-ethiopians/"

        when (item.itemId) {

            R.id.action_privacy -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)

                } catch (e: Throwable) {
                    print("Error in Connecting to the server.Please check at $e")
                }
                return true
            }
            R.id.my_youtube_video -> {

                val videoUrl = "https://youtu.be/63klY8F3Xp8"
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                    startActivity(intent)
                } catch (e: Throwable) {
                    print("Error in Connecting to the server.Please check at $e")
                }
                return true
            }
            R.id.action_settings -> {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ethiocoders.dev"))
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun go() {
        if (mySound == null) {
            mySound = MediaPlayer.create(this@MainActivity, R.raw.sleep)
        }
        if (mySound!!.isPlaying) {
            mySound!!.stop()
            try {
                mySound!!.prepare()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            mySound!!.seekTo(0)

        } else {
            mySound!!.start()
        }

    }

}







