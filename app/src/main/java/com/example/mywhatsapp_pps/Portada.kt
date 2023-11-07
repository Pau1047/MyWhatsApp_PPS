package com.example.mywhatsapp_pps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mywhatsapp_pps.ui.theme.VerdeWas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),topBar = { MyTop(scrollBehavior)}){
    Box(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding())
    ){
        MyTabs()
        LazyColumn{
            items(getInfoWas()){ info ->
                Mycard(infoWas = info)

            }
        }

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ){
            MyFAB()
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

@Composable
fun MyTabs(){
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Chats", "Novedades", "Llamadas")
    Column {
        TabRow(selectedTabIndex = state, containerColor = VerdeWas) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis, color = Color.White) }
                )
            }
        }
    }
}
@Composable
fun MyFAB(){
    FloatingActionButton(onClick = { /*TODO*/ }) {
     Icon(imageVector = Icons.Filled.Check, contentDescription = " " )
    }
}

@Composable
fun Mycard(infoWas: infoWas){
   Card (){
       Row {
           Image(painterResource(id = infoWas.imagen), contentDescription =" ",
               modifier = Modifier
                   .width(70.dp)
                   .height(70.dp))

           Text(text = infoWas.name)
       }
   }
   

}

data class infoWas(
    var imagen: Int,
    var name: String
)

fun getInfoWas(): List<infoWas>{
    return listOf(
        infoWas(
            R.drawable.photo,
            "Jefe de departamento"
        ),
        infoWas(
            R.drawable.photo1,
            "Tutora DAM"
        ),
        infoWas(
            R.drawable.photo2,
            "Tutor DAW"
        ),
        infoWas(
            R.drawable.photo3,
            "Tutora ASIX"
        ),
        infoWas(
            R.drawable.photo4,
            "Presidenta"
        ),
        infoWas(
            R.drawable.photo5,
            "Secretaria"
        ),
        infoWas(
            R.drawable.photo6,
            "Administrador"
        ),
        infoWas(
            R.drawable.photo7,
            "Entrenadora"
        ),
        infoWas(
            R.drawable.photo8,
            "Nutricionista"
        ),
        infoWas(
            R.drawable.photo9,
            "Fisioterapeuta"
        )

    )
}
