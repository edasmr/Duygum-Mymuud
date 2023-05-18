package com.intersonik.duygum.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.intersonik.duygum.R

class BilgilendirmeActivity : AppCompatActivity() {
    private lateinit var girisyap:Button
    private lateinit var üyeol:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilgilendirme)
        girisyap =findViewById(R.id.b_girisyap)
        üyeol =findViewById(R.id.b_üyeol)

        girisyap.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
        üyeol.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

    }
}