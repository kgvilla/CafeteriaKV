package com.kevinvilla.cafeteriaKV.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class UserServiceTest {

    @Autowired
    lateinit var usuarioService: UsuarioService



    @Test
    fun calMultiplicationIfIsPair(){
        val response = usuarioService.calMultiplication(2,4)
        Assertions.assertEquals(8,response)
    }

    @Test
    fun calMultiplicationIfIsNotPair(){
        val response = usuarioService.calMultiplication(1,4)
        Assertions.assertEquals(4,response)
    }

    @Test
    fun restNineIfIsNotPair(){
        val response = usuarioService.restNine(8)
        Assertions.assertEquals(8,response)
    }

    @Test
    fun restNineIfIsHigherTen(){
        val response = usuarioService.restNine(10)
        Assertions.assertEquals(1,response)
    }

    @Test
    fun subtactFromNextTen(){

        val response = usuarioService.subtactFromNextTen(34)
        Assertions.assertEquals(6,response)
    }

    @Test
    fun verficedula(){

        val response: Boolean = usuarioService.verificedula("0106485550")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun verficedulaIncorrect(){

        val response: Boolean = usuarioService.cedulaIncorrect("01064855501")
        Assertions.assertEquals(false,response)
    }




}