package com.example.timesnews.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.timesnews.R
import com.example.timesnews.domain.model.Article
import com.example.timesnews.presentation.Dimens.MediumPadding1
import com.example.timesnews.presentation.common.ArticlesList
import com.example.timesnews.presentation.navgraph.Route
import com.example.timesnews.presentation.common.SearchBar


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: (String) -> Unit,
    navigateToDetails: (Article) -> Unit
) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .padding(horizontal = MediumPadding1)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1)
                    .fillMaxWidth(),
                text = "",
                readOnly = true,
                onValueChange = {},
                onSearch = {},
                onClick = {
                    navigateToSearch(Route.SearchScreen.route)
                }
            )
        }
        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = titles, modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
                .basicMarquee(), fontSize = 18.sp,
            color = colorResource(id = R.color.placeholder),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            articles = articles
        ) {
            navigateToDetails(it)
        }
    }
}