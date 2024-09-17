package com.example.rvpractise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


data class Person(val name: String, val age: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        

        val contacts = createContacts()
        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)
        rvContacts.adapter = ContactsAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }


    private fun createContacts(): MutableList<Person> {
        val contacts: MutableList<Person> = mutableListOf<Person>()

        for(i: Int in 1..100){
            contacts.add(Person("Person $i", i))
        }

        return contacts
    }
}