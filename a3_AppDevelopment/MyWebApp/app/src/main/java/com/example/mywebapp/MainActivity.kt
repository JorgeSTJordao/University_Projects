package com.example.mywebapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mywebapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Site da API Referência: https://api.chucknorris.io/
//Site da API Exercício: https://github.com/lukePeavey/quotable

class MainActivity : AppCompatActivity() {

    //O retrofit é o responsável por importar as APIs
    private val retrofit = Retrofit.Builder()
        //.baseUrl("https://api.chucknorris.io")
        .baseUrl("https://api.quotable.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(ChuckNorrisAPI::class.java)

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val response = api.quotes()
                binding.tvFrase.text = response.content
                binding.tvAutor.text = response.author
            }
        }
    }
}