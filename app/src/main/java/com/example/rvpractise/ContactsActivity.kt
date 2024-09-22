package com.example.rvpractise

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ContactsActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        val btSubmit = findViewById<Button>(R.id.btSubmit)

        btSubmit.setOnClickListener(){

            val name = findViewById<EditText>(R.id.etName).text.toString()
            val age = findViewById<EditText>(R.id.etAge).text.toString().toInt()

            val newPerson = Person(name, age)
            val output = Intent()
            output.putExtra("person", newPerson)
            setResult(Activity.RESULT_OK, output)
            finish()
        }
    }

}
