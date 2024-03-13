package uz.coder.fromoneactivitytosecondactivityinjetpackcompose

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uz.coder.fromoneactivitytosecondactivityinjetpackcompose.ui.theme.FromOneActivityToSecondActivityInJetpackComposeTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FromOneActivityToSecondActivityInJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenSecond(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenSecond(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val intent = context.findActivity()?.intent
    val str = intent?.getStringExtra(STR) ?: ""
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = str,fontSize = 20.sp, color = colorResource(id = R.color.black))
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

}
fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FromOneActivityToSecondActivityInJetpackComposeTheme {
        ScreenSecond()
    }
}
fun getIntent(context: Context, str:String)= Intent(context,SecondActivity::class.java).apply {
    putExtra(STR,str)
}
private const val STR="str"