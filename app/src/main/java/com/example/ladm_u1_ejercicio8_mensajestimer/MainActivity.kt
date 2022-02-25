package com.example.ladm_u1_ejercicio8_mensajestimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.ladm_u1_ejercicio8_mensajestimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var _binding: ActivityMainBinding

    var contador = 0

    val frases = arrayOf<String>(
        "Los ojos hacen más ejercicio que las piernas",
        "Nuestro aroma es tan único como nuestras huellas digitales",
        "La lengua nunca descansa",
        "Los bebés pueden curar a sus madres en el vientre",
        "Las jirafas no emiten ningún sonido"
    )

    val timer = object : CountDownTimer(10000, 3000) {
        override fun onTick(p0: Long) {
            // Se ejecuta cuando el lapso = 0, en este caso es 1,000
            _binding.frases.setText(frases[contador++] + "")
            if (contador == frases.size) contador = 0
        }

        override fun onFinish() {
            // Se ejecuta cuando el tiempoTotal = 0, en este caso es 20,000
            start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.iniciar.setOnClickListener {
            timer.start()
        }
    }
}