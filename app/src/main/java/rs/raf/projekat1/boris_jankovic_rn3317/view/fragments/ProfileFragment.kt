package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.view.activities.EditProfileActivity
import rs.raf.projekat1.boris_jankovic_rn3317.view.activities.LoginActivity
import rs.raf.projekat1.boris_jankovic_rn3317.view.activities.MainActivity

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        fillProfile()
    }

    private fun init() {
        fillProfile()
        initListeners()
    }

    private fun fillProfile() {
        val sharedPreferences = context?.getSharedPreferences(context?.packageName, Context.MODE_PRIVATE)

        firstNameTv.text = sharedPreferences?.getString(MainActivity.FIRST_NAME, "")
        lastNameTv.text = sharedPreferences?.getString(MainActivity.LAST_NAME, "")
        hospitalNameTv.text = sharedPreferences?.getString(MainActivity.HOSPITAL_NAME, "")
    }

    private fun initListeners() {
        signOutBtn.setOnClickListener {
            val sharedPreferences = context?.getSharedPreferences(context?.packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()

            editor?.putString(MainActivity.FIRST_NAME, "")
            editor?.putString(MainActivity.LAST_NAME, "")
            editor?.putString(MainActivity.HOSPITAL_NAME, "")
            editor?.putBoolean(MainActivity.LOGGED_IN, false)
            editor?.apply()

            val intent = Intent(this.requireActivity(), LoginActivity::class.java)
            startActivity(intent)

            this.activity?.finish()
            Toast.makeText(this.requireContext(), R.string.success_logout, Toast.LENGTH_LONG).show()
        }

        editBtn.setOnClickListener {
            val intent = Intent(this.requireActivity(), EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

}