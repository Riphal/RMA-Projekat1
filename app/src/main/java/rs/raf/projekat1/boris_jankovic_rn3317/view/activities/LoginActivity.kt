package rs.raf.projekat1.boris_jankovic_rn3317.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.boris_jankovic_rn3317.R

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        signUp()
    }

    private fun signUp () {
        signUpBtn.setOnClickListener {
            var ok = true;
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            if (firstNameEt.text.toString() == "") {
                ok = false
                Toast.makeText(this, R.string.first_name_error_login, Toast.LENGTH_SHORT).show()
            }

            if (lastNameEt.text.toString() == "") {
                ok = false
                Toast.makeText(this, R.string.last_name_error_login, Toast.LENGTH_SHORT).show()
            }

            if (hospitalNameEt.text.toString() == "") {
                ok = false
                Toast.makeText(this, R.string.hospital_name_error_login, Toast.LENGTH_SHORT).show()
            }

            if (pinEt.text.toString().length != 4) {
                ok = false
                Toast.makeText(this, R.string.pin_error_len_login, Toast.LENGTH_SHORT).show()
            }

            if (pinEt.text.toString().toInt() != 1234) { // Typed pin, TO-DO: Get pin from server
                ok = false
                Toast.makeText(this, R.string.pin_error_login, Toast.LENGTH_SHORT).show()
            }

            if (ok) {
                val editor = sharedPreferences.edit()

                editor.putString(MainActivity.FIRST_NAME, firstNameEt.text.toString())
                editor.putString(MainActivity.LAST_NAME, lastNameEt.text.toString())
                editor.putString(MainActivity.HOSPITAL_NAME, hospitalNameEt.text.toString())
                editor.putBoolean(MainActivity.LOGGED_IN, true)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

                Toast.makeText(this, R.string.successful_login, Toast.LENGTH_LONG).show()
            }
        }
    }
}