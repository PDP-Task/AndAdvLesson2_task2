package uz.context.advlesson2_task2.manager

import android.content.Context
import android.content.SharedPreferences
import uz.context.advlesson2_task2.util.Constants

class PrefsManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences? =
        context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager!!
        }
    }

    fun saveData(key: String?, value: String?) {
        val prefEditor = sharedPreferences!!.edit()
        prefEditor.putString(key, value)
        prefEditor.apply()
    }

    fun getData(key: String?): String? {
        return if (sharedPreferences != null) sharedPreferences.getString(key, "") else ""
    }
    fun clearAll() {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.clear()
        prefsEditor.apply()
    }
}