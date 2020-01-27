package sv.com.stjacks.sjpos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.stjacks.sjpos.dao.PaisParametroRepository;
import sv.com.stjacks.sjpos.entities.PaisParametro;

@Service
public class PaisParametroService {

	@Autowired
	private PaisParametroRepository paisParametroRepository;
	
	public List<PaisParametro> obtenerTodos(){
		return paisParametroRepository.findAll();
	}
	
	public void save(PaisParametro paisParametro) {
		paisParametroRepository.save(paisParametro);
	}
	
	public PaisParametro obtenerPorId(int id) {
		Optional<PaisParametro> pais = paisParametroRepository.findById(id);
		return pais.get();
	}
	
	public void borrar(PaisParametro paisParametro) {
		paisParametroRepository.delete(paisParametro);
	}
	
}