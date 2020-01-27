package sv.com.stjacks.sjpos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.stjacks.sjpos.dao.ParametroRepository;
import sv.com.stjacks.sjpos.entities.Parametro;

@Service
public class ParametroService {

	@Autowired
	private ParametroRepository parametroRepository;
	
	public List<Parametro> obtenerTodos(){
		return parametroRepository.findAll();
	}
	
	public void save(Parametro parametro) {
		parametroRepository.save(parametro);
	}
	
	public Parametro obtenerPorId(int id) {
		Optional<Parametro> parametro = parametroRepository.findById(id);
		return parametro.get();
	}
	
	public void borrar(Parametro parametro) {
		parametroRepository.delete(parametro);
	}
	
}
