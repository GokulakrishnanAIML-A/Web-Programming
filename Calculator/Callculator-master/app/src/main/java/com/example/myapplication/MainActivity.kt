package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var number1:EditText
    private lateinit var number2:EditText
    private lateinit var result:TextView
    private lateinit var addbtn:Button
    private lateinit var subbtn:Button
    private lateinit var mulbtn:Button
    private lateinit var divbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1=findViewById(R.id.number1)
        number2=findViewById(R.id.number2)
        result=findViewById(R.id.resultText)
        addbtn=findViewById(R.id.btnAdd)
        subbtn=findViewById(R.id.btnSub)
        mulbtn=findViewById(R.id.btnMul)
        divbtn=findViewById(R.id.btnDiv)

        addbtn.setOnClickListener{calculate('+')}
        subbtn.setOnClickListener{calculate('-')}
        mulbtn.setOnClickListener{calculate('*')}
        divbtn.setOnClickListener{calculate('/')}

    }
    @SuppressLint("SetTextI18n")
    private fun calculate(operator :Char){
        val num1=number1.text.toString().toDouble()
        val num2=number2.text.toString().toDouble()
        val res= when (operator){
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 == 0.0) {
                    result.text = "Cannot divide by zero"
                    return
                }
                num1 / num2
            }
            else -> 0.0
        }
        result.text= "Result:$res"

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}