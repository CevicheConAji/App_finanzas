package com.example.app_finanzas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    lateinit var tvAlquiler:TextView
    lateinit var tvCoche:TextView
    lateinit var tvTotal:TextView
    lateinit var rsAlquiler:RangeSlider
    lateinit var rsCoche:RangeSlider
    lateinit var tvGastosVivienda:TextView
    lateinit var tvGastosComida:TextView

    lateinit var btnGastosViviendaSum:FloatingActionButton
    lateinit var btnGastosViviendaResta:FloatingActionButton
    lateinit var btnSumaComida:FloatingActionButton
    lateinit var btnRestaComida:FloatingActionButton

    var alquilerFloat:Float = 0f
    var cocheFloat:Float = 0f
    var sumaViviendaFloat:Float = 0f
    var sumaComidaFloat:Float = 0f
    var salirFloat:Float = 0f

    lateinit var btncien:AppCompatButton
    lateinit var btnDos:AppCompatButton
    lateinit var btnTres:AppCompatButton
    lateinit var btnCuatro:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponent()
        initListener()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponent(){
        tvAlquiler = findViewById(R.id.tvAlquiler)
        tvCoche = findViewById(R.id.tvCoche)
        tvTotal = findViewById(R.id.tvTotal)
        btnGastosViviendaSum = findViewById(R.id.btnGastosViviendaSum)
        btnGastosViviendaResta = findViewById(R.id.btnGastosViviendaResta)
        rsAlquiler = findViewById(R.id.rsAlquiler)
        rsCoche = findViewById(R.id.rsCoche)
        tvGastosVivienda = findViewById(R.id.tvGastosVivienda)
        tvGastosComida = findViewById(R.id.tvGastosComida)
        btnSumaComida = findViewById(R.id.btnSumaComida)
        btnRestaComida = findViewById(R.id.btnRestaComida)
        btncien = findViewById(R.id.btncien)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
    }
    private fun initListener(){
        rsAlquiler.addOnChangeListener{_,value,_ ->
            alquilerFloat = value
            tvAlquiler.text = alquilerFloat.toString()
            sumaTotal()
        }
        rsCoche.addOnChangeListener{_,value,_->
            cocheFloat = value
            tvCoche.text = cocheFloat.toString()
            sumaTotal()
        }
        btnGastosViviendaSum.setOnClickListener(){
            sumaViviendaFloat+= 150f
            tvGastosVivienda.text = sumaViviendaFloat.toString()
            sumaTotal()
        }
        btnGastosViviendaResta.setOnClickListener(){
            sumaViviendaFloat -= 150f
            tvGastosVivienda.text = sumaViviendaFloat.toString()
            sumaTotal()
        }
        btnSumaComida.setOnClickListener(){
            sumaComidaFloat += 150f
            tvGastosComida.text = sumaComidaFloat.toString()
            sumaTotal()
        }
        btnRestaComida.setOnClickListener(){
            sumaComidaFloat -= 150f
            tvGastosComida.text = sumaComidaFloat.toString()
            sumaTotal()
        }
        btncien.setOnClickListener(){
            salirFloat += 100f
            sumaTotal()
        }
        btnDos.setOnClickListener(){
            salirFloat += 200f
            sumaTotal()
        }
        btnTres.setOnClickListener(){
            salirFloat += 300f
            sumaTotal()
        }
        btnCuatro.setOnClickListener(){
            salirFloat += 400f
            sumaTotal()
        }

    }
    private fun sumaTotal(){
        tvTotal.text = (alquilerFloat+cocheFloat+sumaViviendaFloat+sumaComidaFloat+salirFloat).toString()
    }
}