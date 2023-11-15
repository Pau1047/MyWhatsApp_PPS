package com.example.mywhatsapp_pps

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun Chats(){
 vistaCard()
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun vistaCard(){
   val contactos : Map<String, List<infoWas>> = getInfoWas().groupBy { it.grup }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
        contactos.forEach { (items, miContacto) ->
            stickyHeader {
                Text(text = items,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray),
                    fontSize = 16.sp
                    )
            }
            items(miContacto){infoWas ->
                Mycard(infoWas = infoWas)
            }
        }
    }

}
@Composable
fun Mycard(infoWas: infoWas){
    val scope = rememberCoroutineScope()
    val expandedState = remember { mutableStateOf(false) }
        Row (modifier = Modifier.pointerInput(true){
            detectTapGestures(onLongPress = { scope.launch { showMenu = !showMenu }})
        }){
            MyDropDownMenu {

            }
            Image(
                painterResource(id = infoWas.imagen), contentDescription = " ",
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                    .size(75.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
            )

            Text(text = infoWas.name,
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }

}

@Composable
fun MyDropDownMenu(onDismissRequest: () -> Unit){

    DropdownMenu(expanded = true, onDismissRequest = { onDismissRequest() }) {
        DropdownMenuItem(text = { Text(text = "Salir del grupo") }, onClick = { /*TODO*/ })
        DropdownMenuItem(text = { Text(text = "Info. grupo") }, onClick = { /*TODO*/ })
        DropdownMenuItem(text = { Text(text = "Crear acceso directo") }, onClick = { /*TODO*/ })
    }

}


data class infoWas(
    var grup: String,
    var imagen: Int,
    var name: String
)

fun getInfoWas(): List<infoWas>{
    return listOf(
        infoWas(
            "Departamento Informatica",
            R.drawable.photo,
            "Jefe de departamento"
        ),
        infoWas(
            "Departamento Informatica",
            R.drawable.photo1,
            "Tutora DAM"
        ),
        infoWas(
            "Departamento Informatica",
            R.drawable.photo2,
            "Tutor DAW"
        ),
        infoWas(
            "Departamento Informatica",
            R.drawable.photo3,
            "Tutora ASIX"
        ),
        infoWas(
            "Comunidad Propiedad",
            R.drawable.photo4,
            "Presidenta"
        ),
        infoWas(
            "Comunidad Propiedad",
            R.drawable.photo5,
            "Secretaria"
        ),
        infoWas(
            "Comunidad Propiedad",
            R.drawable.photo6,
            "Administrador"
        ),
        infoWas(
            "Gimnasio",
            R.drawable.photo7,
            "Entrenadora"
        ),
        infoWas(
            "Gimnasio",
            R.drawable.photo8,
            "Nutricionista"
        ),
        infoWas(
            "Gimnasio",
            R.drawable.photo9,
            "Fisioterapeuta"
        )
    )
}
