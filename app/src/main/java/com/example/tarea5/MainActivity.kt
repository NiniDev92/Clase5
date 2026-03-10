package com.example.tarea5

import android.media.MediaPlayer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val direccion = findViewById<EditText>(R.id.editDireccion)
        val check = findViewById<CheckBox>(R.id.checkConfirmar)
        val boton = findViewById<Button>(R.id.botonAbrir)
        val musica = MediaPlayer.create(this, R.raw.musica)
        musica.start()

        boton.setOnClickListener {

            val texto = direccion.text.toString()

            var url = texto
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            val estado = if (check.isChecked) {
                "La casilla está marcada"
            } else {
                "La casilla NO está marcada"
            }

            Toast.makeText(this,
                "$estado - Dirección: $url",
                Toast.LENGTH_LONG).show()

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("direccionWeb", url)

            startActivity(intent)
        }
    }
}