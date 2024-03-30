package com.masterjorge.myspinnerapplication

//Sand box: aquilo que pertence a sua base de dados, mais ninguém pode acessar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.masterjorge.myspinnerapplication.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    //Objeto que une o XML com o código para dinamicidade
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Atualizando por meio do binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Itens a serem mostrados
        //Adaptar o texto para adaptar a cada componente do Spinner
        val itens = listOf("nome", "idade", "trabalho", "bairro", "cidade", "estado")

        //context: refere-se ao local em que a view pode ser criada
        //Trazemos também os objetos que irão ser modelados
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.spinner.adapter = adapter

        //Selecionando um objeto
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(
                    this@MainActivity,
                    "Selecionado: ${itens[position]}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //MÉTODO NEGADO!
        //binding.spinner.setOnItemClickListener {_, _, position, _ ->
            //Toast.makeText(this, "Selecionado: ${itens[position]}", Toast.LENGTH_SHORT).show()
        //}

        //Views
        binding.saveButton.setOnClickListener{

            //Objeto do tipo texto para trabalhar
            val text = binding.editText.text.toString()

            //Formato de salvar arquivo (context, conteúdo, e o nome)
            saveContentToFile(this, text,"texto.txt")

            //Função alternativa (R.string.save_message)
            //Deve acesso Views -> Tool Windows - Device Explorer -> data -> data -> nome do projeto
            Toast.makeText(this, R.string.save_message, Toast.LENGTH_SHORT).show()
        }

        //Atualizando arquivo
        binding.loadButon.setOnClickListener{
            val text = loadContentFromFile(this, "texto.txt")
            Toast.makeText(this, "Conteúdo atualizado!", Toast.LENGTH_SHORT).show()
        }
    }

    //Receber o conteúdo do arquivo selecionada
    private fun loadContentFromFile(context: Context, filename: String): String?{
        return try {
            //Abre o arquivo
            context.openFileInput(filename).use { inputStream ->
                //Leitura do arquivo
                inputStream.bufferedReader().use { reader ->
                    //Texto lido
                    reader.readText()
                }
            }
        } catch (e: IOException){
            return null
        }
    }


    //Função para salvar os dados no arquivo
    //Acesso aos arquivos que serão salvos no formato string, e o nome também
    private fun saveContentToFile(context: Context, content: String, filename: String){

        //Mostrar os arquivos
        //Tipo Sand box (privado)
        context.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(content.toByteArray())
        }
    }
}