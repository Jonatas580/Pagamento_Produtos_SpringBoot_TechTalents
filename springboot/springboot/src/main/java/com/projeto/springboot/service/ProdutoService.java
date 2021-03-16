package com.projeto.springboot.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projeto.springboot.entity.Produto;
import com.projeto.springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
	

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	public void cadastra(Produto produto) {
		produtoRepository.save(produto);
	}
	public List<Produto> buscar(Sort sort) {
		return produtoRepository.findAll(sort);
	}
	public void delete(Long id) {
		if(produtoRepository.findById(id).isPresent()) 
			produtoRepository.deleteById(id);
	}
	public Produto altera(Produto produto) {
		return produtoRepository.save(produto);
	}
}