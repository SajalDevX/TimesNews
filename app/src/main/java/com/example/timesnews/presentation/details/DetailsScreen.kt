package com.example.timesnews.presentation.details


import TimesNewsTheme
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.timesnews.domain.model.Article
import com.example.timesnews.domain.model.Source
import com.example.timesnews.presentation.Dimens.ArticleImageHeight
import com.example.timesnews.presentation.Dimens.MediumPadding1
import com.loc.newsapp.presentation.details.components.DetailsTopBar

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookMarkClick = {
                event(DetailsEvent.UpsertDeleteArticle(article))
            },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    TimesNewsTheme(dynamicColor = false) {
        DetailsScreen(
            article = Article(
                author = "",
                title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
                content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
                publishedAt = "2023-06-16T22:24:33Z",
                source = Source(
                    id = "", name = "bbc"
                ),
                url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
                urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
            ),
            event = {}
        ) {

        }
    }
}