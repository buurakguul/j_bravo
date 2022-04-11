package com.burakgul.kenny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var score = 0

    var arrayImage = ArrayList<ImageView>()

    var handler = Handler()

    var runnable = Runnable{}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    arrayImage.add(imageView)
    arrayImage.add(imageView2)
    arrayImage.add(imageView3)
    arrayImage.add(imageView4)
    arrayImage.add(imageView5)
    arrayImage.add(imageView6)
    arrayImage.add(imageView7)
    arrayImage.add(imageView8)
    arrayImage.add(imageView9)

    hideImages()

    imageView.visibility = View.INVISIBLE

    object : CountDownTimer(30600, 1000) {
        override fun onTick(p0: Long) {
            TODO("Not yet implemented")
            textTime.text = "Time: " + millisUntilp0/1000
        }

        override fun onFinish() {
            TODO("Not yet implemented")
            textTime.text ="Time: 0"

            handler.removeCallbacks(runnable)

            for (image in arrayImage) {
                image.visibility = View.INVISIBLE
            }

            val alert: alertDialog.Builder(this@MainActivity)
            alert.setTitle("Game Over")
            alert.setMessage("Restart")
            alert.setPositiveButton("Yes") {dialog, which ->

                val intent = intent
                finish()
                startActivity(intent)
            }
            alert.setNegativeButton("No") {dialog, which ->
                Toast.makeText(this@mainActivity,"Game Over!",Toast.LENGTH_LONG).show()
            }
            alert.show()

        }

    }.start()
}

fun hideImages() {

    runnable = object : Runnable {
        override fun run() {
            TODO("Not yet implemented")
            for (image in arrayImage) {
                image.visibility = View.INVISIBLE
            }
        }

        for (image in arrayImage)
                    {
            image.visibility = View.Invisible
        }

        val random = Random()
        val randomIndex = random.nextInt(9)
        arrayImage[randomIndex].visibility = View.VISIBLE

        handler.postDelayed(runnable,delayMillis:650)
    }

    handler.post(runnable)

}

fun scoreIncrease(view: View) {
        score++;
        textScore.text ="Score: $score"
        }
    }
}