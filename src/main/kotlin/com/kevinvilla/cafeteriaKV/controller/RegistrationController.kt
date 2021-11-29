package com.kevinvilla.cafeteriaKV.controller


import com.kevinvilla.cafeteriaKV.model.Registration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kevinvilla.cafeteriaKV.service.RegistrationService

@RestController
@RequestMapping("/registration")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class RegistrationController {
    @Autowired
    lateinit var registrationService: RegistrationService

    @GetMapping
    fun list(): List<Registration>{
        return registrationService.list()
    }



    @PostMapping
    fun save (@RequestBody registration: Registration): Registration {
        return  registrationService.save(registration)

    }

    @PutMapping
    fun update (@RequestBody registration: Registration):Registration{
        return registrationService.update(registration)
    }

    @PatchMapping
    fun patch(@RequestBody registration: Registration):Registration{
        return registrationService.updateDescription(registration)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return registrationService.delete(id)
    }

}