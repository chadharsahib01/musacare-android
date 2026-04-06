package com.ishark.musacare.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MusaCareNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Dashboard.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(Screen.PatientList.route) {
            PatientListScreen(navController = navController)
        }
        composable(
            route = Screen.PatientDetail.route,
            arguments = listOf(navArgument("patientId") { type = NavType.LongType })
        ) { backStackEntry ->
            val patientId = backStackEntry.arguments?.getLong("patientId") ?: 0L
            PatientDetailScreen(navController = navController, patientId = patientId)
        }
        composable(
            route = Screen.AddEditPatient.route,
            arguments = listOf(
                navArgument("patientId") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) { backStackEntry ->
            val patientId = backStackEntry.arguments?.getLong("patientId")?.takeIf { it != -1L }
            AddEditPatientScreen(navController = navController, patientId = patientId)
        }
        composable(Screen.AppointmentList.route) {
            AppointmentListScreen(navController = navController)
        }
        composable(
            route = Screen.AppointmentDetail.route,
            arguments = listOf(navArgument("appointmentId") { type = NavType.LongType })
        ) { backStackEntry ->
            val appointmentId = backStackEntry.arguments?.getLong("appointmentId") ?: 0L
            AppointmentDetailScreen(navController = navController, appointmentId = appointmentId)
        }
        composable(
            route = Screen.AddEditAppointment.route,
            arguments = listOf(
                navArgument("appointmentId") {
                    type = NavType.LongType
                    defaultValue = -1L
                },
                navArgument("patientId") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) { backStackEntry ->
            val appointmentId = backStackEntry.arguments?.getLong("appointmentId")?.takeIf { it != -1L }
            val patientId = backStackEntry.arguments?.getLong("patientId")?.takeIf { it != -1L }
            AddEditAppointmentScreen(
                navController = navController,
                appointmentId = appointmentId,
                patientId = patientId
            )
        }
        composable(Screen.SessionNoteList.route) {
            SessionNoteListScreen(navController = navController)
        }
        composable(
            route = Screen.SessionNoteDetail.route,
            arguments = listOf(navArgument("noteId") { type = NavType.LongType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getLong("noteId") ?: 0L
            SessionNoteDetailScreen(navController = navController, noteId = noteId)
        }
        composable(
            route = Screen.AddEditSessionNote.route,
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.LongType
                    defaultValue = -1L
                },
                navArgument("patientId") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getLong("noteId")?.takeIf { it != -1L }
            val patientId = backStackEntry.arguments?.getLong("patientId")?.takeIf { it != -1L }
            AddEditSessionNoteScreen(
                navController = navController,
                noteId = noteId,
                patientId = patientId
            )
        }
        composable(Screen.AssessmentList.route) {
            AssessmentListScreen(navController = navController)
        }
        composable(
            route = Screen.TakeAssessment.route,
            arguments = listOf(
                navArgument("type") { type = NavType.StringType },
                navArgument("patientId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: ""
            val patientId = backStackEntry.arguments?.getLong("patientId") ?: 0L
            TakeAssessmentScreen(
                navController = navController,
                assessmentType = type,
                patientId = patientId
            )
        }
        composable(
            route = Screen.AssessmentResult.route,
            arguments = listOf(navArgument("assessmentId") { type = NavType.LongType })
        ) { backStackEntry ->
            val assessmentId = backStackEntry.arguments?.getLong("assessmentId") ?: 0L
            AssessmentResultScreen(navController = navController, assessmentId = assessmentId)
        }
    }
}