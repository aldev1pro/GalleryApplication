package com.example.qreciters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qreciters.ui.theme.QRecitersTheme

class Displayinfo : ComponentActivity() {
    companion object{
        private const val Reciter_ID = "puppy_ID"
        fun newIntent(context: Context, puppy: Mydata) =
            Intent(context, Displayinfo::class.java).apply {
                putExtra(Reciter_ID, puppy)
            }
    }
    private val puppy: Mydata by lazy {
        intent?.getSerializableExtra(Reciter_ID) as Mydata
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRecitersTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    ViewMoreInfo(tvShow = Mydata(puppy.image,puppy.name,puppy.place,puppy.age))
                }
            }
        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: Mydata) {
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = tvShow.image),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp,500.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.place,
                style = MaterialTheme.typography.h3
            )
            Text(
                text = "${tvShow.age}",
                style = MaterialTheme.typography.h3
            )


        }
    }
}


@Composable
fun Second(nol:Mydata){
    Image(
        painter = painterResource(id = nol.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp, 160.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

    )

}