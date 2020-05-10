package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hospitalized_list.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.view.activities.PatientProfileActivity
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter.PatientHospitalizedAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.viewmodels.RecyclerViewModel
import java.util.*

class HospitalizedListFragment : Fragment(R.layout.fragment_hospitalized_list) {

    private val recyclerViewModel : RecyclerViewModel by activityViewModels()
    private lateinit var patientHospitalizedAdapter: PatientHospitalizedAdapter
    private lateinit var patient: Patient

    companion object {
        const val PATIENT_CHANGE_PROFILE_REQUEST_CODE = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
        initRecycler()
        initObservers()
    }

    private val onFileButtonClick: (Patient) -> Unit = {
        this.patient = it

        val intent = Intent(this.context, PatientProfileActivity::class.java)
        intent.putExtra(PatientProfileActivity.PATIENT_KEY, it)

        startActivityForResult(intent, PATIENT_CHANGE_PROFILE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PATIENT_CHANGE_PROFILE_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {

                    val receivedPatient: Patient? = data?.getParcelableExtra(PatientProfileActivity.PATIENT_KEY)

                    this.patient.firstName = receivedPatient?.firstName ?: ""
                    this.patient.lastName = receivedPatient?.lastName ?: ""
                    this.patient.symptoms = receivedPatient?.symptoms ?: ""

                    Toast.makeText(this.context, R.string.success_edit, Toast.LENGTH_SHORT).show()
                }
            }
        }
        init()
    }

    private val onRecoveredButtonClick: (Patient) -> Unit = {
        it.releasedDate = Date()
        recyclerViewModel.removePatient(recyclerViewModel.getHospitalizedPatientList(), recyclerViewModel.getHospitalizedPatients(), it)
        recyclerViewModel.addPatient(recyclerViewModel.getDischargedPatientsList(), recyclerViewModel.getDischargedPatients(), it)
    }

    private fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        patientHospitalizedAdapter = PatientHospitalizedAdapter(PatientDiffItemCallback(), onFileButtonClick, onRecoveredButtonClick)
        recyclerView.adapter = patientHospitalizedAdapter
    }


    private fun initListeners() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    recyclerViewModel.filterPatients(recyclerViewModel.getHospitalizedPatientList(), recyclerViewModel.getHospitalizedPatients(), searchView.query.toString())
                    return false
                }
            }
        )
    }

    private fun initObservers() {
        this.activity?.let {
            recyclerViewModel.getHospitalizedPatients().observe(it, Observer {
                patientHospitalizedAdapter.submitList(it)
            })
        }
    }
}