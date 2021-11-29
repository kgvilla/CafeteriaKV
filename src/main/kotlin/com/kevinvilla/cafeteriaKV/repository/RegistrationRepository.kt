package com.kevinvilla.cafeteriaKV.repository


import com.kevinvilla.cafeteriaKV.model.Registration
import org.springframework.data.jpa.repository.JpaRepository

interface RegistrationRepository: JpaRepository<Registration, Long> {
    fun findById(id: Long?): Registration?
}