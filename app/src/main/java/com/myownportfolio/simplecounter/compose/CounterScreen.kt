package com.myownportfolio.simplecounter.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//to Show the screen
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CounterScreenPreview(innerPadding:PaddingValues){
    CounterScreen(Modifier.padding(innerPadding))

}
@Composable
fun CounterScreen(modifier: Modifier) {
    //the mutable state that save the state of the counter to be changed by the two buttons
    var counter by rememberSaveable { mutableStateOf(0) }
    // column to contain the text and the two buttons
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 50.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){
        //the counter text
        Text(text = counter.toString(), fontSize = 150.sp)
        //the row that contains the two button to put them side by side horizontally
        Row {
            //the button that subtracts from the counter, it's handled in high order function
            Button(onClick = {counter--}, shape = RoundedCornerShape(16.dp), modifier = Modifier.weight(1f).height(100.dp)) {
                Text(text = "-", fontSize = 55.sp)
            }
            //the button that adds to the counter, it's handled in high order function
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = {counter++}, shape = RoundedCornerShape(16.dp), modifier = Modifier.weight(1f).height(100.dp)) {
                Text(text = "+", fontSize = 55.sp)

            }
        }
    }
}