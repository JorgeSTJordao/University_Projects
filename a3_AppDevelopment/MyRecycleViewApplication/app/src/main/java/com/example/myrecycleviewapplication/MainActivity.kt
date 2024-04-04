package com.example.myrecycleviewapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecycleviewapplication.databinding.ActivityMainBinding

//Criação do layout em cada um dos itens

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,R.layout.activity_main
            )

        //Pegando o objeto do Recycler View
        binding.mainRecyclerView.adapter =
            CityAdapter(object : CityAdapter.onCityClickListener{
            override fun onCityClick(view: View, position: Int) {
                Singleton.cities[position].apply {
                    name = name + "Clicked"
                }
                binding.
                mainRecyclerView.
                adapter?.notifyItemChanged(position)
            }

                override fun onCityLongClick(view: View, position: Int) {
                    Singleton.cities.removeAt(position)
                    binding.
                    mainRecyclerView.
                    adapter?.notifyItemChanged(position)
                }

            })

        for (i in 0..10){
            Singleton.cities.add(
                City("City $i", i)
            )
        }

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.setOnClickListener {
            Singleton.cities.add(
                0, City("City Added", 1000)
            )
            binding.mainRecyclerView.adapter?.notifyItemInserted(Singleton.cities.size - 1)
        }
    }
}