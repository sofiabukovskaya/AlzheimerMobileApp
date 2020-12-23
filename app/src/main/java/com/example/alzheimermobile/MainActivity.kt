package com.example.alzheimermobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun Click(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun clickReg(view: View) {
        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun ClickLog(view: View) {
        val intent = Intent(this@MainActivity, LogInActivity::class.java)
        startActivity(intent)
    }

    fun go(view: View) {val intent = Intent(this@MainActivity, ToDoActivity::class.java)
        startActivity(intent)}


}