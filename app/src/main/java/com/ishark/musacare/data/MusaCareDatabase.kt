package com.ishark.musacare.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Patient::class,
        Appointment::class,
        SessionNote::class,
        Assessment::class
    ],
    version = 1,
    exportSchema = true
)
abstract class MusaCareDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun appointmentDao(): AppointmentDao
    abstract fun sessionNoteDao(): SessionNoteDao
    abstract fun assessmentDao(): AssessmentDao

    companion object {
        const val DATABASE_NAME = "musacare_database"
    }
}