package com.kevinvilla.cafeteriaKV

import com.google.gson.Gson
import com.kevinvilla.cafeteriaKV.model.Cafeteria
import com.kevinvilla.cafeteriaKV.model.Cliente
import com.kevinvilla.cafeteriaKV.model.Registration
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import com.kevinvilla.cafeteriaKV.repository.ClienteRepository
import com.kevinvilla.cafeteriaKV.service.CafeteriaService
import com.kevinvilla.cafeteriaKV.service.ClienteService
import com.kevinvilla.cafeteriaKV.service.UsuarioService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ClienteServiceTests {

	@InjectMocks
	lateinit var clienteService: ClienteService

	@Mock
	lateinit var clienteRepository: ClienteRepository


	@Test
	fun clienteIsCorrect() {
		Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
		val response = clienteService.save(clienteMock)
		Assertions.assertEquals(response.id, clienteMock.id)
		Assertions.assertEquals(response.name, clienteMock.name)
		Assertions.assertEquals(response.apellido, clienteMock.apellido)
		Assertions.assertEquals(response.cedula, clienteMock.cedula)

	}

	val jsonString = File("./src/test/resources/Cliente/newCliente.json").readText(Charsets.UTF_8)
	val clienteMock = Gson().fromJson(jsonString, Cliente::class.java)

	@Test
	fun saveCliente() {
		//PAra actualizar
		//Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
		Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
		val response = clienteService.save(clienteMock)
		Assertions.assertEquals(response.id, clienteMock.id)
		Assertions.assertEquals(response.name, clienteMock.name)
		Assertions.assertEquals(response.apellido, clienteMock.apellido)
		Assertions.assertEquals(response.cedula, clienteMock.cedula)

	}

	@Test
	fun saveCedulafailedWhite() {
		Assertions.assertThrows(Exception::class.java) {
			clienteMock.apply {
				cedula = "  "
				apellido= ""
			}
			Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
			clienteService.save(clienteMock)
		}


	}
	@Test
	fun saveCedulaIncorrect() {
		Assertions.assertThrows(Exception::class.java) {
			clienteMock.apply { cedula = "  " }
			Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
			clienteService.save(clienteMock)
		}
	}

	@Test
	fun UpdateIsEntrega() {
		Mockito.`when`(clienteRepository.findById(clienteMock.id)).thenReturn(clienteMock)
		Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
		clienteService.update(clienteMock)
		val response = clienteService.save(clienteMock)
		Assertions.assertEquals(response.id, clienteMock.id)
		Assertions.assertEquals(response.apellido, clienteMock.apellido)
		Assertions.assertEquals(response.cedula, clienteMock.cedula)



	}

	@Test
	fun UpdateIsFailedEntrega() {
		Assertions.assertThrows(Exception::class.java) {
			Mockito.`when`(clienteRepository.findById(clienteMock.id)).thenReturn(null)
			Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
			clienteService.updateDescription(clienteMock)

		}
	}

	@Test
	fun deleteIdCliente() {
		Mockito.`when`(clienteRepository.findById(clienteMock.id)).thenReturn(clienteMock)
		Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
		val response = clienteService.delete(clienteMock.id)
		Assertions.assertEquals(response, true)
	}

	@Test
	fun deleteIsFailed() {

		Assertions.assertThrows(Exception::class.java){
			Mockito.`when`(clienteRepository.findById(clienteMock.id)).thenReturn(null)
			Mockito.`when`(clienteRepository.save(Mockito.any(Cliente::class.java))).thenReturn(clienteMock)
			val response = clienteService.delete(clienteMock.id)
			Assertions.assertEquals(response, true)

		}
	}







}



