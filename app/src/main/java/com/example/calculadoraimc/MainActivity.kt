package com.example.calculadoraimc
import java.math.BigDecimal
import java.math.RoundingMode
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import android.view.View.OnLongClickListener




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // En este main se va a especificar tanto el mensaje a desplegar como la foto
        // Variables a utilizar
        var heightNum: EditText = findViewById(R.id.editText3)
        var weightNum: EditText = findViewById(R.id.editText5)
        val btnOpenActivity: Button = findViewById(R.id.button)
        var message: String
        var pic: String


        //this is the on long click listener part
        btnOpenActivity.setOnLongClickListener(OnLongClickListener {
            Toast.makeText(
                applicationContext,
                "IMC = Peso (kg) / altura (m)2  ",
                Toast.LENGTH_SHORT
            ).show()
            true
        })

            // OnclickListener para el boton de calcular resultados
            btnOpenActivity.setOnClickListener {
                val height: Double = heightNum.text.toString().toDouble() / 100
                val weight: Double = weightNum.text.toString().toDouble() / 2.2
                val res: String = BigDecimal(weight / (height * height)).setScale(2, RoundingMode.HALF_EVEN).toString()


                // Intent para abrir nueva actividad
                val intent = Intent(this, Results::class.java)


                // Definicion del mensaje a desplegar en pantalla
                message = if (res.toDouble() < 18.5) {
                    "Underweight"
                } else if (res.toDouble() > 18.5 && res.toDouble() < 24.9) {
                    "Normal"
                } else if (res.toDouble() > 24.9 && res.toDouble() < 29.9) {
                    "Overweight"
                } else if (res.toDouble() > 29.9 && res.toDouble() < 34.9) {
                    "Obesity class 1"
                } else if (res.toDouble() > 34.9 && res.toDouble() <= 39.9) {
                    "Obesity class 2"
                } else {
                    "Obesity class 3"
                }

                pic = if (res.toDouble() < 18.5) {
                    "0"
                } else if (res.toDouble() > 18.5 && res.toDouble() < 24.9) {
                    "1"
                } else if (res.toDouble() > 24.9 && res.toDouble() < 29.9) {
                    "2"
                } else if (res.toDouble() > 29.9 && res.toDouble() < 34.9) {
                    "3"
                } else if (res.toDouble() > 34.9 && res.toDouble() <= 39.9) {
                    "4"
                } else {
                    "5"
                }

                // Pasan la info de estas variables a la siguiente actividad
                intent.putExtra("result", res)
                intent.putExtra("message", message)
                intent.putExtra("pic", pic);
                startActivity(intent)
            }
        }
    }

