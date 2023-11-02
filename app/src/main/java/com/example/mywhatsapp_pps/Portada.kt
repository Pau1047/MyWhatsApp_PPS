package com.example.mywhatsapp_pps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(){

Scaffold(topBar = { MyTop()}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding())
    )
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(){
    TopAppBar(
        title = { Text(text = "MyWhastApp") },
        actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search")
        }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share")
            }
        }
    )
}
