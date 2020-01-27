package sv.com.stjacks.sjpos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.com.stjacks.sjpos.entities.PaisParametro;

@Repository
public interface PaisParametroRepository extends JpaRepository<PaisParametro, Integer> {

}
