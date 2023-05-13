package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    public var Score : Int = 0
    public var ScoreYes : Int = 0
    public var ScoreNo : Int = 0
    public var ScoreProcent : Double = 0.0
    public lateinit var symbol : String
    public var firstNumber : Int = 0
    public var secondNumber : Int = 0
    public var resultStart : Int = 0
    public var ifStart : String = ""
    public var ifCheck : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun check(view: View) {
        binding.btnCheck.isEnabled=false

        Score+=1
        val resultInput : String= binding.txtInput.text.toString()
        val resultStartString : String = resultStart.toString()
        if(resultStartString==resultInput)
        {
            ScoreYes+=1
        }else
        {
            ScoreNo+=1
        }
        ScoreProcent=ScoreYes.toDouble() / Score.toDouble()
        binding.txtProcentScore.text=(ScoreProcent*100).toInt().toString()+'%'
        binding.txtScoreYes.text=ScoreYes.toString()
        binding.txtScoreNo.text=ScoreNo.toString()
        binding.txtScore.text=Score.toString()
        binding.btnStart.isEnabled=true


    }

    fun Start(view: View) {
        binding.btnStart.isEnabled=false

        val symbolArr = arrayListOf<String>("+","-","*","/")
        randnumber()
        symbol = symbolArr.random()
        binding.txtSign.text=symbol.toString()
        binding.txtFirstNumber.text=firstNumber.toString()
        binding.txtSecondNumber.text=secondNumber.toString()
        if(symbol == "+")
        {
            resultStart=firstNumber+secondNumber
        }else if(symbol == "-")
        {
            resultStart=firstNumber-secondNumber
        }else if(symbol == "*")
        {
            resultStart=firstNumber*secondNumber
        }else{
            resultStart=firstNumber/secondNumber
        }

        binding.btnCheck.isEnabled=true


    }
    fun randnumber(){
        var FisrtRand : Int = Random.nextInt(1, 100)
        var SecondRand : Int = Random.nextInt(1, 100)
        if (FisrtRand%SecondRand==0)
        {
            firstNumber=FisrtRand
            secondNumber=SecondRand
        }else
        {
            FisrtRand = Random.nextInt(1, 100)
            SecondRand = Random.nextInt(1, 100)
            randnumber()
        }
    }
}