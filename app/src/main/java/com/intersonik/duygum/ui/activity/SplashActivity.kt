package com.intersonik.duygum.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.intersonik.duygum.R

class SplashActivity : AppCompatActivity() {
    private  val SplashTime:Long =3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed( {
            startActivity(Intent(this, BilgilendirmeActivity::class.java))
            finish()
        },SplashTime)

    }
}