package com.ganeshrashinkar.composepaging3caching.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ganeshrashinkar.composepaging3caching.domain.Beer
import com.ganeshrashinkar.composepaging3caching.ui.theme.ComposePaging3CachingTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun BeerItem(beer: Beer, modifier: Modifier=Modifier) {
Card(
    modifier=modifier,

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(16.dp),

    ) {
        AsyncImage(
            model = beer.imageUrl,
            contentDescription = beer.name,
            modifier=Modifier
                .weight(1f)
                .height(150.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(3f),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = beer.name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.tagline,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.description,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "First brewed in ${beer.firstBrewed}",
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.End,
                fontSize = 8.sp
            )
        }
    }
}
}

@Composable
@Preview
fun BeerItemPreview(){
ComposePaging3CachingTheme {
    BeerItem(beer = Beer(
        id = 1,
        name = "Beer",
        tagline = "This is the cool beer",
        firstBrewed = "07/2023",
        description = "This is the description of beer. \n this is next line",
        imageUrl = null
    ), modifier=Modifier.fillMaxWidth())
}
}