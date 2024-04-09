package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() { // List of Historical figures along with ages of death

    enum class Historicalfigures(val age: Int, val description: String) {
        FIGURE_1(age = 20, description = "Joan of Arc died age 20 french heroine"),
        FIGURE_2(age = 32, description = "Alexander the great died age 32 a military genius"),
        FIGURE_3(age = 37, description = "Vincent Van Gogh died age 37 impressionist painter"),
        FIGURE_4(age = 55, description = "Emily Dickinson died age 55 american poet"),
        FIGURE_5(age = 67, description = "Leonardo Da Vinci died age 67 italian polymath"),
        FIGURE_6(age = 76, description = "Albert Einstein died at age 76 a theoretical physicist"),
        FIGURE_7(age = 78, description = "Mahatma Gandhi died age 78 a political icon"),
        FIGURE_8(age = 88, description = "Michelangelo died age 88 renaissance painter"),
        FIGURE_9(age = 95, description = "Nelson Mandela died age 95 former president of south africa"),
        FIGURE_10(age = 100, description = "Bob Hope died age 100 comedian and actor"),
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup layout components
        val enterAge = findViewById<EditText>(R.id.enterAge)
        val result = findViewById<Button>(R.id.constraint_layout)
        val clear = findViewById<Button>(R.id.clear)
        var infoBox = findViewById<TextView>(R.id.textView3)

        val Age = enterAge.toString().toInt()

        if (Age in 20..100) {

            val figureAge = MainActivity.Historicalfigures.values().map { it.age }

            val figures = when (Age) {

                in figureAge -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age }
                    listOf("You are ($Age),the same age as ${figure?.description}")
                }

                in figureAge.map { it - 1 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age - 1 }
                    listOf("You are around the same age as s${figure?.description}")
                }

                in figureAge.map { it - 2 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age - 2 }
                    listOf("You are around the same age as ${figure?.description}")
                }

                in figureAge.map { it - 3 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age - 3 }
                    listOf("You are around the same age as ${figure?.description}")
                }

                in figureAge.map { it + 1 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age + 1 }
                    listOf("You are around the same age as ${figure?.description}")
                }

                in figureAge.map { it + 2 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age + 2 }
                    listOf("You are around the same age as ${figure?.description}")
                }

                in figureAge.map { it + 3 } -> {
                    val figure = MainActivity.Historicalfigures.values().find { it.age == Age + 3 }
                    listOf("You are around the same age as ${figure?.description}")
                }

                else -> listOf(" No  figure found for age $Age.")
            }
            infoBox.text = figures.joinToString("\n")
        } else {
            infoBox.text = "please enter number within range (20-100) "
        }

        clear?.setOnClickListener() {
            enterAge.text.clear()
            infoBox.text = ""
        }
    }
}
