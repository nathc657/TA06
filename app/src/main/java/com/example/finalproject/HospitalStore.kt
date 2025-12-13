package com.example.finalproject

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object HospitalStore {
    private val _selectedHospital = MutableStateFlow<Hospital?>(null)
    val selectedHospital: StateFlow<Hospital?> = _selectedHospital

    fun setSelectedHospital(hospital: Hospital?) {
        _selectedHospital.value = hospital
    }
}