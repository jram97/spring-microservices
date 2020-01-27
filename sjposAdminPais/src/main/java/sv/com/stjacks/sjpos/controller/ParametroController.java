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
import sv.com.stjacks.sjpos.entities.Parametro;
import sv.com.stjacks.sjpos.service.ParametroService;

@RestController
@RequestMapping("parametro")
public class ParametroController {

	Logger logger = LoggerFactory.getLogger(ParametroController.class);

	/**
	 * Instancia del servicio al controlador
	 */
	@Autowired
	private ParametroService parametroService;

	/**
	 * @return Obtener todos los parametros
	 */
	@GetMapping("/")
	public List<Parametro> obtenerTodos() {
		try {
			return parametroService.obtenerTodos();
		} catch (Exception e) {
			logger.info("METODO OBTENER TODOS DE PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * @param id
	 * @return Obtener un pais por su Id
	 */
	@GetMapping("/{id}")
	public Parametro obtenerPorID(@PathVariable int id) {
		try {
			return parametroService.obtenerPorId(id);
		} catch (Exception e) {
			logger.info("METODO OBTENER POR ID DE PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param parametro
	 * @return Objecto creado o actualizado
	 */
	@PostMapping("/")
	public Parametro SaveAndUpdate(@Valid @RequestBody Parametro parametro) {

		try {
			Parametro newParametro = null;
			if (parametro.getIdParametro() == null) {
				newParametro = parametro;
				parametroService.save(newParametro);
				return newParametro;
			} else {
				parametroService.save(parametro);
				return parametro;
			}
		} catch (Exception e) {
			logger.info("METODO GUARDAR O ACTUALIZAR DE PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
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
			Parametro parametro = parametroService.obtenerPorId(id);
			if (parametro != null) {
				parametroService.borrar(parametro);
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
