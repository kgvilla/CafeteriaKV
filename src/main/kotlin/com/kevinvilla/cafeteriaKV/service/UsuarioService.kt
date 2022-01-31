package com.kevinvilla.cafeteriaKV.service

import com.kevinvilla.cafeteriaKV.model.Cafeteria
import com.kevinvilla.cafeteriaKV.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.kevinvilla.cafeteriaKV.repository.UsuarioRepository
import org.springframework.boot.context.properties.bind.Bindable
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository


    fun list(): List<Usuario> {

        return usuarioRepository.findAll()
    }

    fun verificar(username: String?): Boolean{
        if(username?.length!!>7){
            return false

        }
        return true
    }

    fun calMultiplication(index: Int, number: Int):Int{
        if (index %2 ==0){
            return number *2

        }
        else{
            return number
        }

    }

    fun restNine(number: Int):Int{
        if (number >=10){
            return number -9
        }
        return number

    }

    fun subtactFromNextTen(number: Int):Int{
        var decena = (number/10) +1
        var response = (decena+10) - number

        if (response == 10){
            return 0
        }
        return response
    }

    fun verificedula(cedula: String): Boolean{
        if(cedula?.length!!>=10){

        }
        return true
    }

    fun cedulaIncorrect(cedula: String): Boolean{
        if(cedula?.length!!>11){

        }
        return false
    }

    fun save(usuario: Usuario): Usuario{


        return usuarioRepository.save(usuario)
    }


    fun getUsuario (username: String?): Usuario? {

        try {

            val response = usuarioRepository.findByUsername(username)
                    ?: throw Exception("Usuario no exixte")
            return response
        }catch (ex: Exception) {

            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun update(usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun updateDescription(usuario: Usuario): Usuario {
        try {
            usuario.username?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw Exception("el username no debe estar vacio")

            val response =  usuarioRepository.findById(usuario.id)
                    ?: throw Exception("El id ${usuario.id} en usuario no existe")
            response.apply {
                this.username = usuario.username
            }
            return usuarioRepository.save(usuario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }





    fun delete (id:Long?): Boolean{

        try {
            usuarioRepository.findById(id)
                    ?: throw Exception(" No existe el Id")
            usuarioRepository.deleteById(id!!)
            return true
        }catch (ex: Exception){
            throw Exception()
        }

    }


}






