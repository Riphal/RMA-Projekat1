package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_discharged_list.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter.PatientDischargedAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.viewmodels.RecyclerViewModel

class DischargedListFragment : Fragment(R.layout.fragment_discharged_list) {

    private val recyclerViewModel : RecyclerViewModel by activityViewModels()
    private lateinit var patientDischargedAdapter: PatientDischargedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
        initRecycler()
        initObservers()
    }

    private fun initRecycler() {
        recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        patientDischargedAdapter = PatientDischargedAdapter(PatientDiffItemCallback()) {}
        recyclerView.adapter = patientDischargedAdapter
    }

    private fun initListeners() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    recyclerViewModel.filterPatients(recyclerViewModel.getDischargedPatientsList(), recyclerViewModel.getDischargedPatients(), searchView.query.toString())
                    return false
                }
            }
        )
    }

    private fun initObservers() {
        this.activity?.let {
            recyclerViewModel.getDischargedPatients().observe(it, Observer {
                patientDischargedAdapter.submitList(it)
            })
        }
    }

}