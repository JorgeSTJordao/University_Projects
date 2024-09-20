package com.masterjorge.dialogbox

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.masterjorge.dialogbox.databinding.ActivitySegundaTelaBinding

class SegundaTela : AppCompatActivity() {

    lateinit var binding: ActivitySegundaTelaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnSave = binding.saveDataButton
        val edUser = binding.edUser
        val edPassword = binding.edPassword

        btnSave.setOnClickListener {
            if (!edUser.text.isEmpty() && !edPassword.text.isEmpty()) {
                Toast.makeText(this, "Dados atualizados", Toast.LENGTH_SHORT).show()

                //Ir para próxima página
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("edUser_", edUser.text.toString())
                intent.putExtra("edPassword_", edPassword.text.toString())
                Toast.makeText(this, "Seu dados foram alterados!", Toast.LENGTH_SHORT).show()

                setResult(Activity.RESULT_OK, intent)

                finish()
            } else
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}