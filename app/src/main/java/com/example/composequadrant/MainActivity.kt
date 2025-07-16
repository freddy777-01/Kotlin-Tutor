package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    ComposeQuadrantApp()
                }
            }
        }
    }
}



@Composable
fun ComposeQuadrantApp(){
    Column (Modifier.fillMaxSize()){
        Row(Modifier.weight(1f)){
            ComposableInfoCard(
                title = stringResource(R.string.first_quadrant_title),
                description = stringResource(R.string.first_quadrant_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFEADDFF)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_quadrant_title),
                description = stringResource(R.string.second_quadrant_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFD0BCFF)
            )
        }
        Row (Modifier.weight(1f)){
            ComposableInfoCard(
                title = stringResource(R.string.third_quadrant_title),
                description = stringResource(R.string.third_quadrant_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFB69DF8)
                )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_quadrant_title),
                description = stringResource(R.string.fourth_quadrant_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDFF)
            )
        }
    }
}


@Composable
private fun ComposableInfoCard(title:String,description:String,backgroundColor:Color,modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize().background(backgroundColor).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text= title,
            fontWeight = FontWeight.Bold,
            modifier=modifier.padding(bottom = 16.dp)
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}