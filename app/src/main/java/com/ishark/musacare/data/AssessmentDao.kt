package com.ishark.musacare.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AssessmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssessment(assessment: Assessment): Long

    @Update
    suspend fun updateAssessment(assessment: Assessment)

    @Delete
    suspend fun deleteAssessment(assessment: Assessment)

    @Query("SELECT * FROM assessments ORDER BY date DESC")
    fun getAllAssessments(): Flow<List<Assessment>>

    @Query("SELECT * FROM assessments WHERE patientId = :patientId ORDER BY date DESC")
    fun getAssessmentsForPatient(patientId: Long): Flow<List<Assessment>>

    @Query("SELECT * FROM assessments WHERE patientId = :patientId AND type = :type ORDER BY date DESC")
    fun getAssessmentsForPatientByType(patientId: Long, type: String): Flow<List<Assessment>>

    @Query("SELECT * FROM assessments WHERE id = :assessmentId")
    fun getAssessmentById(assessmentId: Long): Flow<Assessment?>

    @Query("SELECT * FROM assessments WHERE patientId = :patientId ORDER BY date DESC LIMIT 1")
    fun getLatestAssessmentForPatient(patientId: Long): Flow<Assessment?>
}