package com.example.timesnews.ui.theme

import androidx.annotation.DrawableRes
import com.example.timesnews.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Tech Titans Clash: Apple and Google's Antitrust Battle",
        description = "",
//        description = "Dive into the implications for developers and consumers alike in this high-stakes showdown.",
        image = R.drawable.onboarding1,
    ),
    Page(
        title = "Climate Crisis Intensifies: UN Report Warns of Dire Consequences",
        description = "",
//        description = " Delve into the alarming findings of the latest United Nations report, which paints a grim picture of the accelerating climate crisis.",
        image = R.drawable.onboarding2,
    ),
    Page(
        title = "Space Race Heats Up: SpaceX's Ambitious Plans for Mars Colonization",
        description = "",
//        description = " Embark on a journey into the cosmos as SpaceX CEO Elon Musk unveils bold initiatives for interplanetary travel and human settlement on Mars.",
        image = R.drawable.onboarding3,
    )
)