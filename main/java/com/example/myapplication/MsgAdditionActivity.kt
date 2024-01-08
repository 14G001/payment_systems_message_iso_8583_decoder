package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MsgAdditionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg_addition)

        findViewById<AppCompatButton>(R.id.bAddMsg).setOnClickListener {
            val textoIngresado = findViewById<AppCompatEditText>(R.id.tiMsgInput).text.toString()
            Log.i("xd", "¡Se hizo clic en el botón! Mensaje: ${textoIngresado}")
            IsoMessages.getInstance().add(textoIngresado)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}