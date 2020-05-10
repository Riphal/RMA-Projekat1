package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder.PatientWaitingViewHolder

class PatientWaitingAdapter (
    PatientDiffItemCallback: PatientDiffItemCallback,
    private val onHealthyBtnClick: (Patient) -> Unit,
    private val onHospitalizeBtnClick: (Patient) -> Unit) : ListAdapter<Patient, PatientWaitingViewHolder>(PatientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PatientWaitingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_patient_waiting, parent, false)

        return PatientWaitingViewHolder(
            containerView,
            onHealthyBtnClicked,
            onHospitalizedBtnClicked
        )
    }

    override fun onBindViewHolder(holderWaiting: PatientWaitingViewHolder, position: Int) {
        val patient = getItem(position)
        holderWaiting.bind(patient)
    }

    private val onHealthyBtnClicked: (Int) -> Unit = {
        onHealthyBtnClick.invoke(getItem(it))
    }

    private val onHospitalizedBtnClicked: (Int) -> Unit = {
        onHospitalizeBtnClick.invoke(getItem(it))
    }

}
