package com.example.rvpractise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(val context: Context, val contacts: MutableList<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = contacts.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Person = contacts[position]
        holder.bind(contact)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)

        fun bind(contact: Person) {
            tvName.text = contact.name
            tvAge.text = "Age: $contact.age"
        }

    }
}
