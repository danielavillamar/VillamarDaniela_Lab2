package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView


class Results : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)


        // Referencia de las variables en el main osea datos del intent

        // Dato del IMC
        // textView
        val resbmi=intent.getStringExtra("result")
        // setText
        var bmi: TextView=findViewById(R.id.bmires)

        // Mensaje a desplegar dependiendo del resultado
        // textView
        val messagebmi= intent.getStringExtra("message")
        // setText
        var message: TextView=findViewById(R.id.mensaje)

        // Image setup
        // ImageView
        val image =intent.getStringExtra("pic")
        val picimage: ImageView=findViewById(R.id.foto)


        // Escpecificacion que significa cada variable

        var intent=intent
        val resfinal =intent.getStringExtra("result")
        val menssagebmi =intent.getStringExtra("message")

        bmi.text= resfinal
        message.text=menssagebmi

        // Gracias al rolldice pude hacer esto
        // Se eligue la foto a desplegar en pantalla
        val drawableResource = when (image) {
            "0" -> R.drawable.under
            "1" -> R.drawable.normal
            "2" -> R.drawable.obeso
            "3" -> R.drawable.semiobeso
            "4" -> R.drawable.muyobeso
            else -> R.drawable.superobeso
        }
        picimage.setImageResource(drawableResource);

    }
}
