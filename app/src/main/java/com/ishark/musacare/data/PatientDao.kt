package com.ishark.musacare.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatient(patient: Patient): Long

    @Update
    suspend fun updatePatient(patient: Patient)

    @Delete
    suspend fun deletePatient(patient: Patient)

    @Query("SELECT * FROM patients ORDER BY fullName ASC")
    fun getAllPatients(): Flow<List<Patient>>

    @Query("SELECT * FROM patients WHERE id = :patientId")
    fun getPatientById(patientId: Long): Flow<Patient?>

    @Query("SELECT * FROM patients WHERE fullName LIKE '%' || :query || '%' OR diagnosis LIKE '%' || :query || '%' ORDER BY fullName ASC")
    fun searchPatients(query: String): Flow<List<Patient>>

    @Query("SELECT COUNT(*) FROM patients")
    fun getPatientCount(): Flow<Int>
}