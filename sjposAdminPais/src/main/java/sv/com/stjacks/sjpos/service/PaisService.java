package sv.com.stjacks.sjpos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.stjacks.sjpos.dao.PaisRepository;
import sv.com.stjacks.sjpos.entities.Pais;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	public List<Pais> obtenerTodos(){
		return paisRepository.findAll();
	}
	
	public void save(Pais pais) {
		paisRepository.save(pais);
	}
	
	public Pais obtenerPorId(int id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.get();
	}
	
	public void borrar(Pais pais) {
		paisRepository.delete(pais);
	}
	
}
