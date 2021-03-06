package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.ClienteRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class ClienteService {
    @Autowired
    lateinit var clienteRepository: ClienteRepository


    fun list(): List<Cliente> {

        return clienteRepository.findAll()
    }

    @PostMapping
    fun save(@RequestBody cliente: Cliente): Cliente {
        try {
            cliente.cedula?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw Exception("se debe tener en cuenta la cedula del cliente")
            return clienteRepository.save(cliente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(cliente: Cliente):Cliente{
        return clienteRepository.save(cliente)
    }
    fun updateDescription(cliente: Cliente):Cliente{
        try {
            cliente.cedula?.takeIf {it.trim()?.isNotEmpty()}
                 ?: throw Exception("cedula no puede estar en vacio")

            val response = clienteRepository.findById(cliente.id)
                    ?: throw Exception("El id ${cliente.id} en cliente no existe")
            response.apply {
                this.cedula = cliente.cedula
            }
            return clienteRepository.save(cliente)
        }
        catch (ex: Exception) {

            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun  delete ( id : Long? ): Boolean {
        try {
            clienteRepository.findById(id)
                    ?: throw Exception(" No existe el Id")
            clienteRepository.deleteById(id!!)
            return true
        }catch (ex: Exception){
            throw Exception()
        }
    }

    }
