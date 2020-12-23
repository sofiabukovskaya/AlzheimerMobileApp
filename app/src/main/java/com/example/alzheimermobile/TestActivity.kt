package com.example.alzheimermobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TestActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference


    lateinit var yearAsANumber: EditText
    lateinit var season: EditText
    lateinit var dayAsANumber: EditText
    lateinit var monthAsANumber: EditText
    lateinit var date: EditText
    lateinit var country: EditText
    lateinit var city: EditText
    lateinit var region: EditText
    lateinit var homeAddress: EditText
    lateinit var numberOfTheBuilding: EditText
    lateinit var firstObject: EditText
    lateinit var secondObject: EditText
    lateinit var thirdObject: EditText
    lateinit var firstNumber: EditText
    lateinit var secondNumber: EditText
    lateinit var thirdNumber: EditText
    lateinit var fourthNumber: EditText
    lateinit var fifthNumber: EditText
    lateinit var firstObject2: EditText
    lateinit var secondObject2: EditText
    lateinit var thirdObject2: EditText
    lateinit var firstObject3: EditText
    lateinit var secondObject3: EditText
    lateinit var repeatPhrase: EditText
    lateinit var takeThePaper: CheckBox
    lateinit var foldIt: CheckBox
    lateinit var putIt: CheckBox
    lateinit var closeYourEyes: CheckBox
    lateinit var sentence: EditText
    lateinit var pictureCheck: CheckBox
    lateinit var submit: Button


    private var yearAsANumber1: String? = null
    private var season1: String? = null
    private var dayAsANumber1: String? = null
    private var monthAsANumber1: String? = null
    private var date1: String? = null
    private var country1: String? = null
    private var city1: String? = null
    private var region1: String? = null
    private var homeAddress1: String? = null
    private var numberOfTheBuilding1: String? = null
    private var firstObject1: String? = null
    private var secondObject1: String? = null
    private var thirdObject1: String? = null
    private var firstNumber1: String? = null
    private var secondNumber1: String? = null
    private var thirdNumber1: String? = null
    private var fourthNumber1: String? = null
    private var fifthNumber1: String? = null
    private var firstObject21: String? = null
    private var secondObject21: String? = null
    private var thirdObject21: String? = null
    private var firstObject31: String? = null
    private var secondObject31: String? = null
    private var repeatPhrase1: String? = null
    private var takeThePaper1: Int? = 0
    private var foldIt1: Int? = 0
    private var putIt1: Int? = 0
    private var closeYourEyes1: Int? = 0
    private var sentence1: String? = null
    private var pictureCheck1: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        initialise()
        submit.setOnClickListener {
           addResultsTest()
            val toast =  Toast.makeText(this@TestActivity, "Test passed, results sent to doctor.",
                    Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            goToProfile()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gobackmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_account -> goToAccount()
        }
        return super.onOptionsItemSelected(item)
    }
    fun goToAccount() {
        startActivity(Intent(this@TestActivity, ProfileUserActivity::class.java))
        onBackPressed()
        finish()
    }

    private fun initialise() {
        auth = FirebaseAuth.getInstance()
       database = FirebaseDatabase.getInstance()
        reference = database!!.reference!!.child("Test result")

        yearAsANumber = findViewById<EditText>(R.id.textviewfirst)
        season = findViewById<EditText>(R.id.textviewsecond)
        dayAsANumber = findViewById<EditText>(R.id.textviewthird)
        monthAsANumber = findViewById<EditText>(R.id.textview4)
        date = findViewById<EditText>(R.id.textview5)
        country = findViewById<EditText>(R.id.textview6)
        city = findViewById<EditText>(R.id.textview7)
        region = findViewById<EditText>(R.id.textview8)
        homeAddress = findViewById<EditText>(R.id.textview9)
        numberOfTheBuilding = findViewById<EditText>(R.id.textview10)
        firstObject = findViewById<EditText>(R.id.textview11)
        secondObject = findViewById<EditText>(R.id.textview12)
        thirdObject = findViewById<EditText>(R.id.textview13)
        firstNumber = findViewById<EditText>(R.id.textview14)
        secondNumber = findViewById<EditText>(R.id.textview15)
        thirdNumber = findViewById<EditText>(R.id.textview16)
        fourthNumber = findViewById<EditText>(R.id.textview17)
        fifthNumber = findViewById<EditText>(R.id.textview18)
        firstObject2 = findViewById<EditText>(R.id.textview19)
        secondObject2 = findViewById<EditText>(R.id.textview20)
        thirdObject2 = findViewById<EditText>(R.id.textview21)
        firstObject3 = findViewById<EditText>(R.id.textview22)
        secondObject3 = findViewById<EditText>(R.id.textview23)
        repeatPhrase = findViewById<EditText>(R.id.textview24)
        takeThePaper = findViewById<CheckBox>(R.id.checkbox1)
        foldIt = findViewById<CheckBox>(R.id.checkbox2)
        putIt = findViewById<CheckBox>(R.id.checkbox3)
        closeYourEyes = findViewById<CheckBox>(R.id.checkbox4)
        sentence = findViewById<EditText>(R.id.textview25)
        pictureCheck = findViewById<CheckBox>(R.id.checkbox5)
        submit = findViewById<Button>(R.id.buttonSub)

    }

    private fun addResultsTest() {
        yearAsANumber1 = yearAsANumber?.text.toString()
        season1 = season?.text.toString()
        dayAsANumber1 = dayAsANumber?.text.toString()
        monthAsANumber1 = monthAsANumber?.text.toString()
        date1 = date?.text.toString()
        country1 = country?.text.toString()
        city1 = city?.text.toString()
        region1 = region?.text.toString()
        homeAddress1 = homeAddress?.text.toString()
        numberOfTheBuilding1 = numberOfTheBuilding?.text.toString()
        firstObject1 = firstObject?.text.toString()
        secondObject1 = secondObject?.text.toString()
        thirdObject1 = thirdObject?.text.toString()
        firstNumber1 = firstNumber?.text.toString()
        secondNumber1 = secondNumber?.text.toString()
        thirdNumber1 = thirdNumber?.text.toString()
        fourthNumber1 = fourthNumber?.text.toString()
        fifthNumber1 = fifthNumber?.text.toString()
        firstObject21 = firstObject2?.text.toString()
        secondObject21 = secondObject2?.text.toString()
        thirdObject21 = thirdObject2?.text.toString()
        firstObject31 = firstObject3?.text.toString()
        secondObject31 = secondObject3?.text.toString()
        repeatPhrase1 = repeatPhrase?.text.toString()
        sentence1 = sentence?.text.toString()


        if(takeThePaper.isChecked){
            takeThePaper1 = 1
        }
        if(foldIt.isChecked) {
            foldIt1 = 1
        }

        if(putIt.isChecked) {
            putIt1 = 1
        }
        if(closeYourEyes.isChecked) {
            closeYourEyes1 = 1
        }
        if(pictureCheck.isChecked) {
            pictureCheck1 = 1
        }

        val userId = auth!!.currentUser!!.uid
        val tableId = auth!!.currentUser!!.uid

        val currentUserDb = reference!!.child(userId)

        currentUserDb.child("user ID").setValue(userId)
        currentUserDb.child("year as a number: ").setValue(yearAsANumber1)
        currentUserDb.child("day as a number: ").setValue(dayAsANumber1)
        currentUserDb.child("month as a number: ").setValue(monthAsANumber1)
        currentUserDb.child("date: ").setValue(date1)
        currentUserDb.child("country: ").setValue(country1)
        currentUserDb.child("region: ").setValue(region1)
        currentUserDb.child("city: ").setValue(city1)
        currentUserDb.child("home address: ").setValue(homeAddress1)
        currentUserDb.child("number of the building: ").setValue(numberOfTheBuilding1)
        currentUserDb.child("first object: ").setValue(firstObject1)
        currentUserDb.child("second object: ").setValue(secondObject1)
        currentUserDb.child("third object: ").setValue(thirdObject1)
        currentUserDb.child("first number: ").setValue(firstNumber1)
        currentUserDb.child("second number: ").setValue(secondNumber1)
        currentUserDb.child("third number: ").setValue(thirdNumber1)
        currentUserDb.child("fourth number: ").setValue(fourthNumber1)
        currentUserDb.child("fifth number: ").setValue(fifthNumber1)
        currentUserDb.child("first object ").setValue(firstObject21)
        currentUserDb.child("second object ").setValue(secondObject21)
        currentUserDb.child("third object ").setValue(thirdObject21)
        currentUserDb.child("first thing: ").setValue(firstObject31)
        currentUserDb.child("second thing: ").setValue(secondObject31)
        currentUserDb.child("repeat phrase ").setValue(repeatPhrase1)
        currentUserDb.child("take the paper in your right hand: ").setValue(takeThePaper1)
        currentUserDb.child("fold it in half: ").setValue(foldIt1)
        currentUserDb.child("put it on the floor: ").setValue(putIt1)
        currentUserDb.child("close your eyes: ").setValue(closeYourEyes1)
        currentUserDb.child("sentence: ").setValue(sentence1)
        currentUserDb.child("picture drawn: ").setValue(pictureCheck1)




    }

    private fun goToProfile(){
        val intent = Intent(this@TestActivity, ProfileUserActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}