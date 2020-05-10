package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder.PatientHospitalizedViewHolder

class PatientHospitalizedAdapter(
    PatientDiffItemCallback: PatientDiffItemCallback,
    private val onFileBtnClick: (Patient) -> Unit,
    private val onDischargedBtnClicks: (Patient) -> Unit) : ListAdapter<Patient, PatientHospitalizedViewHolder>(PatientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHospitalizedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_hospitalized, parent, false)
        return PatientHospitalizedViewHolder(containerView, onFileButtonClicked, onRecoveredButtonClicked)
    }

    override fun onBindViewHolder(holderWaitingRoom: PatientHospitalizedViewHolder, position: Int) {
        val patient = getItem(position)
        holderWaitingRoom.bind(patient)
    }

    private val onFileButtonClicked: (Int) -> Unit = {
        onFileBtnClick.invoke(getItem(it))
    }

    private val onRecoveredButtonClicked: (Int) -> Unit = {
        onDischargedBtnClicks.invoke(getItem(it))
    }

}