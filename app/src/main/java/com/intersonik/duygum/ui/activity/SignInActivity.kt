package com.intersonik.duygum.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.intersonik.duygum.R
import com.intersonik.duygum.data.model.Login
import com.intersonik.duygum.data.preferences.MyPreferences
import com.intersonik.duygum.di.PreferencesModule
import com.intersonik.duygum.ui.viewmodel.SignInViewModel
import com.intersonik.duygum.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    private lateinit var girisYap: Button
    private lateinit var üyeOl: Button

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        girisYap = findViewById(R.id.giris_girisyap)
        üyeOl = findViewById(R.id.giris_üyeOl)


        üyeOl.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
        girisYap.setOnClickListener {

            viewModel.postLogin(
                Login(
                    findViewById<EditText>(R.id.email).text.toString(),
                    findViewById<EditText>(R.id.password).text.toString()
                )
            )

            viewModel.login.observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        when (it.data?.httpCode) {
                            200 -> {
                                viewModel.setToken(it.data.message)
                                Toast.makeText(this, "HOŞGELDİNİZ", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                            404 -> {
                                Toast.makeText(this, it.data?.message, Toast.LENGTH_SHORT).show()

                            }
                        }
                    }
                    Status.ERROR -> Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })

        }
    }
}