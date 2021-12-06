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

        return cafeteriaRepository.save(cafeteria)
    }


    fun update(cafeteria: Cafeteria): Cafeteria {
        return cafeteriaRepository.save(cafeteria)
    }

    fun updateDescription(cafeteria: Cafeteria):Cafeteria{
        try {
            if (cafeteria.registro.equals("registro")){
                throw Exception("el registro debe estar completado")
            }
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

    fun  delete ( id : Long ): Boolean {
        cafeteriaRepository.deleteById (id)
        return  true
    }

}