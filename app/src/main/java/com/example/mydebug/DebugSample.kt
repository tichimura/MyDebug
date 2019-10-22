package com.example.mydebug

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DebugSample : AppCompatActivity() {

    private val editTextId: IntArray = intArrayOf(
        R.id.editText1,
        R.id.editText2,
        R.id.editText3,
        R.id.editText4,
        R.id.editText5
    )


    // editTextの配列
    private var editText = arrayOfNulls<EditText>(editTextId.size)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // アクティビティレイアウト設定
        setContentView(R.layout.debug_sample)

        // XML定義のビューを取得

        for (i in editTextId.indices) {
            editText[i] = findViewById(editTextId[i])

        }

        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var textView1 = findViewById<TextView>(R.id.textView1)
        var textView2 = findViewById<TextView>(R.id.textView2)

        // ボタンクリック時の動作

        button1.setOnClickListener {
            var ret = calcSum()
            textView1.text = ret.toString()
        }

        button2.setOnClickListener {
            var ret = calcAverage()
            textView2.text = ret.toString()
        }
    }



    private fun calcSum(): Int {
        var total = 0

        for (i in editTextId.indices){
            total += Integer.parseInt(editText[i]?.text.toString())
        }

        return total
    }

    private fun calcAverage(): Int {
        return calcSum() / editTextId.size
    }

}