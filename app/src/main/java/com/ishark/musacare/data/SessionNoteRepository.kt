package com.ishark.musacare.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionNoteRepository @Inject constructor(
    private val sessionNoteDao: SessionNoteDao
) {
    fun getAllSessionNotes(): Flow<List<SessionNote>> =
        sessionNoteDao.getAllSessionNotes()

    fun getSessionNotesForPatient(patientId: Long): Flow<List<SessionNote>> =
        sessionNoteDao.getSessionNotesForPatient(patientId)

    fun getSessionNoteById(noteId: Long): Flow<SessionNote?> =
        sessionNoteDao.getSessionNoteById(noteId)

    fun getSessionNoteForAppointment(appointmentId: Long): Flow<SessionNote?> =
        sessionNoteDao.getSessionNoteForAppointment(appointmentId)

    fun getSessionNotesByDateRange(
        startDate: String,
        endDate: String
    ): Flow<List<SessionNote>> =
        sessionNoteDao.getSessionNotesByDateRange(startDate, endDate)

    suspend fun insertSessionNote(sessionNote: SessionNote): Long =
        sessionNoteDao.insertSessionNote(sessionNote)

    suspend fun updateSessionNote(sessionNote: SessionNote) =
        sessionNoteDao.updateSessionNote(sessionNote)

    suspend fun deleteSessionNote(sessionNote: SessionNote) =
        sessionNoteDao.deleteSessionNote(sessionNote)
}