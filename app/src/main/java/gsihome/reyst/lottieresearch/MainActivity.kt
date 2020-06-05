package gsihome.reyst.lottieresearch

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private val btnStart: Button by lazy { findViewById<Button>(R.id.btn_start) }
    private val animationView: LottieAnimationView by lazy { findViewById<LottieAnimationView>(R.id.animation_view) }

    private var _1stPassed = false
    private var _2ndPassed = false
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            if (isPaused) animationView.resumeAnimation()
            else {
                animationView.playAnimation()
                _1stPassed = false
                _2ndPassed = false
            }

            isPaused = false
        }

        animationView.addLottieOnCompositionLoadedListener {
            Log.wtf("INSPECT", it.toString())
        }

        animationView.addAnimatorUpdateListener {
            Log.wtf("INSPECT", "${it.animatedFraction}")
        }

        animationView.addAnimatorUpdateListener {

//            if (it.isRunning && !_1stPassed && abs(it.animatedFraction - 0.333F) < 0.001) {
//                animationView.pauseAnimation()
//                _1stPassed = true
//                isPaused = true
//            }
//
//            if (it.isRunning && !_2ndPassed && abs(it.animatedFraction - 0.666F) < 0.001) {
//                animationView.pauseAnimation()
//                _2ndPassed = true
//                isPaused = true
//            }
        }


    }
}
