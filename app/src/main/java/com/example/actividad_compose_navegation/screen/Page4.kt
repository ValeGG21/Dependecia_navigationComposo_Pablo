package com.example.actividad_compose_navegation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.actividad_compose_navegation.R


@Composable
fun Section_4(navegationHostController: NavHostController) {
    val items = listOf("Pintura", "Escultura", "Arquitectura", "Música", "Literatura", "Arte Digital", "Danza", "Cine", "Fotografía",
        "Arte Conceptual")


    val imgs = listOf(R.drawable.amarillo, R.drawable.fondo2, R.drawable.cara, R.drawable.mujer,
        R.drawable.animal, R.drawable.fondo3, R.drawable.hombre3, R.drawable.fondo4
    )
    val mix = listOf(
        "Leonardo da Vinci", R.drawable.davinci,
        "Pablo Picasso", R.drawable.pablo,
        "Frida Kahlo", R.drawable.frida,
        "Vincent van Gogh", R.drawable.van,
        "Ludwig van Beethoven", R.drawable.beet,
        "Maya Angelou", R.drawable.maya
    )


    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(items) { item ->
                    Text(text = item, modifier = Modifier.padding(16.dp))
                }
            }
        }

        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(imgs) { imagenes ->
                    Image(
                        painter = painterResource(id = imagenes),
                        contentDescription = "",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        items(mix) { item ->
            when (item) {
                is String -> {
                    Text(text = item, modifier = Modifier.padding(16.dp))
                }
                is Int -> {
                    Image(
                        painter = painterResource(id = item),
                        contentDescription = "",
                        modifier = Modifier.padding(16.dp,15.dp)
                    )
                }
            }
        }

        item {
            val colorDorado = colorResource(id = R.color.dorado)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        navegationHostController.navigate("view_1")
                    },
                    modifier = Modifier.fillMaxWidth().padding(100.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(colorDorado)
                ) {
                    Text(text = "R E G R E S A R")
                }
            }
        }
    }
}
