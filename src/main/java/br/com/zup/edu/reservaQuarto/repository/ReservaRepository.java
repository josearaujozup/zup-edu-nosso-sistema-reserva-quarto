package br.com.zup.edu.reservaQuarto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.reservaQuarto.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
}
