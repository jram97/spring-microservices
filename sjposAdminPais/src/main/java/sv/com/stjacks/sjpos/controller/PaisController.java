package sv.com.stjacks.sjpos.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Level;
import sv.com.stjacks.sjpos.entities.Pais;
import sv.com.stjacks.sjpos.service.PaisService;

@RestController
@RequestMapping("pais")
public class PaisController {

	Logger logger = LoggerFactory.getLogger(PaisController.class);

	/**
	 * Instancia del servicio al controlador
	 */
	@Autowired
	private PaisService paisService;

	/**
	 * @return Obtener todos los paises
	 */
	@GetMapping("/")
	public List<Pais> obtenerTodos() {
		try {
			return paisService.obtenerTodos();
		} catch (Exception e) {
			logger.info("METODO OBTENER TODOS DE PAIS CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * @param id
	 * @return Obtener un pais por su Id
	 */
	@GetMapping("/{id}")
	public Pais obtenerPorID(@PathVariable int id) {
		try {
			return paisService.obtenerPorId(id);
		} catch (Exception e) {
			logger.info("METODO OBTENER POR ID DE PAIS CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param pais
	 * @return Objecto creado o actualizado
	 */
	@PostMapping("/")
	public Pais SaveAndUpdate(@Valid @RequestBody Pais pais) {

		try {
			Pais newPais = null;

			if (pais.getIdPais() == null) {
				newPais = pais;
				paisService.save(newPais);
				return newPais;
			} else {
				paisService.save(pais);
				return pais;
			}
		} catch (Exception e) {
			logger.info("METODO GUARDAR O ACTUALIZAR DE PAIS CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param id
	 * @return "Eliminado si true, No Eliminado si false"
	 */
	@DeleteMapping("/{id}")
	public String eliminar(@PathVariable int id) {

		try {
			Pais pais = paisService.obtenerPorId(id);

			if (pais != null) {
				paisService.borrar(pais);
				return "Eliminado";
			} else {
				return "No eliminado";
			}

		} catch (Exception e) {
			logger.info("METODO ELIMINAR DE PAIS CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

}
