package com.example.dodo_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodo_hw.databinding.ActivityPizzaDetailsBinding
import com.example.dodo_hw.model.Pizza


class PizzaDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPizzaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPizzaDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = intent.getSerializableExtra("PIZZA") as Pizza
        binding.imageView.setImageDrawable(pizza.image)
        binding.title.text = pizza.name
        binding.description.text = pizza.description
    }

}
