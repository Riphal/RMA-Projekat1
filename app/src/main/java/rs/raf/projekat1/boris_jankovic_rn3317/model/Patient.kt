package rs.raf.projekat1.boris_jankovic_rn3317.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
data class Patient(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val symptoms: String,
    val picture: String = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
    val admissionDate: Date,
    var hospitalizationDate : Date?,
    var releasedDate : Date?
) : Parcelable
