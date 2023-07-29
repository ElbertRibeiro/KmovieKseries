package com.elbert.kmovivekseries

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var textViewReminders: TextView
    private lateinit var buttonAdd: Button

    private val reminders = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lembrete)

        editTextTitle = findViewById(R.id.editTextTitle)
        textViewReminders = findViewById(R.id.textViewReminders)
        buttonAdd = findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val title = editTextTitle.text.toString().trim()
            if (title.isNotEmpty()) {
                reminders.add(title)
                updateReminders()
                editTextTitle.text.clear()
            }
        }
    }

    private fun updateReminders() {
        val reminderText = buildString {
            for (reminder in reminders) {
                append("$reminder\n")
            }
        }
        textViewReminders.text = reminderText
    }
}