package br.com.figueiredoisaac.javaLanchesWeb.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private List<Produto> produtos;
	private BigDecimal valorTotal;
	
	public Pedido() {
	}
	
	public Pedido(List<Produto> produtos, BigDecimal valorTotal) {
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal retornaValorTotal() {
		BigDecimal valorTemporario = null;
		this.produtos.forEach(p -> valorTemporario.add(p.getValor()));
		this.valorTotal = valorTemporario;
		return this.valorTotal;
	}

	

	
	
}
