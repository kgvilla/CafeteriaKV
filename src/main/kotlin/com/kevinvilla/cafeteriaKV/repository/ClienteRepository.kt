package com.kevinvilla.cafeteriaKV.repository

import com.kevinvilla.cafeteriaKV.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long> {
    fun findById(id: Long?): Cliente?
}