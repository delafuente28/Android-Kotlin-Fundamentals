package com.example.empty_activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        diceImage = findViewById(R.id.dice_image)

        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.nicknameText).setOnClickListener { updateNickname(it) }
    }

    private fun rollDice() {
//        Toast.makeText(this, "Button Clicked.", Toast.LENGTH_SHORT).show()
//        val resultText: TextView = findViewById(R.id.result_text)
        val randomId = (1..6).random()

        val drawableResource = when (randomId) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editNameText)
        val nicknameText = findViewById<TextView>(R.id.nicknameText)

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE //view is the button reference.
        nicknameText.visibility = View.VISIBLE

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editNameText)
        val nicknameText = findViewById<TextView>(R.id.nicknameText)

        editText.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE

    }
}