package com.ganeshrashinkar.composepaging3caching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ganeshrashinkar.composepaging3caching.presentation.BeerScreen
import com.ganeshrashinkar.composepaging3caching.presentation.BeerViewModel
import com.ganeshrashinkar.composepaging3caching.ui.theme.ComposePaging3CachingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePaging3CachingTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    val viewModel=hiltViewModel<BeerViewModel>()
                    val beers=viewModel.beerPagingFlow.collectAsLazyPagingItems()
                    BeerScreen(
                        beers =beers
                    )
                }
            }
        }
    }
}

