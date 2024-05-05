package com.example.coursecompose

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursecompose.ui.theme.CourseComposeTheme
import java.time.format.TextStyle
import androidx.compose.ui.text.style.*
val TAG : String = MainActivity::class.java.simpleName
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyCheBox()
                }
            }
        }
    }
}

@Composable
fun MyCheBox(){
    var state by remember{ mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow
        )
    )
}

@Composable
fun MySwitch(){
    var switchState by rememberSaveable{ mutableStateOf(true) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = !switchState },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan
        )
    )
}

@Composable
fun MyProgress(){
    Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
        LinearProgressIndicator(Modifier.padding(top = 50.dp))
    }
}

@Composable
fun MyIcon(){
    Icon(imageVector = Icons.Rounded.CheckCircle, contentDescription = "icon", tint = Color.Green)
}

@Composable
fun MyImageAdvance(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "exampple",
        alpha = 0.5f,
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, color = Color.Cyan, CircleShape)
    )
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "exampple",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample(){
    var enable by remember{ mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Button(
            onClick = {enable = false },
            colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.Green),
            border = BorderStroke(5.dp, Color.Yellow),
            enabled = enable
        ) {
            Text(text = "Hello")
        }

        OutlinedButton(
            onClick = { },
            Modifier.padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.Green, disabledContentColor = Color.Red)
        ) {
            Text(text = "Hello")

        }

        TextButton(onClick = {  }) {
            Text(text = "Hello")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance(){
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {st->
            myText = NotA(st = st)
            Log.i(TAG, myText.toString())
                        },
        label = { Text(text = "Introduce tu nombre") })
}

fun NotA(st : String): String{
    return if (st.contains("a")){
        st.replace("a","")
    }else{
        st
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(){
    var myText by remember{ mutableStateOf("Eduardo") }
    TextField(value = myText, onValueChange = {myText = it} )
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyText(){
    Column(Modifier.fillMaxSize()) {
        Text("My name is Eduardo")
        Text("My name is Eduardo", color = Color.Red)
        Text("My name is Eduardo", fontWeight = FontWeight.ExtraBold)
        Text(text = "My name is Eduardo", style = androidx.compose.ui.text.TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )
        )
        Text(text = "My name is Eduardo", style = androidx.compose.ui.text.TextStyle(fontFamily = FontFamily.Monospace, fontSize = 30.sp, textDecoration = TextDecoration.Underline))
        Text(
            text = "My name is Eduardo", style = androidx.compose.ui.text.TextStyle(
                fontFamily = FontFamily.Monospace,
                fontSize = 30.sp,
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
    }

}
@Composable
fun MyStateExample(){
    var counter by  remember{mutableStateOf(0)}
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter += 1}) {
            Text(text = "Pulsar")
        }
        Spacer(modifier = Modifier
            .width(0.dp)
            .height(20.dp))
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text("Presentation")
        }
        Spacer(modifier = Modifier
            .width(0.dp)
            .height(30.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Gray), contentAlignment = Alignment.Center){
                Text(text = "Developer")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Yellow) , contentAlignment = Alignment.Center){
                Text(text = "Android")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green), contentAlignment = Alignment.BottomCenter) {
            Text(text = "My name is Eduardo")
        }

    }

}

@Composable
fun MyColum(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "EXAMPLE 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 2", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 3", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 4", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 2", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 3", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 4", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 2", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 3", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 4", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 2", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 3", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 4", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 2", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 3", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "EXAMPLE 4", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.Cyan), contentAlignment = Alignment.BottomCenter){
            Text(text = "THIS IS A EXAMPLE")
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseComposeTheme {
        MyCheBox()
    }
}