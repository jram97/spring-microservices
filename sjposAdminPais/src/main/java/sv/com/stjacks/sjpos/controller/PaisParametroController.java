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
import sv.com.stjacks.sjpos.entities.PaisParametro;
import sv.com.stjacks.sjpos.service.PaisParametroService;

@RestController
@RequestMapping("pais-parametro")
public class PaisParametroController {

	Logger logger = LoggerFactory.getLogger(PaisParametroController.class);

	/**
	 * Instancia del servicio Pais Parametro
	 */
	@Autowired
	private PaisParametroService paisParametroService;

	/**
	 * @return Obtener todos los Parametros de sus Paises (1:N)
	 */
	@GetMapping("/")
	public List<PaisParametro> obtenerTodos() {

		try {
			return paisParametroService.obtenerTodos();
		} catch (Exception e) {
			logger.info("METODO OBTENER TODOS DE PAIS PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * @param id
	 * @return Obtener la informacion de los Parametros de un Pais
	 */
	@GetMapping("/{id}")
	public PaisParametro obtenerPorID(@PathVariable int id) {
		try {
			return paisParametroService.obtenerPorId(id);
		} catch (Exception e) {
			logger.info("METODO OBTENER POR ID DE PAIS PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param paisParametro
	 * @return Objecto creado o actualizado
	 */
	@PostMapping("/")
	public PaisParametro SaveAndUpdate(@Valid @RequestBody PaisParametro paisParametro) {

		try {
			PaisParametro newPaisParametro = null;

			if (paisParametro.getIdPaisParametro() == null) {
				newPaisParametro = paisParametro;
				paisParametroService.save(newPaisParametro);
				return newPaisParametro;
			} else {
				paisParametroService.save(paisParametro);
				return paisParametro;
			}
		} catch (Exception e) {
			logger.info("METODO GUARDAR O ACTUALIZAR DE PAIS PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
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
			PaisParametro paisParametro = paisParametroService.obtenerPorId(id);

			if (paisParametro != null) {
				paisParametroService.borrar(paisParametro);
				return "Eliminado";
			} else {
				return "No eliminado";
			}
		} catch (Exception e) {
			logger.info("METODO ELIMINAR DE PAIS PARAMETRO CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

}