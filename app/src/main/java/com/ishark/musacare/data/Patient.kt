package com.ishark.musacare.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fullName: String,
    val dateOfBirth: String,
    val gender: String,
    val contactNumber: String,
    val email: String = "",
    val address: String = "",
    val diagnosis: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)