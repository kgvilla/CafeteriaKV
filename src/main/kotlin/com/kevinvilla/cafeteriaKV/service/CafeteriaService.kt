package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Cafeteria

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository

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
        val response = cafeteriaRepository.findById(cafeteria.id) ?: throw Exception()
        response.apply {
            this.client=cafeteria.client
        }
        return cafeteriaRepository.save(response)
    }

    fun  delete ( id : Long ): Boolean {
        cafeteriaRepository.deleteById (id)
        return  true
    }

}