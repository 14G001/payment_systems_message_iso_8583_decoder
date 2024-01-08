package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplication.IsoMessages

class MainActivity : AppCompatActivity() {
    
    var selectedItemPos: Int? = null;
    var list: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("xd", "OPCIONES: ${IsoMessages.getInstance().get()}")
        list = findViewById(R.id.listaDeOpciones)
        list!!.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, IsoMessages.getInstance().get())

        findViewById<AppCompatButton>(R.id.bAddMsg).setOnClickListener {
            startActivity(Intent(this, MsgAdditionActivity::class.java))
        }

        list!!.setOnItemClickListener { parent, view, position, id ->
            val resources = getResources()
            val selectedOptionText: String? = parent.getItemAtPosition(position) as String
            Log.i("xd", "Selected option: $selectedOptionText")
            if (selectedItemPos == position) {
                selectedItemPos = null;
                view.setBackgroundColor(resources.getColor(R.color.white))
            } else {
                if (selectedItemPos != null) {
                    parent.getChildAt(selectedItemPos!!).setBackgroundColor(resources.getColor(R.color.white))
                }
                selectedItemPos = position
                view.setBackgroundColor(resources.getColor(R.color.green))
            }
        }
    }
}