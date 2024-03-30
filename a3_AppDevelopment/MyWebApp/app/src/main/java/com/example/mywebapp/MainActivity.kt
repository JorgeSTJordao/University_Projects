package com.example.mywebapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mywebapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//API Referência: https://api.chucknorris.io/

class MainActivity : AppCompatActivity() {

    //O retrofit é o responsável por importar as APIs
    private val retrofit = Retrofit.Builder()
        //.baseUrl("https://api.chucknorris.io")
        .baseUrl("https://ipgeolocation.abstractapi.com/v1/")
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
                val response = api.geoLocate()
                binding.tvContinent.text = response.continent
                binding.tvHelloWorld.text = response.city
            }
        }
    }
}