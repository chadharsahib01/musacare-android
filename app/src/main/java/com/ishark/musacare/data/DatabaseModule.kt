package com.ishark.musacare.di

import android.content.Context
import androidx.room.Room
import com.ishark.musacare.data.AssessmentDao
import com.ishark.musacare.data.AppointmentDao
import com.ishark.musacare.data.MusaCareDatabase
import com.ishark.musacare.data.PatientDao
import com.ishark.musacare.data.SessionNoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MusaCareDatabase {
        return Room.databaseBuilder(
            context,
            MusaCareDatabase::class.java,
            MusaCareDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePatientDao(database: MusaCareDatabase): PatientDao {
        return database.patientDao()
    }

    @Provides
    @Singleton
    fun provideAppointmentDao(database: MusaCareDatabase): AppointmentDao {
        return database.appointmentDao()
    }

    @Provides
    @Singleton
    fun provideSessionNoteDao(database: MusaCareDatabase): SessionNoteDao {
        return database.sessionNoteDao()
    }

    @Provides
    @Singleton
    fun provideAssessmentDao(database: MusaCareDatabase): AssessmentDao {
        return database.assessmentDao()
    }
}