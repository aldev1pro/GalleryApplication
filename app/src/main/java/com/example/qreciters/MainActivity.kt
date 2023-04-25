package com.example.qreciters

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qreciters.ui.theme.QRecitersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainBlock{
                //Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()

                startActivity(Displayinfo.newIntent(this, it))

            }

        }

    }
}
@Composable
fun MainBlock(rose:(Mydata) -> Unit){
    val reciter = ReciterList.happy()
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.background(
            Color.Black
        )
    ) {
        item {
            Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {
                Text(text = "Quran Reciters",
                    style = TextStyle(color = Color.White),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp
                )
            }

         }

        items(items = reciter) {
            Look(sol = it,rose)
        }

    }

}
