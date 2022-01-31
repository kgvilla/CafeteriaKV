package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Cafeteria

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class CafeteriaService {
    @Autowired
    lateinit var cafeteriaRepository: CafeteriaRepository


    fun list(): List<Cafeteria> {

        return cafeteriaRepository.findAll()
    }
    @PostMapping
    fun save (@RequestBody cafeteria: Cafeteria): Cafeteria {

        try {
            cafeteria.entrega?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw Exception("se debe tener en cuenta la entrega")
            return cafeteriaRepository.save(cafeteria)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }


    fun update(cafeteria: Cafeteria): Cafeteria {
        return cafeteriaRepository.save(cafeteria)
    }

    fun updateDescription(cafeteria: Cafeteria):Cafeteria{
        try {
            cafeteria.registro?.takeIf {it.trim()?.isNotEmpty()}
                ?: throw Exception("el registro no debe estar vacio")

            val response = cafeteriaRepository.findById(cafeteria.id)
                    ?: throw Exception("El id ${cafeteria.id} en cafeteria no existe")
            response.apply {
                this.registro = cafeteria.registro
            }
            return cafeteriaRepository.save(cafeteria)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun  delete ( id : Long? ): Boolean {
        try {
            cafeteriaRepository.findById(id)
                    ?: throw Exception(" No existe el Id")
            cafeteriaRepository.deleteById(id!!)
            return true
        }catch (ex: Exception){
            throw Exception()
        }
    }

    }
