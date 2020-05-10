package rs.raf.projekat1.boris_jankovic_rn3317.view.recycler.viewholder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_patient_discharged.*
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import timber.log.Timber
import java.text.DateFormat

class PatientDischargedViewHolder(
    override val containerView: View,
    onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        patientPictureIv.setOnClickListener {
            onItemClicked.invoke(adapterPosition)
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.picture)
            .into(patientPictureIv)
        firstNameTv.text = patient.firstName
        lastNameTv.text = patient.lastName

        dischargedDateTv.text = DateFormat.getDateInstance().format(patient.releasedDate)
    }
}