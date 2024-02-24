package com.example.dodo_hw.model

interface SectionItem {
    enum class Type(value: Int) { Pizza(0), Banner(1) }
    fun getListItemType(): Int
    val title: String
    val description: String
    val image: Int
}
