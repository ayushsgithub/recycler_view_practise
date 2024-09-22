package com.example.rvpractise

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable


data class Person(val name: String, val age: Int): Serializable

lateinit var contacts: MutableList<Person>
lateinit var adapter: ContactsAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        

        contacts = createContacts()
        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)

        adapter = ContactsAdapter(this, contacts)

        rvContacts.adapter = adapter
        rvContacts.layoutManager = LinearLayoutManager(this)
    }


    private fun createContacts(): MutableList<Person> {
        val contacts: MutableList<Person> = mutableListOf<Person>()

        for(i: Int in 1..100){
            contacts.add(Person("Person $i", i))
        }

        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.miAdd){
            val intent = Intent(this, ContactsActivity:: class.java)
            startActivityForResult(intent, 42)
            return true
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 42 && resultCode == Activity.RESULT_OK){
            val newPerson = data?.getSerializableExtra("person") as Person
            contacts.add(0, newPerson)
            adapter.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}