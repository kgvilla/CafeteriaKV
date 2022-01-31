package com.kevinvilla.cafeteriaKV.service

import com.google.gson.Gson
import com.kevinvilla.cafeteriaKV.model.Cafeteria
import com.kevinvilla.cafeteriaKV.model.Registration
import com.kevinvilla.cafeteriaKV.model.Usuario
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import com.kevinvilla.cafeteriaKV.repository.UsuarioRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.io.File


@SpringBootTest
class UserServiceEvaTest {


    @InjectMocks
    lateinit var usuarioService: UsuarioService

    @Mock
    lateinit var usuarioRepository: UsuarioRepository

    @Test
    fun UpdateCorrectUser(){
        Mockito.`when`(usuarioRepository.findById(usuarioMock.id)).thenReturn(usuarioMock)
        Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
        usuarioService.update(usuarioMock)
        val response = usuarioService.update(usuarioMock)
        Assertions.assertEquals(response.id, usuarioMock.id)
        Assertions.assertEquals(response.username, usuarioMock.username)
        Assertions.assertEquals(response.password, usuarioMock.password)
        Assertions.assertEquals(response.cedula, usuarioMock.cedula)
    }

    val jsonString = File("./src/test/resources/Usuario/newUsuario.json").readText(Charsets.UTF_8)
    val usuarioMock = Gson().fromJson(jsonString, Usuario::class.java)

    @Test
    fun UpdateDescriptionCorrectUserDoesNotExit(){
        Assertions.assertThrows(Exception::class.java) {
            usuarioMock.apply { username = "  " }
            Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
            usuarioService.updateDescription(usuarioMock)
        }

    }

    @Test
    fun  UpdateCorrectUserFailed(){

        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(usuarioRepository.findById(usuarioMock.id)).thenReturn(null)
            Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
            usuarioService.updateDescription(usuarioMock)

        }

    }

    @Test
    fun UpdateCorrectUserItIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            usuarioMock.apply { username = "  " }
            Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
            usuarioService.updateDescription(usuarioMock)
        }
    }

    @Test
    fun validaUserlist(){

        Assertions.assertThrows(Exception::class.java){
            Mockito.`when`(usuarioRepository.save(Mockito.any(Usuario::class.java))).thenReturn(usuarioMock)
        usuarioService.validaUser(usuarioMock)
        val response = usuarioService.validaUser(usuarioMock)

        }
    }





}