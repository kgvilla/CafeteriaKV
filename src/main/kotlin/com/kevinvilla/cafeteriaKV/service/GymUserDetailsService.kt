package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class GymUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var usuarioService: UsuarioService
    override fun loadUserByUsername(username: String?): UserDetails {

        val response = usuarioService.getUsuario(username)


        return User(response?.username,"{noop}"+response?.password, ArrayList())
    }

}

