package com.ishark.musacare.ui

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object PatientList : Screen("patient_list")
    object PatientDetail : Screen("patient_detail/{patientId}") {
        fun createRoute(patientId: Long) = "patient_detail/$patientId"
    }
    object AddEditPatient : Screen("add_edit_patient?patientId={patientId}") {
        fun createRoute(patientId: Long? = null) =
            if (patientId != null) "add_edit_patient?patientId=$patientId"
            else "add_edit_patient"
    }
    object AppointmentList : Screen("appointment_list")
    object AppointmentDetail : Screen("appointment_detail/{appointmentId}") {
        fun createRoute(appointmentId: Long) = "appointment_detail/$appointmentId"
    }
    object AddEditAppointment : Screen("add_edit_appointment?appointmentId={appointmentId}&patientId={patientId}") {
        fun createRoute(appointmentId: Long? = null, patientId: Long? = null) =
            "add_edit_appointment?appointmentId=$appointmentId&patientId=$patientId"
    }
    object SessionNoteList : Screen("session_note_list")
    object SessionNoteDetail : Screen("session_note_detail/{noteId}") {
        fun createRoute(noteId: Long) = "session_note_detail/$noteId"
    }
    object AddEditSessionNote : Screen("add_edit_session_note?noteId={noteId}&patientId={patientId}") {
        fun createRoute(noteId: Long? = null, patientId: Long? = null) =
            "add_edit_session_note?noteId=$noteId&patientId=$patientId"
    }
    object AssessmentList : Screen("assessment_list")
    object TakeAssessment : Screen("take_assessment/{type}/{patientId}") {
        fun createRoute(type: String, patientId: Long) = "take_assessment/$type/$patientId"
    }
    object AssessmentResult : Screen("assessment_result/{assessmentId}") {
        fun createRoute(assessmentId: Long) = "assessment_result/$assessmentId"
    }
}