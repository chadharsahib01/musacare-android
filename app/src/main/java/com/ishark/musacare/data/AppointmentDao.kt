package com.ishark.musacare.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: Appointment): Long

    @Update
    suspend fun updateAppointment(appointment: Appointment)

    @Delete
    suspend fun deleteAppointment(appointment: Appointment)

    @Query("SELECT * FROM appointments ORDER BY date ASC, time ASC")
    fun getAllAppointments(): Flow<List<Appointment>>

    @Query("SELECT * FROM appointments WHERE patientId = :patientId ORDER BY date ASC, time ASC")
    fun getAppointmentsForPatient(patientId: Long): Flow<List<Appointment>>

    @Query("SELECT * FROM appointments WHERE id = :appointmentId")
    fun getAppointmentById(appointmentId: Long): Flow<Appointment?>

    @Query("SELECT * FROM appointments WHERE date = :date ORDER BY time ASC")
    fun getAppointmentsByDate(date: String): Flow<List<Appointment>>

    @Query("SELECT * FROM appointments WHERE date >= :today ORDER BY date ASC, time ASC")
    fun getUpcomingAppointments(today: String): Flow<List<Appointment>>

    @Query("SELECT * FROM appointments WHERE status = :status ORDER BY date ASC")
    fun getAppointmentsByStatus(status: String): Flow<List<Appointment>>

    @Query("SELECT COUNT(*) FROM appointments WHERE date = :today")
    fun getTodayAppointmentCount(today: String): Flow<Int>
}