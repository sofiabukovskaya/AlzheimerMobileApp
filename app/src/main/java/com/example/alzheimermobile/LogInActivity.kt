package com.example.alzheimermobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

class LogInActivity : AppCompatActivity() {
    lateinit var button2: Button
    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password: EditText
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference


    private var email1: String? = null
    private var password1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("users")

        email = findViewById<EditText>(R.id.editTextTextPersonName)
        password = findViewById<EditText>(R.id.editTextTextPassword)
        button2 = findViewById<Button>(R.id.button2)


        button2!!.setOnClickListener { loginUser() }
    }
    private fun loginUser() {
        email1 = email?.text.toString()
        password1 = password?.text.toString()
        if (!TextUtils.isEmpty(email1) && !TextUtils.isEmpty(password1)) {
            auth!!.signInWithEmailAndPassword(email1!!, password1!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        updateUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this@LogInActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@LogInActivity, ProfileUserActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun goToMain(view: View) {
        val intent = Intent(this@LogInActivity, MainActivity::class.java)
        startActivity(intent)

    }


}