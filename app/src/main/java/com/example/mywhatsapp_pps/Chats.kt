package com.example.mywhatsapp_pps

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Chats(){
 vistaCard()
}
@Composable
fun vistaCard(){
    LazyColumn{
        items(getInfoWas()){ info ->
            Mycard(infoWas = info)
        }
    }

}
@Composable
fun Mycard(infoWas: infoWas){
    Card (){
        Row {
            Image(
                painterResource(id = infoWas.imagen), contentDescription =" ",
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
