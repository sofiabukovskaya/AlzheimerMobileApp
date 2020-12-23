package com.example.alzheimermobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileUserActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    private var tvFirstName: TextView? = null
    private var tvLastName: TextView? = null
    private var tvEmail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_user)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        reference = database!!.reference!!.child("users")
        tvFirstName = findViewById<TextView>(R.id.textViewName) as TextView
        tvLastName = findViewById<TextView>(R.id.textViewSurname) as TextView
        tvEmail = findViewById<TextView>(R.id.textViewEmail) as TextView
//        loadProfile()
    }


    override fun onStart() {
        super.onStart()
        val mUser = auth!!.currentUser
        val mUserReference = reference!!.child(mUser!!.uid)
        tvEmail!!.text = mUser.email
        mUserReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvFirstName!!.text = snapshot.child("name").value as String
                tvLastName!!.text = snapshot.child("surname").value as String
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_logout -> logoutfunction()
        }
        return super.onOptionsItemSelected(item)
    }

//    private fun loadProfile() {
//          val user = auth.currentUser
//        val userref = reference.child(user?.uid!!)
//        userref.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        } )
//
//
//    }
    fun logoutfunction() {
        auth.signOut()
        startActivity(Intent(this@ProfileUserActivity, LogInActivity::class.java))
        onBackPressed()
        finish()
    }

    fun goToTestPage(view: View) {
        val intent = Intent(this@ProfileUserActivity, TestActivity::class.java)
        startActivity(intent)
    }

    fun goToDo(view: View) {
        val intent = Intent(this@ProfileUserActivity, ToDoActivity::class.java)
        startActivity(intent)
    }

    fun openNotes(view: View) {val intent = Intent(this@ProfileUserActivity, NotesActivity::class.java)
        startActivity(intent)}


}