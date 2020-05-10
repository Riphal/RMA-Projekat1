package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient

class PatientDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.firstName == newItem.firstName &&
                oldItem.lastName == newItem.lastName &&
                oldItem.symptoms == newItem.symptoms
    }

}