package sv.com.stjacks.sjpos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.com.stjacks.sjpos.entities.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
}
