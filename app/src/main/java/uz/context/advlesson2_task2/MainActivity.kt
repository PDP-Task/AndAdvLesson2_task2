package uz.context.advlesson2_task2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.context.advlesson2_task2.databinding.ActivityMainBinding
import uz.context.advlesson2_task2.manager.PrefsManager
import uz.context.advlesson2_task2.util.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initViews()
    }

    private fun initViews() {
        val prefsManager = PrefsManager.getInstance(this)
        bin.btnSave.setOnClickListener {
            val name = bin.editFullName.text.toString().trim()
            val email = bin.editEmail.text.toString().trim()
            val password = bin.editPassword.text.toString().trim()
            val conPassword = bin.confirmPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || conPassword.isEmpty()) {
                toast("No Data!")
            } else if (password != conPassword) {
                toast("Enter password correctly!")
            } else {
                prefsManager!!.apply {
                    saveData(Constants.NAME, name)
                    saveData(Constants.EMAIL, email)
                    saveData(Constants.PASSWORD, password)
                    saveData(Constants.CONFIRM_PASSWORD, conPassword)
                }
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                toast("Storage complete successfully")
                bin.editFullName.setText("")
                bin.editEmail.setText("")
                bin.editPassword.setText("")
                bin.confirmPassword.setText("")
            }
        }
    }

    private fun toast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
}