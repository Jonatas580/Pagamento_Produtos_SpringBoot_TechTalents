package com.projeto.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.springboot.entity.Produto;
import com.projeto.springboot.service.ProdutoService;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController {

		private ProdutoService produtoService;

		public ProdutoController(ProdutoService produtoService) {
			this.produtoService = produtoService;
		}
		@PostMapping ("/cadastro")
		public ResponseEntity<Produto>cadastro(@RequestBody Produto produto){
			produtoService.cadastra(produto);
			return ResponseEntity.ok().body(null);
		}
		@GetMapping ("/buscar")
		public ResponseEntity<List<Produto>> buscar(Sort sort){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoService.buscar(sort));
		}
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable Long id) {
			produtoService.delete(id);
		}
		@PutMapping("/altera")
		public ResponseEntity<Produto> alterar(@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.OK).body(produtoService.altera(produto));
		}
}