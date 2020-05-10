package rs.raf.projekat1.boris_jankovic_rn3317.view.activities

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_profile.*
import rs.raf.projekat1.boris_jankovic_rn3317.R

class EditProfileActivity : AppCompatActivity(R.layout.activity_edit_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        init()
    }

    private fun init() {
        initListeners()
        fillProfile()
    }

    private fun fillProfile() {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        firstNameEt.setText(sharedPreferences.getString(MainActivity.FIRST_NAME, ""))
        lastNameEt.setText(sharedPreferences.getString(MainActivity.LAST_NAME, ""))
        hospitalNameEt.setText(sharedPreferences.getString(MainActivity.HOSPITAL_NAME, ""))
    }

    private fun initListeners() {
        cancelBtn.setOnClickListener {
            finish()
        }

        confirmBtn.setOnClickListener {
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

            if (ok) {
                val editor = sharedPreferences.edit()

                editor.putString(MainActivity.FIRST_NAME, firstNameEt.text.toString())
                editor.putString(MainActivity.LAST_NAME, lastNameEt.text.toString())
                editor.putString(MainActivity.HOSPITAL_NAME, hospitalNameEt.text.toString())
                editor.apply()

                finish()

                Toast.makeText(this, R.string.success_edit, Toast.LENGTH_LONG).show()
            }
        }
    }

}