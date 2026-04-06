package com.ishark.musacare.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientRepository @Inject constructor(
    private val patientDao: PatientDao
) {
    fun getAllPatients(): Flow<List<Patient>> =
        patientDao.getAllPatients()

    fun getPatientById(patientId: Long): Flow<Patient?> =
        patientDao.getPatientById(patientId)

    fun searchPatients(query: String): Flow<List<Patient>> =
        patientDao.searchPatients(query)

    fun getPatientCount(): Flow<Int> =
        patientDao.getPatientCount()

    suspend fun insertPatient(patient: Patient): Long =
        patientDao.insertPatient(patient)

    suspend fun updatePatient(patient: Patient) =
        patientDao.updatePatient(patient)

    suspend fun deletePatient(patient: Patient) =
        patientDao.deletePatient(patient)
}