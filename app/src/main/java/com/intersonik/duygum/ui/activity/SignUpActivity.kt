package com.intersonik.duygum.ui.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.intersonik.duygum.R
import com.intersonik.duygum.data.model.SignupPoco
import com.intersonik.duygum.data.model.VerifySignupEmail
import com.intersonik.duygum.ui.viewmodel.SignUpViewModel
import com.intersonik.duygum.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var üyeOl: Button
    private lateinit var girisYap: Button
    private var email: String? = null
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        üyeOl = findViewById(R.id.kayit_üyeOl)
        girisYap = findViewById(R.id.kayit_girisyap)

        üyeOl.setOnClickListener {

            viewModel.postSignUp(
                SignupPoco(
                    findViewById<EditText>(R.id.email).text.toString(),
                    findViewById<EditText>(R.id.password).text.toString(),
                    findViewById<EditText>(R.id.againPassword).text.toString(),
                    findViewById<EditText>(R.id.name).text.toString(),
                    findViewById<EditText>(R.id.surname).text.toString(),
                    findViewById<EditText>(R.id.username).text.toString()
                )
            )


            viewModel.signUp.observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        when (it.data?.httpCode) {
                            200 -> {
                                email = findViewById<EditText>(R.id.email).text.toString()
                                showVerifyDialog()
                            }
                            404 -> {
                                Toast.makeText(this, it.data?.message, Toast.LENGTH_SHORT).show()
                            }
                            else -> Toast.makeText(this, it.data?.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    Status.ERROR -> Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })


        }

        girisYap.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun showVerifyDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.verify_email_code_dialog)

        val sendButton = dialog.findViewById<TextView>(R.id.btnSendVerifyCode)

        sendButton.setOnClickListener {
            viewModel.verifyEmailCode(
                VerifySignupEmail(
                    email,
                    dialog.findViewById<EditText>(R.id.etSignUpVerify).text.toString()
                )
            )
            viewModel.verifyEmailCode.observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        when (it.data?.httpCode) {
                            200 -> {
                                Toast.makeText(this, "KAYIT İŞLEMİ BAŞARILI", Toast.LENGTH_SHORT)
                                    .show()
                                startActivity(Intent(this, SignInActivity::class.java))
                                finish()
                                dialog.dismiss()
                            }
                            404 -> {
                                Toast.makeText(this, it.data?.message, Toast.LENGTH_SHORT).show()
                            }
                            else -> Toast.makeText(this, it.data?.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        dialog.show()
    }
}