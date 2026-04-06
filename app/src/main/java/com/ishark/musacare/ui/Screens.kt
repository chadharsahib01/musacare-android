package com.ishark.musacare.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DashboardScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Dashboard - MusaCare")
    }
}

@Composable
fun PatientListScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Patient List")
    }
}

@Composable
fun PatientDetailScreen(navController: NavHostController, patientId: Long) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Patient Detail: $patientId")
    }
}

@Composable
fun AddEditPatientScreen(navController: NavHostController, patientId: Long?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = if (patientId == null) "Add Patient" else "Edit Patient: $patientId")
    }
}

@Composable
fun AppointmentListScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Appointment List")
    }
}

@Composable
fun AppointmentDetailScreen(navController: NavHostController, appointmentId: Long) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Appointment Detail: $appointmentId")
    }
}

@Composable
fun AddEditAppointmentScreen(
    navController: NavHostController,
    appointmentId: Long?,
    patientId: Long?
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = if (appointmentId == null) "Add Appointment" else "Edit Appointment")
    }
}

@Composable
fun SessionNoteListScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Session Notes")
    }
}

@Composable
fun SessionNoteDetailScreen(navController: NavHostController, noteId: Long) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Session Note Detail: $noteId")
    }
}

@Composable
fun AddEditSessionNoteScreen(
    navController: NavHostController,
    noteId: Long?,
    patientId: Long?
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = if (noteId == null) "Add Session Note" else "Edit Session Note")
    }
}

@Composable
fun AssessmentListScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Assessments")
    }
}

@Composable
fun TakeAssessmentScreen(
    navController: NavHostController,
    assessmentType: String,
    patientId: Long
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Take Assessment: $assessmentType")
    }
}

@Composable
fun AssessmentResultScreen(navController: NavHostController, assessmentId: Long) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Assessment Result: $assessmentId")
    }
}