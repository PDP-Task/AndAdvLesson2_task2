package uz.context.advlesson2_task2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.context.advlesson2_task2.databinding.ActivityHomeBinding
import uz.context.advlesson2_task2.manager.PrefsManager
import uz.context.advlesson2_task2.util.Constants

class HomeActivity : AppCompatActivity() {
    private lateinit var bin: ActivityHomeBinding
    private lateinit var sharedPref: SharedPreferences
    private lateinit var prefsManager: PrefsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()
    }

    private fun initViews() {
        sharedPref = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE)
        prefsManager = PrefsManager.getInstance(this)!!
        val name = sharedPref.getString(Constants.NAME, null)
        val email = sharedPref.getString(Constants.EMAIL, null)
        val password = sharedPref.getString(Constants.PASSWORD, null)
        val conPassword = sharedPref.getString(Constants.CONFIRM_PASSWORD, null)

        if (name != null) {
            bin.textName.text = name
            bin.textEmail.text = email
            bin.textPass.text = password
            bin.textCPass.text = conPassword
        }
        bin.btnLogout.setOnClickListener {
            prefsManager.clearAll()
            finish()
            Toast.makeText(this, "Log out successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}