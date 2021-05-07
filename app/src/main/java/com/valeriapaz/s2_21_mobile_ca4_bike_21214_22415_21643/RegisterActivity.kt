package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

/*

DORSET COLLEGE

OBJECT ORIENTED PROGRAMING - CA3

Lecturer: John Rowley

STUDENTS:
Marcus Vinicius de Freitas Moura – 22415
Valeria Cardoso da Paz – 21214
Alexson Oliveira Silva – 21643




 */


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.tvRegistrarion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class RegisterActivity : BaseActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {
            userRegistration()
        }

    }

    // this function deals with user registration
    private fun userRegistration() {
        val firstName = etFirstName.text
        val lastName = etLastName.text
        val email = etEmailRegister.text.toString()
        val password = etPasswordRegister.text.toString()
        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main) {
                        checkLoggedInState()
                    }
                } catch (exception: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity, exception.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }


    // checking the log status
    private fun checkLoggedInState() {
        if (auth.currentUser == null) {
//                Toast.makeText(this@LoginActivity, R.string.login_error, Toast.LENGTH_SHORT).show()
            tvRegistrarion.text = getString(R.string.login_error)
        } else {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}