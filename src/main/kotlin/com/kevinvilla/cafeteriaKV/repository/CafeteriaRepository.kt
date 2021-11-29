package com.kevinvilla.cafeteriaKV.repository

import com.kevinvilla.cafeteriaKV.model.Cafeteria
import org.springframework.data.jpa.repository.JpaRepository

interface CafeteriaRepository: JpaRepository<Cafeteria, Long> {
    fun findById(id: Long?): Cafeteria?
}