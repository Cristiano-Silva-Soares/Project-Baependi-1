package com.baependi.projetoIntegrador.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;


@Entity
@Table(name = "tb_produtos")

public class Produtos {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
	private @NotBlank @Size(min = 3, max = 255) String nomeDoProduto;
	private @NotNull float precoDoProduto;
	private @NotBlank String descricaoDoProduto;
	private @NotBlank String autoreDoProduto;
	private @NotBlank @Size(min = 1, max = 75) String tipoDeProduto;
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeDoProduto() {
		return nomeDoProduto;
	}
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}
	public float getPrecoDoProduto() {
		return precoDoProduto;
	}
	public void setPrecoDoProduto(float precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}
	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}
	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}
	public String getAutoreDoProduto() {
		return autoreDoProduto;
	}
	public void setAutoreDoProduto(String autoreDoProduto) {
		this.autoreDoProduto = autoreDoProduto;
	}
	public String getTipoDeProduto() {
		return tipoDeProduto;
	}
	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}

	/*@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "produtos_id_produto")
	private List<Categoria> categorias = new ArrayList<>();*/



}
