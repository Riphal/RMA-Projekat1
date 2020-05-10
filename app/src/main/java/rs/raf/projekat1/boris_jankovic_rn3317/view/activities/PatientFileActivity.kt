package rs.raf.projekat1.boris_jankovic_rn3317.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_patient_file.*
import rs.raf.projekat1.boris_jankovic_rn3317.R
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import java.text.DateFormat

class PatientFileActivity : AppCompatActivity(R.layout.activity_patient_file) {

    companion object {
        const val PATIENT_KEY = "patient_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        init()
    }

    private fun init() {
        initView()
        initListeners()
    }

    private fun initView() {
        lateinit var patient: Patient

        intent?.let {
            patient = it.getParcelableExtra(PATIENT_KEY)

            firstNameEt.setText(patient.firstName)
            lastNameEt.setText(patient.lastName)
            stateOnAdmissionEt.setText(patient.symptoms)
            currentStateEt.setText(patient.symptoms)
            dateOfAdmissionTv.text = DateFormat.getDateInstance().format(patient.admissionDate)
        }
    }

    private fun initListeners() {
        lateinit var patient: Patient

        intent?.let {
            patient = it.getParcelableExtra(PATIENT_KEY)

            changeBtn.setOnClickListener {
                var ok = true;

                if (firstNameEt.text.toString() == "") {
                    ok = false
                    Toast.makeText(this, R.string.first_name_error_login, Toast.LENGTH_SHORT).show()
                }

                if (lastNameEt.text.toString() == "") {
                    ok = false
                    Toast.makeText(this, R.string.last_name_error_login, Toast.LENGTH_SHORT).show()
                }

                if (stateOnAdmissionEt.text.toString() == "") {
                    ok = false
                    Toast.makeText(this, R.string.symptoms_desc_error, Toast.LENGTH_SHORT).show()
                }

                if (currentStateEt.text.toString() == "") {
                    ok = false
                    Toast.makeText(this, R.string.symptoms_desc_error, Toast.LENGTH_SHORT).show()
                }

                if (ok) {
                    patient.firstName = firstNameEt.text.toString()
                    patient.lastName = lastNameEt.text.toString()
                    patient.symptoms = currentStateEt.text.toString()

                    val returnIntent = Intent()

                    returnIntent.putExtra(PATIENT_KEY, patient)
                    setResult(Activity.RESULT_OK, returnIntent)
                    finish()

                    Toast.makeText(this, R.string.success_edit, Toast.LENGTH_LONG).show()
                }
            }
        }

        cancelBtn.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}
