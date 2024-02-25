package com.example.dodo_hw.model

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.dodo_hw.MainActivity
import com.example.dodo_hw.R


class SectionsDataSource(private val context: Context) {
    fun getPizzas(): List<Pizza> {    return listOf(
        Pizza(
            name = "Баварская",
            description = "Острая чоризо из цыпленка, маринованные огурчики, красный лук, томаты, соус медово-горчичный, моцарелла, фирменный томатный соус",            image = ContextCompat.getDrawable(context, R.drawable.bavarskaya) ,
            startPrice = 2700        ),
        Pizza(
            name = "Наруто Пицца",
            description = "Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки",            image =ContextCompat.getDrawable(context, R.drawable.naruto),
            startPrice = 3900        ),
        Pizza(
            name = "Вау! Кебаб",
            description = "Кебаб из говядины, соус ранч, моцарелла, сладкий перец, томаты, красный лук, фирменный томатный соус",            image = ContextCompat.getDrawable(context, R.drawable.kebab),
            startPrice = 2900        ),
        Pizza(
            name = "Пепперони с грибами",
            description = "Пикантная пепперони из цыпленка, моцарелла, шампиньоны, фирменный соус альфредо",            image =ContextCompat.getDrawable(context, R.drawable.pepwithmush),
            startPrice = 2000        ),
        Pizza(
            name = "Сырная",
            description = "Моцарелла, сыры чеддер и пармезан, соус альфредо",            image = ContextCompat.getDrawable(context, R.drawable.cheese),
            startPrice = 1900        ),
        Pizza(
            name = "Додо",
            description = "Ветчина из цыпленка, митболы из говядины, пепперони из цыпленка, моцарелла, томаты, шампиньоны, сладкий перец, красный лук, чеснок, томатный соус",            image = ContextCompat.getDrawable(context, R.drawable.dodo),
            startPrice = 2900        ),
        Pizza(
            name = "Аррива!",
            description = "Соус бургер, цыпленок, соус ранч, чоризо из цыпленка, сладкий перец, красный лук, моцарелла, томаты, чеснок",            image = ContextCompat.getDrawable(context, R.drawable.arriva),
            startPrice = 2400        ),
        Pizza(
            name = "Маргарита",
            description = "Увеличенная порция моцареллы, томаты, итальянские травы, томатный соус",            image = ContextCompat.getDrawable(context, R.drawable.margarita),
            startPrice = 2100        )
    )

    }

}

