package br.com.zup.edu.reservaQuarto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quarto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String decricao;
	
	@Column(nullable = false)
    private BigDecimal valorDiaria;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQuarto tipo;
	
	@Column(nullable = false)
	private Boolean reservado;
	
	/**
     * @deprecated
     */
    @Deprecated
    public Quarto() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public boolean isReservado() {
		return this.reservado == true;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
	
}
