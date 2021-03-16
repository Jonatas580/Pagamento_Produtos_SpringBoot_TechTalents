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

import com.projeto.springboot.entity.Categoria;
import com.projeto.springboot.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

		private CategoriaService categoriaService;

		public CategoriaController(CategoriaService categoriaService) {
			this.categoriaService = categoriaService;
		}
		@PostMapping ("/cadastro")
		public ResponseEntity<Categoria>cadastro(@RequestBody Categoria categoria){
			categoriaService.cadastra(categoria);
			return ResponseEntity.ok().body(null);
		}
		@GetMapping ("/buscar")
		public ResponseEntity<List<Categoria>> buscar(Sort sort){
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriaService.buscar(sort));
		}
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable Long id) {
			categoriaService.delete(id);
		}
		@PutMapping("/altera")
		public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.altera(categoria));
		}
}