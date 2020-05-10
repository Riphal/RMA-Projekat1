package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_waiting.*
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient

class PatientWaitingViewHolder (
    override val containerView: View,
    onHealthyBtnClicked: (Int) -> Unit,
    onHospitalizeBtnClicked: (Int) -> Unit ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        healthyBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onHealthyBtnClicked.invoke(adapterPosition)
            }
        }

        hospitalizationBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onHospitalizeBtnClicked.invoke(adapterPosition)
            }
        }

    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.picture)
            .into(patientPictureIv)
        firstNameTv.text = patient.firstName
        lastNameTv.text = patient.lastName
        symptomsTv.text = patient.symptoms

    }

}