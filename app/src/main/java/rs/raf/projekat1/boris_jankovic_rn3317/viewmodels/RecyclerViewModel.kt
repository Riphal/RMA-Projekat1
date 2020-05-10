package rs.raf.projekat1.boris_jankovic_rn3317.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.boris_jankovic_rn3317.model.Patient
import java.util.*

class RecyclerViewModel : ViewModel() {
    private val waitingPatients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val waitingPatientsList : MutableList<Patient> = mutableListOf()

    private val hospitalizedPatients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val hospitalizedPatientsList : MutableList<Patient> = mutableListOf()

    private val recoveredPatients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val recoveredPatientsList : MutableList<Patient> = mutableListOf()

    init {
        for(i in 1..10) {
            val patient = Patient(
                i,
                "Pera $i",
                "Peric $i",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                Date(),
                null,
                null
            )

            waitingPatientsList.add(patient)
        }

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(waitingPatientsList)
        waitingPatients.value = listToSubmit
    }

    fun getWaitingPatients() : LiveData<List<Patient>> {
        return waitingPatients
    }

    fun getWaitingPatientsList(): MutableList<Patient> {
        return waitingPatientsList
    }

    fun getNextId(): Int {
        return (waitingPatients.value?.size ?: 0) +
                (hospitalizedPatients.value?.size ?: 0) +
                (recoveredPatients.value?.size ?: 0) + 1
    }

    fun filterWaitingPatients (filter : String) {
        val filteredList = waitingPatientsList.filter {
            it.firstName.toLowerCase().startsWith(filter.toLowerCase()) ||
            it.lastName.toLowerCase().startsWith(filter.toLowerCase())
        }

        waitingPatients.value = filteredList;
    }

    fun removeWaitingPatient (patient: Patient) {
        waitingPatientsList.remove(patient)

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(waitingPatientsList)

        waitingPatients.value = listToSubmit
    }

    fun addWaitingPatient (patient : Patient) {
        waitingPatientsList.add(patient)

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(waitingPatientsList)

        waitingPatients.value = listToSubmit
    }

}