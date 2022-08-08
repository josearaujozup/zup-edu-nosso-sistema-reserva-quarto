package br.com.zup.edu.reservaQuarto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

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

	@Version
	private int versao;

	@OneToMany(mappedBy = "quarto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Reserva> reservas = new ArrayList<>();

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

	public void adicionar(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public boolean isReservado() {
		return this.reservado == true;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

}
