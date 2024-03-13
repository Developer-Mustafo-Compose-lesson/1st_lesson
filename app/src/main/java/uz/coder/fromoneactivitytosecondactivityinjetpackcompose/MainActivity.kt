package uz.coder.fromoneactivitytosecondactivityinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.coder.fromoneactivitytosecondactivityinjetpackcompose.ui.theme.FromOneActivityToSecondActivityInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FromOneActivityToSecondActivityInJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenFirst(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenFirst(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val str = remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        TextField(value = str.value, onValueChange = { str.value = it }, modifier = modifier.fillMaxWidth())
        Button(onClick = {
            context.startActivity(getIntent(context,str.value))
            val findActivity = context.findActivity()
            findActivity?.finish()
        }, modifier = modifier
            .fillMaxWidth(), colors = ButtonDefaults.buttonColors(colorResource(id = R.color.teal_200))) {
            Text(
                text = stringResource(id = R.string.button_txt),
                modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                color = colorResource(id = R.color.white)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FromOneActivityToSecondActivityInJetpackComposeTheme {
        ScreenFirst()
    }
}