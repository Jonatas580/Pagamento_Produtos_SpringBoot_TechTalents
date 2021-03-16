package com.projeto.springboot.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projeto.springboot.entity.Categoria;
import com.projeto.springboot.repository.CategoriaRepository;


@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;	
	
	public CategoriaService(CategoriaRepository categoriaRepository) {	
		this.categoriaRepository = categoriaRepository;
	}

	public void cadastra(Categoria categoria) {
		this.categoriaRepository.save(categoria);
	}

	public List<Categoria> buscar(Sort sort) {
		return categoriaRepository.findAll(sort);
		
	}

	public void delete(Long id) {
		if(categoriaRepository.findById(id).isPresent())
			categoriaRepository.deleteById(id);
	}

	public Categoria altera(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
