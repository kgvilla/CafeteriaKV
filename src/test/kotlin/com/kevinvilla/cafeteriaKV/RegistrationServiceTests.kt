package com.kevinvilla.cafeteriaKV

import com.google.gson.Gson
import com.kevinvilla.cafeteriaKV.model.Cafeteria
import com.kevinvilla.cafeteriaKV.model.Registration
import com.kevinvilla.cafeteriaKV.repository.CafeteriaRepository
import com.kevinvilla.cafeteriaKV.repository.RegistrationRepository
import com.kevinvilla.cafeteriaKV.service.CafeteriaService
import com.kevinvilla.cafeteriaKV.service.RegistrationService
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
class RegistrationServiceTests {

	@InjectMocks
	lateinit var registrationService: RegistrationService

	@Mock
	lateinit var registrationRepository: RegistrationRepository

	@Test
	fun registrationIsCorrect() {
		Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
		val response = registrationService.save(registrationMock)
		Assertions.assertEquals(response.id, registrationMock.id)
		Assertions.assertEquals(response.lugar, registrationMock.lugar)
		Assertions.assertEquals(response.fecha, registrationMock.fecha)
		Assertions.assertEquals(response.hora, registrationMock.hora)
		Assertions.assertEquals(response.clienteid, registrationMock.clienteid)
		Assertions.assertEquals(response.cafeteria_id, registrationMock.cafeteria_id,)

	}

	val jsonString = File("./src/test/resources/Registration/newRegistration.json").readText(Charsets.UTF_8)
	val registrationMock = Gson().fromJson(jsonString, Registration::class.java)

	@Test
	fun saveRegistration() {

		Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
		val response = registrationService.save(registrationMock)
		Assertions.assertEquals(response.id, registrationMock.id)
		Assertions.assertEquals(response.lugar, registrationMock.lugar)
		Assertions.assertEquals(response.fecha, registrationMock.fecha)
		Assertions.assertEquals(response.hora, registrationMock.hora)
		Assertions.assertEquals(response.clienteid, registrationMock.clienteid)
		Assertions.assertEquals(response.cafeteria_id, registrationMock.cafeteria_id,)

	}

	@Test
	fun saveRegistrationFailedWhite() {
		Assertions.assertThrows(Exception::class.java) {
			registrationMock.apply {
				lugar = "  "
				fecha= " "
			}
			Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
			registrationService.save(registrationMock)
		}


	}
	@Test
	fun saveRegistrationIncorrect() {
		Assertions.assertThrows(Exception::class.java) {
			registrationMock.apply {
				lugar = "  "
				fecha= " "
			}
			Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
			registrationService.save(registrationMock)
		}
	}

	@Test
	fun UpdateIsCorrect() {
			Mockito.`when`(registrationRepository.findById(registrationMock.id)).thenReturn(registrationMock)
			Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
			registrationService.updateDescription(registrationMock)
			val response = registrationService.save(registrationMock)
			Assertions.assertEquals(response.id, registrationMock.id)
			Assertions.assertEquals(response.lugar, registrationMock.lugar)
			Assertions.assertEquals(response.fecha, registrationMock.fecha)
			Assertions.assertEquals(response.hora, registrationMock.hora)
			Assertions.assertEquals(response.clienteid, registrationMock.clienteid)
			Assertions.assertEquals(response.cafeteria_id, registrationMock.cafeteria_id,)
	}

	@Test
	fun UpdateIsFailed() {
		Assertions.assertThrows(Exception::class.java) {
			Mockito.`when`(registrationRepository.findById(registrationMock.id)).thenReturn(null)
			Mockito.`when`(registrationRepository.save(Mockito.any(Registration::class.java))).thenReturn(registrationMock)
			registrationService.updateDescription(registrationMock)


		}
	}
}



