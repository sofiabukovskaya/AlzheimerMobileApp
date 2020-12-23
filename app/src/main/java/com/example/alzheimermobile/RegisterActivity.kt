package com.example.alzheimermobile

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.LinkBuilder


class RegisterActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    companion object {
        const val TAG = "RegisterActivity"
    }
    lateinit var name: EditText
    lateinit var username: EditText
    lateinit var surname: EditText
    lateinit var emailEditText: EditText
    lateinit var spinnerInfo: Spinner
    lateinit var passwordEditText: EditText
    lateinit var buttonRegister: Button
    lateinit var textViewLogo: TextView


    //global variables
    private var firstName: String? = null
    private var username1: String? = null
    private var surname1: String? = null
    private var email: String? = null
    private var password: String? = null
    private var role: String? = null

       private lateinit var database: FirebaseDatabase
       private lateinit var reference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        spinnerFun()
        auth = FirebaseAuth.getInstance()

        name = findViewById<EditText>(R.id.name)
        username = findViewById<EditText>(R.id.username)
        surname = findViewById<EditText>(R.id.surname)
        emailEditText = findViewById<EditText>(R.id.email)
        spinnerInfo = findViewById<Spinner>(R.id.spinner)
        passwordEditText = findViewById<EditText>(R.id.password)
        buttonRegister = findViewById<Button>(R.id.buttonRegister)
        textViewLogo = findViewById<TextView>(R.id.textViewLogo)
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("users")
        buttonRegister.setOnClickListener {
              createNewAccount()

        }
         linkSetup()
    }

    private fun linkSetup() {
        val LoginLink = Link("Login Page!")
            .setTextColor(Color.parseColor("#259B24"))
            .setTextColorOfHighlightedLink(Color.parseColor("#0D3D0C"))
            .setHighlightAlpha(.4f)
            .setBold(true)
            .setOnClickListener {
                val intent = Intent(this@RegisterActivity, LogInActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        val demoText = findViewById<View>(R.id.textViewLogo) as TextView

        LinkBuilder.on(demoText)
            .addLink(LoginLink)
            .build()
    }

    private fun createNewAccount() {
        firstName = name?.text.toString()
        username1 = username?.text.toString()
        email = emailEditText?.text.toString()
        surname1 = surname?.text.toString()
        password = passwordEditText?.text.toString()
        role = spinnerInfo?.selectedItem.toString()
        auth!!
            .createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val userId = auth!!.currentUser!!.uid
                    //Verify Email
                    verifyEmail();
                    //update user profile information
                    val currentUserDb = reference!!.child(userId)
                    currentUserDb.child("name").setValue(firstName)
                    currentUserDb.child("surname").setValue(surname1)
                    currentUserDb.child("username").setValue(username1)
                    currentUserDb.child("email").setValue(email)
                    currentUserDb.child("password").setValue(password)
                    currentUserDb.child("role").setValue(role)
                    updateUserInfoAndUI()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this@RegisterActivity, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@RegisterActivity, LogInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {
        val mUser = auth!!.currentUser;
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@RegisterActivity,
                        "Verification email sent to " + mUser.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this@RegisterActivity,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }



    private fun spinnerFun () {
         var roles = arrayOf("Doctor", "Patient")
         val spinner: Spinner = findViewById(R.id.spinner)
         spinner.prompt = "Choose a role..."
         val adapter: ArrayAdapter<String> =
                 ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roles)
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         spinner.adapter = adapter
     }

    fun goToMain(view: View) {
        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
        startActivity(intent)
    }


}