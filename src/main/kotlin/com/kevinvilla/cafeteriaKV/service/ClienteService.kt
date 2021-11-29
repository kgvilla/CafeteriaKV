package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.ClienteRepository

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

        if(cliente.name.equals(""))
        {
            throw Exception()

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
        val response = clienteRepository.findById(cliente.id) ?: throw Exception()
        response.apply {
            this.apellido=cliente.apellido
        }
        return clienteRepository.save(response)
    }

    fun  delete ( id : Long ): Boolean {
        clienteRepository.deleteById (id)
        return  true
    }

    }
