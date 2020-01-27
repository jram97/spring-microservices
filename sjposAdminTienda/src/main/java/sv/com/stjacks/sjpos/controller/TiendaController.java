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
import sv.com.stjacks.sjpos.entities.Tienda;
import sv.com.stjacks.sjpos.service.TiendaService;

@RestController
@RequestMapping("tienda")
public class TiendaController {

	Logger logger = LoggerFactory.getLogger(TiendaController.class);
	
	/**
	 * Instancia del servicio al controlador
	 */
	@Autowired
	private TiendaService tiendaService;

	/**
	 * @return Obtener todas las tiendas
	 */
	@GetMapping("/")
	public List<Tienda> obtenerTodos(){
		try {
			return tiendaService.obtenerTodos();			
		}catch (Exception e) {
			logger.info("METODO OBTENER TODOS DE TIENDA CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	

	/**
	 * @param id
	 * @return Obtener una tienda por su Id
	 */
	@GetMapping("/{id}")
	public Tienda obtenerPorID(@PathVariable int id){
		try {
			return tiendaService.obtenerPorId(id);			
		}catch (Exception e) {
			logger.info("METODO OBTENER POR ID DE TIENDA CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param tienda
	 * @return Objecto creado o actualizado
	 */
	@PostMapping("/")
	public Tienda SaveAndUpdate(@Valid @RequestBody Tienda tienda) {

		try {
			Tienda newTienda = null;

			if(tienda.getIdTienda() == null) {
				newTienda = tienda;
				tiendaService.save(newTienda);
				return newTienda;
			}else {
				tiendaService.save(tienda);
				return tienda;
			}			
		}catch (Exception e) {
			logger.info("METODO GUARDAR O ACTUALIZAR DE TIENDA CONTROLLER: " + e.getMessage(), Level.WARN);
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
			Tienda tienda = tiendaService.obtenerPorId(id);
			
			if(tienda != null) {
				tiendaService.borrar(tienda);
				return "Eliminado";
			}else {
				return "No eliminado";
			}	
		} catch (Exception e) {
			logger.info("METODO ELIMINAR DE TIENDA CONTROLLER: " + e.getMessage(), Level.WARN);
			e.printStackTrace();
			return null;
		}
	}
	
}
