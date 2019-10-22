package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    // get diceImage var
    // lateinit promises the compiler that diceImage will be initialized before calling ops on it
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // R class called in findViewByID is short for Resources
        // since the android app res folder has the layout folder holding activity_main.xml id's
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's roll"
        rollButton.setOnClickListener {

            // call a toast, similar to a print() statement
//            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

            // call rollDice()
            rollDice()
        }

        // get diceImage var
        diceImage = findViewById(R.id.dice_image)
    }

    // create rollDice()
    private fun rollDice() {

        // display message when dice is rolled
        // this was replaced to show random number text
        //        resultText.text = "Dice rolled"

        // R class called in findViewByID is short for Resources
        // since the android app res folder has the layout folder holding activity_main.xml id's
        // resultText has been replaced to show the dice image instead of the text
        // val resultText: TextView = findViewById(R.id.result_text)

        // get a random number
        val randomInt = Random().nextInt(6) + 1

        // updated resultText with the random number text
        // this was replaced in favor of showing the dice image instead of text
        // resultText.text = randomInt.toString()

        // get appropriate dice_image based corresponding to new random number
        val drawableResource = when {
            randomInt == 1 -> R.drawable.dice_1
            randomInt == 2 -> R.drawable.dice_2
            randomInt == 3 -> R.drawable.dice_3
            randomInt == 4 -> R.drawable.dice_4
            randomInt == 5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // get diceImage view, and set image to current dice image
        // could create diceImage val here, but it's expensive to findViewById every roll
        // so instead, diceImage was created in onCreate above as a field
        // val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}
