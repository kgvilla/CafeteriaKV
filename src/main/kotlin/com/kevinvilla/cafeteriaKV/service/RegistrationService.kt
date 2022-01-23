package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Registration
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import com.kevinvilla.cafeteriaKV.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.RegistrationRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class RegistrationService {
    @Autowired
    lateinit var registrationRepository: RegistrationRepository



    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun list(): List<Registration> {

        return registrationRepository.findAll()

    }

    @PostMapping
    fun save (@RequestBody registration: Registration): Registration {
        try {
            registration.lugar?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw Exception("se debe tener en cuenta el lugar")





        return registrationRepository.save(registration)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }



    fun updateDescription(registration: Registration): Registration {
        try {
            registration.lugar?.takeIf {it.trim()?.isNotEmpty()}
                ?: throw Exception("se debe tener en cuenta el lugar")
            val response = registrationRepository.findById(registration.id)
                    ?: throw Exception("El id ${registration .lugar} en registration no existe")
            response.apply {
                this.lugar= registration.lugar
            }
            return registrationRepository.save(registration)


        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun delete (id:Long): Boolean{
        registrationRepository.deleteById(id)
        return true
    }

}