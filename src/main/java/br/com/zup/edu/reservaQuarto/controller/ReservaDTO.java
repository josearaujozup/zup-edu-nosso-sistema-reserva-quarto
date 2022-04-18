package br.com.zup.edu.reservaQuarto.controller;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.edu.reservaQuarto.model.Quarto;
import br.com.zup.edu.reservaQuarto.model.Reserva;

public class ReservaDTO {
	
	@NotNull
	@Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkin;
	
	@NotNull
	@Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkout;

	public ReservaDTO(@NotNull @Future LocalDate checkin, @NotNull @Future LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public ReservaDTO() {
		
	}

	public Reserva toModel(Quarto quarto) {
		return new Reserva(quarto, checkin, checkout);
	}
	
	
	
}
