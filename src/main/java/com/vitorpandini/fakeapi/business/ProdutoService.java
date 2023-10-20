package com.vitorpandini.fakeapi.business;

import com.vitorpandini.fakeapi.apiv1.dto.ProductsDTO;
import com.vitorpandini.fakeapi.business.converter.ProdutoConverter;
import com.vitorpandini.fakeapi.infrastructure.entities.Produto;
import com.vitorpandini.fakeapi.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    private  final ProdutoConverter converter;

    public Produto salvarProdutos(Produto entity){
        try{
            return repository.save(entity);
        }catch (Exception ex){
            throw new RuntimeException("Erro ao salvar produto," + entity.getNome());
        }
    }

    public List<Produto> buscarTodosProdutos(){
        try{
            return repository.findAll();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao buscar todos os produtos, " + ex.getMessage());
        }
    }

    public Boolean existeProdutoPorNome(String nome){
        try{
            return repository.existsByNome(nome);
        }catch (Exception ex){
            throw new RuntimeException(String.format("Erro ao buscar produto por nome %s", nome));
        }
    }

    public Produto buscarProdutoPorNome(String nome){
        try{
            return repository.findByNome(nome);
        }catch (Exception ex){
            throw new RuntimeException(String.format("Erro ao buscar produto por nome %s", nome));
        }
    }

    public void deletarProdutoPorId(String id){
        try{
            repository.deleteById(id);
        }catch (Exception ex){
            throw new RuntimeException(String.format("Erro ao deletar produto por id %s", id));
        }
    }

    public ProductsDTO updatedProduto(ProductsDTO dto,String id){

       try{
           var produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Nao achei fdp"));
           salvarProdutos(converter.toEntityUpdated(produto,dto,id));

           return converter.toDto(repository.findByNome(produto.getNome()));

       }catch (Exception ex){
           throw new RuntimeException(String.format("Erro ao atualizar o produto de id: %s", id));
       }



    }
}
