package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var clear: Button
    lateinit var back: ImageView
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button
    lateinit var percentage: Button
    lateinit var mult: Button
    lateinit var div: Button
    lateinit var sum: Button
    lateinit var substract: Button
    lateinit var point: Button
    lateinit var plusminus: Button
    lateinit var equals: Button
    lateinit var expression: TextView
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear= findViewById(R.id.button_clear)
        back= findViewById(R.id.imageButton)
        one= findViewById(R.id.button_1)
        two= findViewById(R.id.button_2)
        three= findViewById(R.id.button_3)
        four= findViewById(R.id.button_4)
        five= findViewById(R.id.button_5)
        six= findViewById(R.id.button_6)
        seven= findViewById(R.id.button_7)
        eight= findViewById(R.id.button_8)
        nine= findViewById(R.id.button_9)
        zero= findViewById(R.id.button_0)
        sum= findViewById(R.id.button_plus)
        mult= findViewById(R.id.button_mult)
        div= findViewById(R.id.button_divide)
        substract= findViewById(R.id.button_minus)
        point= findViewById(R.id.button_dot)
        plusminus= findViewById(R.id.button_plusminus)
        equals= findViewById(R.id.button_equals)
        percentage= findViewById(R.id.button_percent)
        expression= findViewById(R.id.value_display)
        result= findViewById(R.id.result_display)

        one.setOnClickListener{ appendtext("1",true)}
        two.setOnClickListener{ appendtext("2",true)}
        three.setOnClickListener{ appendtext("3",true)}
        four.setOnClickListener{ appendtext("4",true)}
        five.setOnClickListener{ appendtext("5",true)}
        six.setOnClickListener{ appendtext("6",true)}
        seven.setOnClickListener{ appendtext("7",true)}
        eight.setOnClickListener{ appendtext("8",true)}
        nine.setOnClickListener{ appendtext("9",true)}
        zero.setOnClickListener{ appendtext("0",true)}
        div.setOnClickListener{ appendtext("/",false)}
        mult.setOnClickListener{ appendtext("*",false)}
        sum.setOnClickListener{ appendtext("+",false)}
        substract.setOnClickListener{ appendtext("-",false)}
        percentage.setOnClickListener{ appendtext("%",false)}
        equals.setOnClickListener{
            try { val expr = ExpressionBuilder(expression.text.toString()).build()
                val answer = expr.evaluate()
               result.text = answer.toString()
            }catch (e:Exception){
       result.text = e.message
            }
        }
        back.setOnClickListener {
            result.text =""
            result.hint=""
            val value = expression.text
            if(value.isNotEmpty()){
                expression.text = value.substring(0, value.length-1)
            }
        }
       clear.setOnClickListener{
           expression.text=""
           result.text=""
           result.hint=""
       }

        point.setOnClickListener{appendtext(".",true)}

        percentage.setOnClickListener{appendtext("%",false)}

        plusminus.setOnClickListener{
             result.text=""
             result.hint=""
            if (expression.text.isNotEmpty() && expression.text[0]=='-'){
                expression.text = expression.text.substring(1)

            }
            else{
                "-${expression.text}".also { expression.text = it }
            }
         }

    }
    fun appendtext(value: String , tobecleared:Boolean){
        if(result.text!=""){
            expression.text=""
        }


            if (tobecleared) {
                result.text =""
                expression.append(value)
            } else {
                expression.append(result.text)
                expression.append(value)
                result.text = ""
            }

   result.hint = expression.text
    }
}