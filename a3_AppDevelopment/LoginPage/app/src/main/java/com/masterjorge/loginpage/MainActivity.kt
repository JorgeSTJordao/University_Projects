package com.masterjorge.loginpage

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.masterjorge.loginpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Declara antes para ser acessada em outros lugares
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.login_button)
            mostrarDado()
    }

    fun mostrarDado(){

        //Usamos essa função para verificar se é Nulo ou Vazio
        if (binding.edUser.text.contains("user")  &&  binding.edPassword.text.contains("1234"))
            Toast.makeText(this, "Feito!", Toast.LENGTH_LONG).show()
    }

}