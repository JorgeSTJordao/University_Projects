package com.masterjorge.calculadorasimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.masterjorge.calculadorasimples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //A variável "binding" está recebendo nosso layout XML
    //Permite reconhecer o layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumBtn.setOnClickListener(this)
        binding.minusBtn.setOnClickListener(this)
        binding.mulBtn.setOnClickListener(this)
        binding.divBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.sum_btn)
            somar()
        else if (view.id == R.id.minus_btn)
            subtrair()
        else if (view.id == R.id.mul_btn)
            multiplicar()
        else
            dividir()
    }

    private fun somar(){
        val num1 = binding.num1Edit.text.toString().toFloat()
        val num2 = binding.num2Edit.text.toString().toFloat()

        binding.resultadoVariavel.text = "${num1 + num2}"
    }

    fun subtrair(){
        val num1 = binding.num1Edit.text.toString().toFloat()
        val num2 = binding.num2Edit.text.toString().toFloat()

        binding.resultadoVariavel.text = "${num1 - num2}"
    }

    fun multiplicar(){
        val num1 = binding.num1Edit.text.toString().toFloat()
        val num2 = binding.num2Edit.text.toString().toFloat()

        binding.resultadoVariavel.text = "${num1 * num2}"
    }

    fun dividir(){
        val num1 = binding.num1Edit.text.toString().toFloat()
        val num2 = binding.num2Edit.text.toString().toFloat()

        if (num2 != 0f)
            binding.resultadoVariavel.text = "${num1 / num2}"
        else
            Toast.makeText(this,"Divisão inválida", Toast.LENGTH_LONG).show()
    }

}