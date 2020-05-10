package rs.raf.projekat1.boris_jankovic_rn3317.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val loggedIn = sharedPreferences.getBoolean(MainActivity.LOGGED_IN, false)

        if (loggedIn) {
            this.intent = Intent(this, MainActivity::class.java)
        } else {
            this.intent = Intent(this, LoginActivity::class.java)
        }

        startActivity(intent)
        finish()
    }

}
