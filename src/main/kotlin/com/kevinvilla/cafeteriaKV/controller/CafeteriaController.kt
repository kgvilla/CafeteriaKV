package com.kevinvilla.cafeteriaKV.controller

import com.kevinvilla.cafeteriaKV.model.Cafeteria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kevinvilla.cafeteriaKV.service.CafeteriaService

@RestController
@RequestMapping("/cafeteria")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class CafeteriaController {
    @Autowired
    lateinit var cafeteriaService: CafeteriaService

    @GetMapping
    fun list(): List<Cafeteria>{
        return cafeteriaService.list()
    }

    @PostMapping
    fun save (@RequestBody cafeteria: Cafeteria): Cafeteria {
        return cafeteriaService.save(cafeteria)

    }

    @PutMapping
    fun update (@RequestBody cafeteria: Cafeteria): Cafeteria {
        return cafeteriaService.update(cafeteria)
    }

    @PatchMapping
    fun updateDescription (@RequestBody cafeteria: Cafeteria): Cafeteria {
        return cafeteriaService.updateDescription(cafeteria)
    }

    @DeleteMapping ("/delete/{id}")
    fun  delete (@PathVariable ( "id" ) id: Long ): Boolean {
        return cafeteriaService.delete (id)
    }
}