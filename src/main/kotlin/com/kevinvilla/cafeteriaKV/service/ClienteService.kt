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

        //return clienteRepository.save(cliente)

        if(cliente.name.equals("\"name no puede estar en vacio\""))
        {
            throw Exception("name no puede estar en vacio")

        }
        else
        {
            return clienteRepository.save(cliente)
        }
    }





    fun update(cliente: Cliente):Cliente{
        return clienteRepository.save(cliente)
    }
    fun updateDescription(cliente: Cliente):Cliente{

        try {
            if (cliente.name.equals("")){
                throw Exception("name no puede estar en vacio")
            }
            val response = clienteRepository.findById(cliente.id)
                    ?: throw Exception("El id ${cliente.id} en cliente no existe")
            response.apply {
                this.name = cliente.name
            }
            return clienteRepository.save(cliente)
        }
        catch (ex: Exception) {

            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun  delete ( id : Long ): Boolean {
        clienteRepository.deleteById (id)
        return  true
    }

    }
