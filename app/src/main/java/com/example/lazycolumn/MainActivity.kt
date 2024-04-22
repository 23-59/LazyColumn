package com.example.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumn.ui.theme.LazyColumnTheme

val images = listOf(
    R.drawable.pic1,
    R.drawable.pic2,
    R.drawable.pic3,
    R.drawable.pic4,
    R.drawable.pic5,
    R.drawable.pic6,
    R.drawable.pic7,
    R.drawable.pic8,
    R.drawable.pic9,
    R.drawable.pic10
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                Surface {
                    MyLazyColumn()
                }
            }
        }
    }
}

@Composable
fun MyLazyColumn() {
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(vertical = 16.dp)) {
        items(10) {
            Item(title = "item number ${it+1}", image = images[it])
        }
    }
}

@Composable
fun Item(title: String, image: Int) {

    Card(shape = CutCornerShape(15.dp), elevation = CardDefaults.cardElevation(2.dp), modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
        Row(
            Modifier
                .fillMaxSize()
                .clip(CutCornerShape(10.dp))
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(contentScale = ContentScale.Crop,
                painter = painterResource(id = image),
                contentDescription = "image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(
                        CircleShape
                    )
            )
            Text(text = title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyColumnTheme {
        MyLazyColumn()
    }
}