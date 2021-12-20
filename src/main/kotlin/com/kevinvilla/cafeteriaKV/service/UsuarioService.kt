package com.kevinvilla.cafeteriaKV.service


import com.kevinvilla.cafeteriaKV.model.Usuario

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.kevinvilla.cafeteriaKV.repository.UsuarioRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository


    fun list(): List<Usuario> {

        return usuarioRepository.findAll()
    }

    fun getUsuario (username: String?): Usuario? {

        try {
            val response = usuarioRepository.findByUsername(username)
                    ?: throw Exception("Usuario no exixte")
            return response
        }catch (ex: Exception) {

            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun update(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }


}