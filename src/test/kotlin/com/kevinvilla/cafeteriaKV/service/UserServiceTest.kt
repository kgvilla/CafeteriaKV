package com.kevinvilla.cafeteriaKV.service

import com.google.gson.Gson
import com.kevinvilla.cafeteriaKV.model.Registration
import com.kevinvilla.cafeteriaKV.model.Usuario
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class UserServiceTest {


    @InjectMocks
    lateinit var usuarioService: UsuarioService

    @Mock
    lateinit var usuarioRepository: CafeteriaRepository

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