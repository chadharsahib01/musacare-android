package com.ishark.musacare.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssessmentRepository @Inject constructor(
    private val assessmentDao: AssessmentDao
) {
    fun getAllAssessments(): Flow<List<Assessment>> =
        assessmentDao.getAllAssessments()

    fun getAssessmentsForPatient(patientId: Long): Flow<List<Assessment>> =
        assessmentDao.getAssessmentsForPatient(patientId)

    fun getAssessmentsForPatientByType(
        patientId: Long,
        type: String
    ): Flow<List<Assessment>> =
        assessmentDao.getAssessmentsForPatientByType(patientId, type)

    fun getAssessmentById(assessmentId: Long): Flow<Assessment?> =
        assessmentDao.getAssessmentById(assessmentId)

    fun getLatestAssessmentForPatient(patientId: Long): Flow<Assessment?> =
        assessmentDao.getLatestAssessmentForPatient(patientId)

    suspend fun insertAssessment(assessment: Assessment): Long =
        assessmentDao.insertAssessment(assessment)

    suspend fun updateAssessment(assessment: Assessment) =
        assessmentDao.updateAssessment(assessment)

    suspend fun deleteAssessment(assessment: Assessment) =
        assessmentDao.deleteAssessment(assessment)
}