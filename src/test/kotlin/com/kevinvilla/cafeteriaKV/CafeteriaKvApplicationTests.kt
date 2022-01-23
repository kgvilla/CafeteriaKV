package com.kevinvilla.cafeteriaKV

import com.google.gson.Gson
import com.kevinvilla.cafeteriaKV.model.Cafeteria
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import com.kevinvilla.cafeteriaKV.service.CafeteriaService
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
class CafeteriaKvApplicationTests {

	@InjectMocks
	lateinit var cafeteriaService: CafeteriaService

	@Mock
	lateinit var cafeteriaRepository: CafeteriaRepository


	@Test
	fun entregaIsCorrect() {
		Mockito.`when`(cafeteriaRepository.save(Mockito.any(Cafeteria::class.java))).thenReturn(cafeteriaMock)
		val response = cafeteriaService.save(cafeteriaMock)
		Assertions.assertEquals(response.id, cafeteriaMock.id)
		Assertions.assertEquals(response.entrega, cafeteriaMock.entrega)

	}

	val jsonString = File("./src/test/resources/Entrega/crearEntrega.json").readText(Charsets.UTF_8)
	val cafeteriaMock = Gson().fromJson(jsonString, Cafeteria::class.java)

	@Test
	fun saveEntrega() {
		//PAra actualizar
		//Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
		Mockito.`when`(cafeteriaRepository.save(Mockito.any(Cafeteria::class.java))).thenReturn(cafeteriaMock)
		val response = cafeteriaService.save(cafeteriaMock)
		Assertions.assertEquals(response.id, cafeteriaMock.id)
		Assertions.assertEquals(response.registro, cafeteriaMock.registro)
		Assertions.assertEquals(response.client, cafeteriaMock.client)
		Assertions.assertEquals(response.entrega, cafeteriaMock.entrega)

	}

	@Test
	fun saveEntregaFailedWhenIsBlan() {
		Assertions.assertThrows(Exception::class.java) {
			cafeteriaMock.apply { entrega = "  " }
			Mockito.`when`(cafeteriaRepository.save(Mockito.any(Cafeteria::class.java))).thenReturn(cafeteriaMock)
			cafeteriaService.save(cafeteriaMock)
		}


	}
	@Test
	fun saveEntregaIncorrect() {
		Assertions.assertThrows(Exception::class.java) {
			cafeteriaMock.apply { entrega = "  " }
			Mockito.`when`(cafeteriaRepository.save(Mockito.any(Cafeteria::class.java))).thenReturn(cafeteriaMock)
			cafeteriaService.save(cafeteriaMock)
		}


	}
}



