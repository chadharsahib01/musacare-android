package com.ishark.musacare.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessionNote(sessionNote: SessionNote): Long

    @Update
    suspend fun updateSessionNote(sessionNote: SessionNote)

    @Delete
    suspend fun deleteSessionNote(sessionNote: SessionNote)

    @Query("SELECT * FROM session_notes ORDER BY date DESC")
    fun getAllSessionNotes(): Flow<List<SessionNote>>

    @Query("SELECT * FROM session_notes WHERE patientId = :patientId ORDER BY date DESC")
    fun getSessionNotesForPatient(patientId: Long): Flow<List<SessionNote>>

    @Query("SELECT * FROM session_notes WHERE id = :noteId")
    fun getSessionNoteById(noteId: Long): Flow<SessionNote?>

    @Query("SELECT * FROM session_notes WHERE appointmentId = :appointmentId")
    fun getSessionNoteForAppointment(appointmentId: Long): Flow<SessionNote?>

    @Query("SELECT * FROM session_notes WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getSessionNotesByDateRange(startDate: String, endDate: String): Flow<List<SessionNote>>
}