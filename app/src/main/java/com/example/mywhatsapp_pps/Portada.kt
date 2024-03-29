package com.example.mywhatsapp_pps

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp_pps.ui.theme.VerdeWas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { MyTop(scrollBehavior)},
    floatingActionButton = { MyFAB()}){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding())
    ){

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = it.calculateBottomPadding()) ){
            MyTabs()
        }
    }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(scrollBehavior: TopAppBarScrollBehavior){
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = VerdeWas),
        title = { Text(text = "MyWhastApp", color = Color.White)  },
        actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = Color.White)
        }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    tint = Color.White)
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTabs(){
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Chats", "Novedad", "Llamadas", "Esterlla")
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f){4}
    val scope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = state, containerColor = VerdeWas) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(page = index) } },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis, color = Color.White) }
                )
            }
        }
        HorizontalPager(state = pagerState) { page ->
            when(page){
                0 -> Chats()
                1 -> Novedades()
                2 -> Llamadas()
                3 -> Estrella()
            }
        }
    }
}
@Composable
fun MyFAB(){
    FloatingActionButton(onClick = {},
        modifier = Modifier.size(60.dp),
        containerColor = VerdeWas,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {
        animatedCorazon()
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun animatedCorazon(){
    val image = AnimatedImageVector.animatedVectorResource(R.drawable.corazon_animado)
    var atEnd by remember { mutableStateOf(false) }
    Image(
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = "VectorDrawable",
        modifier = Modifier.clickable {
            atEnd = !atEnd
        },
        contentScale = ContentScale.Crop,
    )
}

