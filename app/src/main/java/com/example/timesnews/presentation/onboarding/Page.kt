package com.example.timesnews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.timesnews.R

data class Page(
    val title: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Tech Titans Clash: Apple and Google's Antitrust Battle",
        image = R.drawable.onboarding1,
    ),
    Page(
        title = "Climate Crisis Intensifies: UN Report Warns of Dire Consequences",
        image = R.drawable.onboarding2,
    ),
    Page(
        title = "Space Race Heats Up: SpaceX's Ambitious Plans for Mars Colonization",
        image = R.drawable.onboarding3,
    )
)