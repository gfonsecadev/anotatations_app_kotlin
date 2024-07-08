package com.example.anotaes_app_kotlin

import android.graphics.ColorSpace.Rgb
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.anotaes_app_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var anotation = Anotation(this)

        //chamada do conteudo salvo em sharePreferences
        binding.contentMain.editTextAnotacao.text = anotation.retrieveData()
        anotation.alert((binding.main))

        //salva em sharePreferences
        binding.fab.setOnClickListener(View.OnClickListener {
            anotation.save(binding.contentMain.editTextAnotacao.text.toString(),binding.main)
        })
    }


}