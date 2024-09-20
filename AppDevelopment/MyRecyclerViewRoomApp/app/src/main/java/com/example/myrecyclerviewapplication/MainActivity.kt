package com.example.myrecyclerviewapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerviewapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback.DismissEvent
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        Singleton.setContext(this)
        binding.mainRecyclerView.adapter =
            CityAdapter(object : CityAdapter.OnCityClickListener {
                override fun onCityClick(view: View, position: Int) {
                    Singleton.citySelected = Singleton.cities[position]
                    val intent = Intent(
                        this@MainActivity,
                        CityDetailsActivity::class.java
                    )
                    startActivity(intent)
                }

                override fun onCityLongClick(view: View, position: Int) {

                    var status = 0
                    status = onSNACK(view, status)

                    if (status != 0) {
                    }
                    Handler().postDelayed({
                        Singleton.delete(Singleton.cities[position])
                        binding.mainRecyclerView.adapter?.notifyItemRemoved(position)
                    }, 3000)
                }
            })

        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(this)

        binding.addButton.setOnClickListener {
            Singleton.citySelected = null
            val intent = Intent(
                this,
                CityDetailsActivity::class.java
            )
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mainRecyclerView.adapter?.notifyDataSetChanged()
    }

    fun onSNACK(view: View, status: Int): Int {

        var status_ = status

        val snackbar = Snackbar.make(binding.root, "Dados deletados", 3000)

        snackbar.setAction("Desfazer") {
            status_ = 1
            snackbar.dismiss()
        }

        snackbar.show()

        return status_
    }

}
