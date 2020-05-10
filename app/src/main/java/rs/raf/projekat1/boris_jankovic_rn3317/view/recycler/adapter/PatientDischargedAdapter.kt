package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder.PatientDischargedViewHolder

class PatientDischargedAdapter(
    PatientDiffItemCallback: PatientDiffItemCallback,
    private val onPatientClicked: (Patient) -> Unit) : ListAdapter<Patient, PatientDischargedViewHolder>(PatientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientDischargedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_discharged, parent, false)

        return PatientDischargedViewHolder(containerView) {
            val patient = getItem(it)
            onPatientClicked.invoke(patient)
        }
    }

    override fun onBindViewHolder(holderRecovered: PatientDischargedViewHolder, position: Int) {
        val patient = getItem(position)
        holderRecovered.bind(patient)
    }
}