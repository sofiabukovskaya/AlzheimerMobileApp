package com.example.alzheimermobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.*

class DoctorProfileActivity : AppCompatActivity() {
//    private lateinit var database: FirebaseDatabase
//    private lateinit var reference: DatabaseReference
//
//    private var tvFirstName: TextView? = null
//    private var tvLastName: TextView? = null
//    private var tvLastemail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_profile)
//        database = FirebaseDatabase.getInstance()
//        reference = database.getReference("users")
//
//        tvFirstName = findViewById<TextView>(R.id.textviewpationtname) as TextView
//        tvLastName = findViewById<TextView>(R.id.textviewpationtsurname) as TextView
//        tvLastemail = findViewById<TextView>(R.id.textviewpationtemail) as TextView



    }
//    override fun onStart() {
//        super.onStart()
//        reference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                tvFirstName!!.text = snapshot.child("name").value as String
//                tvLastName!!.text = snapshot.child("surname").value as String
//                tvLastemail!!.text = snapshot.child("email").value as String
//            }
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })
//    }


}