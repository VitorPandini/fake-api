package com.vitorpandini.fakeapi.business;

import com.vitorpandini.fakeapi.apiv1.dto.ProductsDTO;
import com.vitorpandini.fakeapi.business.converter.ProdutoConverter;
import com.vitorpandini.fakeapi.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;

    private final ProdutoConverter converter;

    private final ProdutoService service;

    public List<ProductsDTO> buscarListaProdutos() {

        try{
            var listProducts= cliente.buscarListaProdutos();
            listProducts.forEach(produto -> {
                var existeProduto =service.existeProdutoPorNome(produto.getNome());
                if(existeProduto.equals(false)){
                    service.salvarProdutos(converter.toEntity(produto));
                }

            });

            return converter.toListDto(service.buscarTodosProdutos());
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }



    }
}
