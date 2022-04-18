package br.com.zup.edu.reservaQuarto.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.reservaQuarto.model.Quarto;
import br.com.zup.edu.reservaQuarto.model.Reserva;
import br.com.zup.edu.reservaQuarto.repository.QuartoRepository;
import br.com.zup.edu.reservaQuarto.repository.ReservaRepository;

@RestController
public class ReservarQuartoController {
	
	private final QuartoRepository quartoRepository;
	private final ReservaRepository repository;
	
	public ReservarQuartoController(QuartoRepository quartoRepository, ReservaRepository repository) {
		this.quartoRepository = quartoRepository;
		this.repository = repository;
	}
	
	@PostMapping("quartos/{id}/reservas")
	@Transactional
    public ResponseEntity<?> cadastrar(@PathVariable("id") Long idQuarto, @RequestBody @Valid ReservaDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Quarto quarto = quartoRepository.findById(idQuarto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Quarto não encontrado"));
		
		if(quarto.isReservado()) {
    		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"quarto já reservado");
    	}
		
		quarto.setReservado(true);
		
		Reserva reserva = request.toModel(quarto);
		repository.save(reserva);
		
		URI location = uriComponentsBuilder.path("quartos/{id}/reservas/{idReserva}").buildAndExpand(quarto.getId(),reserva.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	
}
