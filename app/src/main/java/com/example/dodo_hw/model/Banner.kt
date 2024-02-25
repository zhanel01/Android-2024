package com.example.dodo_hw.model

import android.graphics.drawable.Drawable
import java.util.UUID

data class Banner(
    val id: String = UUID.randomUUID().toString(),
    override val title: String,
    override val description: String,
    override val image: Int
): SectionItem {
    override fun getListItemType(): Int {
        return SectionItem.Type.Banner.ordinal
    }
}
