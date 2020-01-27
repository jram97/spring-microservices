package sv.com.stjacks.sjpos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.stjacks.sjpos.dao.TiendaRepository;
import sv.com.stjacks.sjpos.entities.Tienda;

@Service
public class TiendaService {

	@Autowired
	private TiendaRepository tiendaRepository;

	public List<Tienda> obtenerTodos(){
		return tiendaRepository.findAll();
	}
	
	public void save(Tienda tienda) {
		tiendaRepository.save(tienda);
	}
	
	public Tienda obtenerPorId(int id) {
		Optional<Tienda> tienda = tiendaRepository.findById(id);
		return tienda.get();
	}
	
	public void borrar(Tienda tienda) {
		tiendaRepository.delete(tienda);
	}
	
}
