package com.example.dodo_hw.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dodo_hw.PizzaDetailsActivity
import com.example.dodo_hw.R
import com.example.dodo_hw.model.Pizza

class SectionAdapter(private var pizzas: List<Pizza>, private val context: Context, private val listener: (Pizza) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_REGULAR = 0
    private val VIEW_TYPE_NEW = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_REGULAR -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
                RegularPizzaViewHolder(view)
            }
            VIEW_TYPE_NEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
                NewPizzaViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_REGULAR -> {
                val regularHolder = holder as RegularPizzaViewHolder
                regularHolder.bind(pizzas[position], listener)
            }
            VIEW_TYPE_NEW -> {
                val newHolder = holder as NewPizzaViewHolder
                newHolder.bind(pizzas[position], listener)
            }
        }
    }

    override fun getItemCount(): Int = pizzas.size

    override fun getItemViewType(position: Int): Int {
        return if (position < pizzas.size) {
            VIEW_TYPE_REGULAR
        } else {
            VIEW_TYPE_NEW
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(filteredPizzas: List<Pizza>) {
        pizzas = filteredPizzas
        notifyDataSetChanged()
    }

    inner class RegularPizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val pizzaImageView: ImageView = itemView.findViewById(R.id.pizzaImageView)
        private val priceTextView: TextView = itemView.findViewById(R.id.price)

        @SuppressLint("SetTextI18n")
        fun bind(pizza: Pizza, listener: (Pizza) -> Unit) {
            nameTextView.text = pizza.name
            descriptionTextView.text = pizza.description
            priceTextView.text = "from ${pizza.startPrice} ₸"
            pizzaImageView.setImageDrawable(pizza.image)

            priceTextView.setOnClickListener {
                val intent = Intent(context, PizzaDetailsActivity::class.java)
                intent.putExtra("PIZZA", pizza)
                context.startActivity(intent)
            }

            itemView.setOnClickListener { listener(pizza) }
        }
    }

    inner class NewPizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val pizzaImageView: ImageView = itemView.findViewById(R.id.pizzaImageView)
        private val priceTextView: TextView = itemView.findViewById(R.id.price)

        @SuppressLint("SetTextI18n")
        fun bind(pizza: Pizza, listener: (Pizza) -> Unit) {
            nameTextView.text = pizza.name
            descriptionTextView.text = pizza.description
            priceTextView.text = "from ${pizza.startPrice} ₸"
            pizzaImageView.setImageDrawable(pizza.image)

            priceTextView.setOnClickListener {
                val intent = Intent(context, PizzaDetailsActivity::class.java)
                intent.putExtra("PIZZA", pizza)
                context.startActivity(intent)
            }

            itemView.setOnClickListener { listener(pizza) }
        }
    }
}




