package com.example.alzheimermobile

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.system.Os.link
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.LinkBuilder


class LogInActivity : AppCompatActivity() {
    lateinit var button2: Button
    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password: EditText
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    lateinit var checkBox: CheckBox


    private var email1: String? = null
    private var password1: String? = null
    private var role: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("users")

        email = findViewById<EditText>(R.id.editTextTextPersonName)
        password = findViewById<EditText>(R.id.editTextTextPassword)
        button2 = findViewById<Button>(R.id.button2)
        checkBox = findViewById<CheckBox>(R.id.checkBox)

        if(checkBox.isChecked) {
            role= true
        } else {
            role = false
        }

        button2!!.setOnClickListener { loginUser() }

        linkSetup()

    }

    private fun linkSetup() {
        val LoginLink = Link("Registration page!")
            .setTextColor(Color.parseColor("#259B24"))
            .setTextColorOfHighlightedLink(Color.parseColor("#0D3D0C"))
            .setHighlightAlpha(.4f)
            .setBold(true)
            .setOnClickListener {
                val intent = Intent(this@LogInActivity, RegisterActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        val demoText = findViewById<View>(R.id.textViewLogo2) as TextView

        LinkBuilder.on(demoText)
            .addLink(LoginLink)
            .build()
    }

    private fun loginUser() {
        email1 = email?.text.toString()
        password1 = password?.text.toString()
        if(checkBox.isChecked) {
            role= true
        } else {
            role = false
        }
        if (!TextUtils.isEmpty(email1) && !TextUtils.isEmpty(password1)) {
            auth!!.signInWithEmailAndPassword(email1!!, password1!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful && role == false) {
                        updateUI()
                    } else if(task.isSuccessful && role == true){
                        updateUI2()
                    }
                    else {
                        Toast.makeText(
                            this@LogInActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
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
    private fun updateUI2() {
        val intent = Intent(this@LogInActivity, DoctorProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun goToMain(view: View) {
        val intent = Intent(this@LogInActivity, MainActivity::class.java)
        startActivity(intent)

    }


}