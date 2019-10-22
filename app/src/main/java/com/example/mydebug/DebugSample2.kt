package com.example.mydebug

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.CharSequence as CharSequence1

class DebugSample2 : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // アクティビティに設定ファイルを追加
        setContentView(R.layout.debug_sample2)


        // XML定義のビュー
        val editText1 = findViewById<EditText>(R.id.height)
        val editText2 = findViewById<EditText>(R.id.weight)
        val button1 = findViewById<Button>(R.id.bmiButton)
        val textView1 = findViewById<TextView>(R.id.std)
        val textView2 = findViewById<TextView>(R.id.bmi)
        val textView3 = findViewById<TextView>(R.id.bmiString)


        // 7-1 for refactoring

        var isValid = true

        checkinput(editText1, isValid)


        // 計算ボタン　BMI算出

        button1.setOnClickListener {

            // 変数の宣言と計算処理

            var height = editText1.text.toString().toDouble() / 100 // (m)
            val weight = editText2.text.toString().toDouble()
            val std = height * height * 22.0
            var d = weight / (height * height)
            val bmi = d
            val bmiString = if ( bmi < 18.5) "低体重"
            else if (bmi < 25) "普通体重"
            else if (bmi < 30) "肥満(1度)"
            else if (bmi < 35) "肥満(2度)"
            else if (bmi < 40) "肥満(3度)"
            else "肥満(4度)"

            //　テキストビュー

            textView1.text = "標準体重:" + String.format("%.2f", std) + "kg"
            textView2.text = "BMI:" + String.format("%.2f", bmi)
            textView3.text = "BMI評価:" + bmiString

        }

        debugFunc1()

    }

    private fun checkinput(editText1: EditText, isValid: Boolean) {
        var isValid1 = isValid
        if (editText1.toString().isEmpty()) {
            editText1.error = getString(R.string.edittext_error)
            isValid1 = false
        }
    }

    private val TAG = "MyApp"

    private fun debugFunc1() {
        var total = 0

        for ( i in 1..1000) {
            total += i
            Log.d(TAG, "i: " + i + " total:" + total)
        }
    }
}