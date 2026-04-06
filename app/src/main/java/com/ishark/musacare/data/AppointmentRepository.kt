package com.ishark.musacare.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppointmentRepository @Inject constructor(
    private val appointmentDao: AppointmentDao
) {
    fun getAllAppointments(): Flow<List<Appointment>> =
        appointmentDao.getAllAppointments()

    fun getAppointmentsForPatient(patientId: Long): Flow<List<Appointment>> =
        appointmentDao.getAppointmentsForPatient(patientId)

    fun getAppointmentById(appointmentId: Long): Flow<Appointment?> =
        appointmentDao.getAppointmentById(appointmentId)

    fun getAppointmentsByDate(date: String): Flow<List<Appointment>> =
        appointmentDao.getAppointmentsByDate(date)

    fun getUpcomingAppointments(today: String): Flow<List<Appointment>> =
        appointmentDao.getUpcomingAppointments(today)

    fun getAppointmentsByStatus(status: String): Flow<List<Appointment>> =
        appointmentDao.getAppointmentsByStatus(status)

    fun getTodayAppointmentCount(today: String): Flow<Int> =
        appointmentDao.getTodayAppointmentCount(today)

    suspend fun insertAppointment(appointment: Appointment): Long =
        appointmentDao.insertAppointment(appointment)

    suspend fun updateAppointment(appointment: Appointment) =
        appointmentDao.updateAppointment(appointment)

    suspend fun deleteAppointment(appointment: Appointment) =
        appointmentDao.deleteAppointment(appointment)
}