package com.kevinvilla.cafeteriaKV.controller

import com.kevinvilla.cafeteriaKV.model.Cliente
import com.kevinvilla.cafeteriaKV.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kevinvilla.cafeteriaKV.service.ClienteService
import com.kevinvilla.cafeteriaKV.service.UsuarioService

@RestController
@RequestMapping("/usuario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun list(): List<Usuario>{
        return usuarioService.list()
    }

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario {
        return usuarioService.save(usuario)

    }



    @PutMapping
    fun update (@RequestBody usuario: Usuario): Usuario{
        return usuarioService.update(usuario)
    }



}