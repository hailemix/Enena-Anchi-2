package com.afc_quotes.amharic_love_quotes

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.IOException


class Donate : AppCompatActivity() {

    private val numberToSend = "*806*0908766344*1%23"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.donate_page)

        val donateButton = findViewById<Button>(R.id.donate_button)

        donateButton.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "መጀመሪያ የስልክዎ Settings ዉስጥ App Permissions የሚለዉን በመንካት Phone Call የሚለዉን ያብሩ!", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$numberToSend"))
                    startActivity(intent)
                } catch (e: IOException) {
                    print(e)
                    Toast.makeText(this, "Network is Not Found", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                Toast.makeText(this, "እባክዎ አሁን የሚመጣዉ ሴቲንግ ላይ Allow የሚለዉን ይጫኑ!", Toast.LENGTH_LONG).show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
