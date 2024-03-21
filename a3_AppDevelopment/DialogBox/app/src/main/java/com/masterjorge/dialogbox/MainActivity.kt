package com.masterjorge.dialogbox

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.masterjorge.dialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Declara antes para ser acessada em outros lugares
    lateinit var binding: ActivityMainBinding

    var user = "user"
    var password = "1234"

    val resultContrato = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->

        //Verifica o contrato com a página
        if (result?.resultCode == Activity.RESULT_OK){
            user = result.data?.getStringExtra("edUser_").toString()
            password = result.data?.getStringExtra("edPassword_").toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Criando o objeto de caixa de diálogo
        val builderAlertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        builderAlertDialog
            .setTitle("Acesso negado")
            .setMessage("Insira seus dados novamente")
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
            }

        val edUserVar = binding.edUser
        val edPasswordVar = binding.edPassword
        val btnLogin = binding.loginButton

        btnLogin.setOnClickListener {
            if (edUserVar.text.contains(user) && edPasswordVar.text.contains(password)) {
                //Ir para próxima página
                val intent = Intent(this, SegundaTela::class.java)
                resultContrato.launch(intent)
            }

        }
    }



}