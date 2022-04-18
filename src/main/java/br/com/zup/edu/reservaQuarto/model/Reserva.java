package br.com.zup.edu.reservaQuarto.model;

import static java.time.LocalDateTime.now;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Quarto quarto;
	
	@Column(nullable = false)
    private LocalDateTime criadoEm = now();
	
	@Column(nullable = false)
    private LocalDate checkin;
	
	@Column(nullable = false)
    private LocalDate checkout;

	public Reserva(Quarto quarto, LocalDate checkin, LocalDate checkout) {
		this.quarto = quarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	/**
     * @deprecated
     */
    @Deprecated
	public Reserva() {
		
	}

	public Long getId() {
		return id;
	}
	
}
