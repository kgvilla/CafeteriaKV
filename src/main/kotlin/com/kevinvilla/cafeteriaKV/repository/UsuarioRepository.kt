package com.kevinvilla.cafeteriaKV.repository


import com.kevinvilla.cafeteriaKV.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findById(id: Long?): Usuario?
    @Query(value = "SELECT * FROM USUARIO u WHERE u.username = :username",
            nativeQuery = true)
    fun findByUsername(username: String?): Usuario?
}