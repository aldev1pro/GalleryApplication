package com.example.qreciters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Look(sol:Mydata,move:(Mydata) -> Unit){
    Card(modifier = Modifier.size(400.dp,200.dp),backgroundColor = Color.Black) {
        Row(modifier = Modifier.padding(5.dp),verticalAlignment = Alignment.CenterVertically) {
            first(sol)
            Spacer(modifier = Modifier.size(40.dp))
            Column {
                Text(text = sol.name,fontSize = 16.sp,fontWeight = FontWeight.ExtraBold,style = TextStyle(color = Color.White))
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "VIEW DETAILS",fontStyle = FontStyle.Italic,textDecoration = TextDecoration.Underline,
                    style = TextStyle(color = Color.White),
                    modifier = Modifier.clickable { move(Mydata(sol.image,sol.name,sol.place,sol.age)) }
                )
            }

        }
    }

}
@Composable
fun first(nol:Mydata){
    Image(
        painter = painterResource(id = nol.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(150.dp,160.dp).clip( RoundedCornerShape(corner = CornerSize(16.dp)))

    )

}