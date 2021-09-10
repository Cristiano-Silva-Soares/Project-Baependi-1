package com.baependi.projetoIntegrador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baependi.projetoIntegrador.models.Categoria;
import com.baependi.projetoIntegrador.repository.RepositorioCategoria;

@RestController
@RequestMapping("/baependi/categoria")
public class ControllerCategoria {

	private @Autowired RepositorioCategoria repositorio;

	@GetMapping("/buscarTodas")
	private ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@GetMapping("/Buscarcategoriaid/{idCategoria}")
	private ResponseEntity<Categoria> findById(@PathVariable(value = "idCategoria") Long idCategoria) {
		Optional<Categoria> objetoCategoria = repositorio.findById(idCategoria);

		if (objetoCategoria.isPresent()) {
			return ResponseEntity.status(200).body(objetoCategoria.get());
		} else {
			return ResponseEntity.status(204).build();
		}

	}

	@GetMapping("/acharPorTipoProduto/{tipoProdutos}")
	private ResponseEntity<List<Categoria>> findAllByTipoProdutoContainingIgnoreCase(@PathVariable(value = "tipoProdutos") String tipoProduto) {
		List<Categoria> objetoCategoria = repositorio.buscarTipoProduto(tipoProduto);
		if(objetoCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		}else {
			return ResponseEntity.status(201).body(objetoCategoria);
		}
	}

	@PostMapping("/salvar")
	private ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoriaSalva) {
		return ResponseEntity.status(201).body(repositorio.save(categoriaSalva));
	}

	@PutMapping("/atualizar")
	private ResponseEntity<Categoria> atualizarCategoria(@Valid @RequestBody Categoria categoriaAtualizada) {
		return ResponseEntity.status(201).body(repositorio.save(categoriaAtualizada));
	}

	@DeleteMapping("/deletar/{idCategoria")
	private void deletarCategoria(@PathVariable(value = "idCategoria") Long idCategoria) {
		repositorio.deleteById(idCategoria);
	}

}
