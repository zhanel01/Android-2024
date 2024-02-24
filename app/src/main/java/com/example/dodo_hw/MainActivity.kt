package com.example.dodo_hw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo_hw.adapter.SectionAdapter
import com.example.dodo_hw.databinding.ActivityMainBinding
import com.example.dodo_hw.model.Pizza
import com.example.dodo_hw.model.SectionsDataSource


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SectionAdapter
    private lateinit var pizzas: List<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize pizzas

        pizzas = SectionsDataSource(this).getPizzas()






        // Setup RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SectionAdapter(pizzas, this) { pizza -> onPizzaClicked(pizza) }


        recyclerView.adapter = adapter

        // Setup search functionality
        binding.searchButton.setOnClickListener { onSearchClicked() }
    }

    private fun onPizzaClicked(pizza: Pizza) {
        val intent = Intent(this, PizzaDetailsActivity::class.java)
        intent.putExtra("PIZZA", pizza)
        startActivity(intent)
    }

    private fun onSearchClicked() {
        val searchText = binding.searchEditText.text.toString().trim()
        val filteredPizzas = if (searchText.isNotEmpty()) {
            pizzas.filter { it.name.contains(searchText, ignoreCase = true) }
        } else {
            pizzas
        }
        adapter.updateData(filteredPizzas)
    }
}
