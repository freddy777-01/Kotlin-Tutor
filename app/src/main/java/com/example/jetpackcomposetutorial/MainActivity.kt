package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Body(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Body(modifier: Modifier){
    Column (modifier = Modifier.padding(top = 50.dp)){
        TitleImage(modifier = modifier)
        BodyContent(modifier = Modifier,
            title = stringResource(R.string.tutorial_title),
            definition = stringResource(R.string.tutorial_definition),
            content = stringResource(R.string.tutorial_body)
        )
    }
}

@Composable
fun TitleImage(modifier: Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image ,contentDescription = null)
}

@Composable
fun BodyContent(title:String,definition:String,content:String,modifier: Modifier){
    val paddingSymmetry:Modifier = Modifier.padding(16.dp)
    val paddingSize = 16.dp

    Column (modifier = Modifier.padding(8.dp)){
        Text(text = title,modifier =Modifier.padding(start = paddingSize, end = paddingSize, bottom = paddingSize, top = paddingSize), fontSize = 24.sp)
        Text(text=definition,modifier = Modifier.padding(start = paddingSize, end = paddingSize), textAlign = TextAlign.Justify)
        Text(text=content, textAlign = TextAlign.Justify,modifier = Modifier.padding(start = paddingSize, end = paddingSize, bottom = paddingSize, top = paddingSize))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTutorialTheme {
        Body(Modifier)
    }
}