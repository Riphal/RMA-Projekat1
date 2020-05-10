package rs.raf.projekat1.boris_jankovic_rn3317.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.DischargedListFragment
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.HospitalizedListFragment
import rs.raf.projekat1.boris_jankovic_rn3317.view.fragments.WaitingListFragment

class PagerAdapterListView(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val WAITING_FRAGMENT = 0
        const val HOSPITALIZED_FRAGMENT = 1
        const val DISCHARGED_FRAGMENT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            WAITING_FRAGMENT -> WaitingListFragment()
            HOSPITALIZED_FRAGMENT -> HospitalizedListFragment()
            else -> DischargedListFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            WAITING_FRAGMENT -> "Cekaonica"
            HOSPITALIZED_FRAGMENT -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }

}