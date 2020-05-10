package rs.raf.projekat1.boris_jankovic_rn3317.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.view.viewpager.PagerAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        const val LOGGED_IN = "logged_in"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val HOSPITAL_NAME = "hospital_name"
    }

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager () {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_info -> {
                    viewPager.setCurrentItem(PagerAdapter.INFO_FRAGMENT, false)
                }
                R.id.navigation_input -> {
                    viewPager.setCurrentItem(PagerAdapter.INPUT_FRAGMENT, false)
                }
                R.id.navigation_list -> {
                    viewPager.setCurrentItem(PagerAdapter.LIST_FRAGMENT, false)
                }
                R.id.navigation_profile -> {
                    viewPager.setCurrentItem(PagerAdapter.PROFILE_FRAGMENT, false)
                }
            }
            true
        }

    }

}
