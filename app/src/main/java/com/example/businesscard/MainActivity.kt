package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}


@Composable
fun BusinessCardApp(modifier: Modifier = Modifier){
    Surface (color = Color(0xFFace6a1)){
        Column (modifier.fillMaxSize().padding(top=200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            PictureContainer()
            Spacer(Modifier.height(160.dp))
            Contacts()
        }
    }

}

@Composable
fun PictureContainer(){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
//        val image = painterResource(R.drawable.freddy_2)
        Image(
            painter = painterResource(R.drawable.freddy_2),
            contentDescription = "freddy\'s picture",
            modifier = Modifier.height(200.dp).width(270.dp)
        )
        Text(text = "Fred Makaranga", fontSize = 30.sp, modifier = Modifier.padding(top = 15.dp))
        Text(text= "Software Developer", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = Color(0xFF2a8c18), modifier = Modifier.padding(top = 9.dp))
    }
}

@Composable
fun Contacts(){
    Column {
        Row (horizontalArrangement = Arrangement.Center){
            Icon(
                Icons.Rounded.Call,
                contentDescription = "developer phone number",
                tint = Color(0xFF2a8c18),
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.width(2.dp))
            Text(text="+255 758 226770",fontSize =17.sp)
        }
        Spacer(Modifier.height(10.dp))
        Row (horizontalArrangement = Arrangement.Center){
            Icon(Icons.Rounded.Share,contentDescription = "x account",tint = Color(0xFF2a8c18),
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text(text="@Freddy_MK87", fontSize =17.sp)
        }
        Spacer(Modifier.height(10.dp))
        Row (horizontalArrangement = Arrangement.Center){
            Icon(Icons.Rounded.Email,contentDescription = "x account",tint = Color(0xFF2a8c18),
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text(text="fred45722@gmail.com",fontSize =17.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}