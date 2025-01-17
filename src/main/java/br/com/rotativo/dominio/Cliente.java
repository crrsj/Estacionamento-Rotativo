package br.com.rotativo.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotativo.dto.AtualizarDto;
import br.com.rotativo.dto.CadastrarClienteDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clientes")
@Data
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Date data;
	private String nome;
	private String telefone;
	private String marca;
	private String modelo;
	private Integer anoModelo;	
	@Column(unique = true)
	@Size(min = 7,max = 7)
	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private BigDecimal valor;
	private Boolean clienteAtivo;
	
	
	

	public Cliente(CadastrarClienteDto cadastrarClienteDto) {		
		this.nome = cadastrarClienteDto.getNome();
		this.telefone = cadastrarClienteDto.getTelefone();
		this.marca = cadastrarClienteDto.getMarca();
		this.modelo = cadastrarClienteDto.getModelo();
		this.anoModelo = cadastrarClienteDto.getAnoModelo();
		this.placa = cadastrarClienteDto.getPlaca();
		this.horaEntrada = cadastrarClienteDto.getHoraEntrada();
		this.horaSaida = cadastrarClienteDto.getHoraSaida();
		this.valor = cadastrarClienteDto.getValor();
		this.clienteAtivo = true;
	}


	public void desativar() {		
	this.clienteAtivo = false;
		
	}


	public void ativar() {
		this.clienteAtivo = true;
		
	}


	public Cliente(AtualizarDto atualizarDto) {
		this.id = atualizarDto.getId();
		this.nome = atualizarDto.getNome();
		this.telefone = atualizarDto.getTelefone();
		this.marca = atualizarDto.getMarca();
		this.modelo = atualizarDto.getModelo();
		this.anoModelo = atualizarDto.getAnoModelo();
		this.placa  =atualizarDto.getPlaca();
		this.horaEntrada = atualizarDto.getHoraEntrada();
		this.horaSaida = atualizarDto.getHoraSaida();
		this.valor = atualizarDto.getValor();
	}


	
	

}
