package rs.raf.projekat1.boris_jankovic_rn3317.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_input_patient.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import rs.raf.projekat1.boris_jankovic_rn3317.viewmodels.RecyclerViewModel
import java.util.*

class InputPatientFragment : Fragment(R.layout.fragment_input_patient) {

    private val recyclerViewModel : RecyclerViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        addBtn.setOnClickListener {
            var ok = true;
            val firstName = firstNameEt.text.toString()
            val lastName = lastNameEt.text.toString()
            val symptoms = symptomsEt.text.toString()

            if (firstName == "") {
                ok = false
                Toast.makeText(context, R.string.first_name_error_login, Toast.LENGTH_SHORT).show()
            }

            if (lastName == "") {
                ok = false
                Toast.makeText(context, R.string.last_name_error_login, Toast.LENGTH_SHORT).show()
            }

            if (symptoms == "") {
                ok = false
                Toast.makeText(context, R.string.symptoms_desc_error, Toast.LENGTH_SHORT).show()
            }

            if (ok) {
                val id = recyclerViewModel.getNextId()

                val patient = Patient(
                    id,
                    firstName,
                    lastName,
                    symptoms,
                    "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                    Date(),
                    null,
                    null
                )

                recyclerViewModel.addWaitingPatient(patient)

                firstNameEt.setText("")
                lastNameEt.setText("")
                symptomsEt.setText("")

                Toast.makeText(context, R.string.success_add_patient, Toast.LENGTH_LONG).show()
            }
        }
    }

}