package com.example.ch13_all

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pb1 = findViewById<ProgressBar>(R.id.pb1)
        var pb2 = findViewById<ProgressBar>(R.id.pb2)
        var btn = findViewById<Button>(R.id.button1)

        var tv1 = findViewById<TextView>(R.id.tv1)
        var tv2 = findViewById<TextView>(R.id.tv2)

        btn.setOnClickListener {

            object: Thread(){
                override fun run()
                {
                    for (i in 0..99) {
                        pb1.progress += 2
                        runOnUiThread {
                            tv1.setText("1번 진행률 : "+pb1.progress + "%")
                        }


                       SystemClock.sleep(100)
                    }
                }
            }.start()
//            th1.start()

            object: Thread(){
                override fun run()
                {
                    for (i in 0..99) {
//                        pb1.progress += 2
                        pb2.progress += 1

                        runOnUiThread {
                            tv2.setText("2번 진행률 : " + pb2.progress + "%")
                        }

                        SystemClock.sleep(100)
                    }
                }
            }.start()



        }
    }
}
