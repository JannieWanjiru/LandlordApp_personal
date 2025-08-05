package com.example.navigationuidemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class TenantViewModel : ViewModel() {
    private val _tenantInfo = MutableLiveData<String>("")
    val tenantInfo: LiveData<String> = _tenantInfo

    fun addTenant(name: String, unit: String, rent: String) {
        val newEntry = "Name: $name\nUnit: $unit\nRent: $rent\n\n"
        _tenantInfo.value = (_tenantInfo.value ?: "") + newEntry
    }

    // BONUS: Capitalized version for display
    val capitalizedTenantInfo: LiveData<String> = tenantInfo.map { it.uppercase() }

    // BONUS: Count tenants
    val tenantCount: LiveData<Int> = tenantInfo.map { info ->
        info.trim().split("\n\n").filter { it.isNotBlank() }.size
    }
}
