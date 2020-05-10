package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_waiting_list.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter.PatientWaitingAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.viewmodels.RecyclerViewModel
import java.util.*

class WaitingListFragment : Fragment(R.layout.fragment_waiting_list) {

    private val recyclerViewModel : RecyclerViewModel by activityViewModels()
    private lateinit var patientWaitingAdapter : PatientWaitingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
        initRecycler()
        initObservers()
    }

    private val onHealthyBtnClicked : (Patient) -> Unit = {
        it.releasedDate = Date()
        recyclerViewModel.removeWaitingPatient(it)
//        recyclerViewModel.addRecoveredPatient(it)
    }

    private val onHospitalizeBtnClicked : (Patient) -> Unit = {
        it.hospitalizationDate = Date()
        recyclerViewModel.removeWaitingPatient(it)
//        recyclerViewModel.addHospitalizedPatient(it)
    }

    private fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        patientWaitingAdapter = PatientWaitingAdapter(PatientDiffItemCallback(), onHealthyBtnClicked, onHospitalizeBtnClicked)
        recyclerView.adapter = patientWaitingAdapter
    }

    private fun initListeners() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                recyclerViewModel.filterWaitingPatients(searchView.query.toString())
                return false
            }
        })
    }

    private fun initObservers() {
        this.activity?.let {
            recyclerViewModel.getWaitingPatients().observe(it, Observer {
                patientWaitingAdapter.submitList(it)
            })
        }
    }

}