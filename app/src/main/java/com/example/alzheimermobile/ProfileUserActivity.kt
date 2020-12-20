package com.example.alzheimermobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileUserActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    lateinit var logout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_user)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("users")
        logout = findViewById<Button>(R.id.logout)
        loadProfile()
    }

    private fun loadProfile() {
          val user = auth.currentUser
        val userref = reference.child(user?.uid!!)
        userref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        } )

        logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@ProfileUserActivity, LogInActivity::class.java))
            finish()
        }

    }
}