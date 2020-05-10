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

    private val dischargedPatients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val dischargedPatientsList : MutableList<Patient> = mutableListOf()

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

    fun getWaitingPatients() : MutableLiveData<List<Patient>> {
        return waitingPatients
    }

    fun getWaitingPatientsList(): MutableList<Patient> {
        return waitingPatientsList
    }

    fun getHospitalizedPatients() : MutableLiveData<List<Patient>>{
        return hospitalizedPatients
    }

    fun getHospitalizedPatientList(): MutableList<Patient> {
        return hospitalizedPatientsList
    }

    fun getDischargedPatients() : MutableLiveData<List<Patient>>{
        return dischargedPatients
    }

    fun getDischargedPatientsList(): MutableList<Patient> {
        return dischargedPatientsList
    }

    fun getNextId(): Int {
        return (waitingPatients.value?.size ?: 0) +
                (hospitalizedPatients.value?.size ?: 0) +
                (dischargedPatients.value?.size ?: 0) + 1
    }

    fun filterPatients (list : MutableList<Patient>, liveList : MutableLiveData<List<Patient>>, filter : String) {
        val filteredList = list.filter {
            it.firstName.toLowerCase().startsWith(filter.toLowerCase()) ||
            it.lastName.toLowerCase().startsWith(filter.toLowerCase())
        }

        liveList.value = filteredList;
    }

    fun removePatient (list : MutableList<Patient>, liveList : MutableLiveData<List<Patient>>, patient: Patient) {
        list.remove(patient)

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(list)

        liveList.value = listToSubmit
    }

    fun addPatient (list : MutableList<Patient>, liveList : MutableLiveData<List<Patient>>, patient : Patient) {
        list.add(patient)

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(list)

        liveList.value = listToSubmit
    }

}