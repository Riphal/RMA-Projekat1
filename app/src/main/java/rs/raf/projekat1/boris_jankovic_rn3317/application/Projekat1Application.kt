package rs.raf.projekat1.boris_jankovic_rn3317.application

import android.app.Application
import timber.log.Timber

class Projekat1Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}