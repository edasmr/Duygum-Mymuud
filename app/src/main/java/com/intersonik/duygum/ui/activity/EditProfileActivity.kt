package com.intersonik.duygum.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.intersonik.duygum.R
import com.intersonik.duygum.data.model.Cookie
import com.intersonik.duygum.data.model.SaveProfileEditPoco
import com.intersonik.duygum.data.model.SignupPoco
import com.intersonik.duygum.ui.viewmodel.EditProfileViewModel
import com.intersonik.duygum.ui.viewmodel.SignUpViewModel
import com.intersonik.duygum.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileActivity : AppCompatActivity() {
    private lateinit var kuladi:EditText
    private lateinit var nameAndSurname:EditText
    private lateinit var bio:EditText
    private lateinit var location:EditText
    private lateinit var birthday:EditText
    private lateinit var update:Button

    private val viewModel: EditProfileViewModel by viewModels()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        kuladi =  findViewById(R.id.kuladi)
        nameAndSurname =  findViewById(R.id.nameAndSurname)
        bio =  findViewById(R.id.bio)
        location = findViewById(R.id.location)
        birthday = findViewById(R.id.birthday)
        update = findViewById(R.id.update)

        viewModel.getUserInfo(Cookie(accessToken = viewModel.getToken()))

        viewModel.userInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS ->{
                    kuladi.setText(it.data?.username.toString())
                    nameAndSurname.setText((it.data?.name)+(it.data?.surname))
                    bio.setText(it.data?.bio)
                    location.setText(it.data?.location)
                    birthday.setText(it.data?.birthDate)
                }

                Status.ERROR ->{

                }
            }
        }

        update.setOnClickListener {
            viewModel.postEditProfile( // bu kısım net değil
                SaveProfileEditPoco(
                 viewModel.getToken(),
                    "",
                    bio.text.toString(),
                    location.text.toString(),
                    kuladi.text.toString(),
                    birthday.text.toString(),
                    nameAndSurname.text.toString(),
                    nameAndSurname.text.toString(),
                    true,

                )
            )

        }
    }
}