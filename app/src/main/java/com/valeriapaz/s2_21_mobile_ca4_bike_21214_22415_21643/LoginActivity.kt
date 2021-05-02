package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_j_c_decaux_bike.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : BaseActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
//        auth.signOut()


        btnLogin.setOnClickListener {
            userLogin()
        }

        btnGoRegister.setOnClickListener {
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

    }


    // checking if the user is logged in when the App is launched
    override fun onStart() {
        super.onStart()
        checkLoggedInState()
    }

    // function to login
    private fun userLogin() {
        val email = etEmailInput.text.toString()
        val password = etPasswordInput.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main) {
                        checkLoggedInState()
                    }
                } catch (exception: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, exception.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, R.string.login_error, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    // checking the log status
    private fun checkLoggedInState() {
        if (auth.currentUser == null) {
//            tvLog.text = getString(R.string.login_error)
        } else {
            Intent(this, MenuActivity::class.java).also {
                startActivity(it)
            }
        }

    }

}


