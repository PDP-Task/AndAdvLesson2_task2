package uz.context.advlesson2_task2

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import uz.context.advlesson2_task2.util.Constants

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPreferences = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE)
        val name = sharedPreferences.getString(Constants.NAME, null)

        val time = object : CountDownTimer(2000, 2000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                if (name == null) {
                    intent(MainActivity())
                    finish()
                } else {
                    intent(HomeActivity())
                    finish()
                }
            }
        }
        time.start()
    }

    private fun intent(activity: Activity) {
        startActivity(Intent(this@SplashActivity, activity::class.java))
    }
}