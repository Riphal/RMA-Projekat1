package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_info.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.viewmodels.RecyclerViewModel

class InfoFragment: Fragment(R.layout.fragment_info) {

    private val recyclerViewModel : RecyclerViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        recyclerViewModel.getWaitingPatients().observe(viewLifecycleOwner, Observer {
            numberOfWaitingPatientsTv.text = recyclerViewModel.getWaitingPatientsList().size.toString()
        })

        recyclerViewModel.getHospitalizedPatients().observe(viewLifecycleOwner, Observer {
            numberOfHospitalizedPatientsTv.text = recyclerViewModel.getHospitalizedPatientList().size.toString()
        })

        recyclerViewModel.getDischargedPatients().observe(viewLifecycleOwner, Observer {
            numberOfDischargedPatientsTv.text = recyclerViewModel.getDischargedPatientsList().size.toString()
        })
    }
}