package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_hospitalized.*
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient

class PatientHospitalizedViewHolder(
    override val containerView: View,
    onFileBtnClicked: (Int) -> Unit,
    onDischargedBtnClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        fileBtn.setOnClickListener {
            onFileBtnClicked.invoke(adapterPosition)
        }

        dischargedBtn.setOnClickListener {
            onDischargedBtnClicked.invoke(adapterPosition)
        }
    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.picture)
            .into(patientPictureIv)
        firstNameTv.text = patient.firstName
        lastNameTv.text = patient.lastName
    }
}