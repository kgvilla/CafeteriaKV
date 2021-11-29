package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Registration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.kevinvilla.cafeteriaKV.repository.RegistrationRepository

@Service
class RegistrationService {
    @Autowired
    lateinit var registrationRepository: RegistrationRepository

    fun list(): List<Registration> {

        return registrationRepository.findAll()

    }

    @PostMapping
    fun save (@RequestBody registration: Registration): Registration {

        return registrationRepository.save(registration)
    }



    fun update(registration: Registration):Registration{
        return registrationRepository.save(registration)
    }

    fun updateDescription(registration: Registration): Registration {
        val response = registrationRepository.findById(registration.id) ?: throw Exception()
        response.apply {
            this.fecha=registration.fecha
        }
        return registrationRepository.save(response)
    }



    fun delete (id:Long): Boolean{
        registrationRepository.deleteById(id)
        return true
    }

}