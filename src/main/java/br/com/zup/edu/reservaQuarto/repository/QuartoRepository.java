package br.com.zup.edu.reservaQuarto.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import br.com.zup.edu.reservaQuarto.model.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Long>{
//	@Lock(LockModeType.PESSIMISTIC_WRITE)
//	Optional<Quarto> findById(Long id);
}
