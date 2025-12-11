package com.example.finalproject

data class Hospital(
    val name: String,
    val specializations: List<String>,
    val availableBeds: Int,
    val website: String,
    val phone: String
)

fun sampleHospitalData(): List<Hospital> = listOf(
    Hospital(
        name = "12311 Hospital One Ave",
        specializations = listOf(
            "Bone Specializations",
            "Heart Surgery Specialization",
            "Lung Surgeon Specialization"
        ),
        availableBeds = 127,
        website = "www.hospital.com",
        phone = "(555) 111 2222"
    ),
    Hospital(
        name = "5153 Urgent Care Rd",
        specializations = listOf(
            "Bone Specializations",
            "Neurological Specialization",
            "Stomach Surgeon Specialization"
        ),
        availableBeds = 101,
        website = "www.medical.com",
        phone = "(555) 987 6543"
    ),
    Hospital(
        name = "31357 Hospital Way",
        specializations = listOf(
            "Blood Lab Specialization",
            "Stomach Surgeon Specialization"
        ),
        availableBeds = 23,
        website = "www.urgent.com",
        phone = "(555) 987 6543"
    )
)
