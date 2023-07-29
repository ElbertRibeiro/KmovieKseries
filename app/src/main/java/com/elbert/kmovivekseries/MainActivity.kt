package com.elbert.kmovivekseries

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var editTextTitle: EditText
    private lateinit var buttonAdd: Button
    private lateinit var linearLayoutReminders: LinearLayout
    private val reminders = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lembrete)

        editTextTitle = findViewById(R.id.editTextTitle)
        buttonAdd = findViewById(R.id.buttonAdd)
        linearLayoutReminders = findViewById(R.id.linearLayoutReminders)

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
        linearLayoutReminders.removeAllViews()

        for ((index, reminder) in reminders.withIndex()) {
            val textViewReminder = TextView(this)
            textViewReminder.text = reminder
            linearLayoutReminders.addView(textViewReminder)

            val checkBox = CheckBox(this)
            checkBox.text = "Visto"
            checkBox.id = View.generateViewId()
            checkBox.setOnClickListener { onCheckBoxClicked(index) }
            linearLayoutReminders.addView(checkBox)
        }
    }

    private fun onCheckBoxClicked(reminderIndex: Int) {
        val reminder = reminders[reminderIndex]
        if (reminder.endsWith(" (Visto)")) {
            reminders[reminderIndex] = reminder.removeSuffix(" (Visto)")
        } else {
            reminders[reminderIndex] = "$reminder (Visto)"
        }
    }
}