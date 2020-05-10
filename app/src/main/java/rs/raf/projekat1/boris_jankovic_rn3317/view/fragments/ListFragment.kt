package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.view.viewpager.PagerAdapterListView

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPagerListView.offscreenPageLimit = 4
        viewPagerListView.adapter = PagerAdapterListView(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerListView)
    }

}