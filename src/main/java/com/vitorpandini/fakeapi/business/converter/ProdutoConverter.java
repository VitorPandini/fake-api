package com.vitorpandini.fakeapi.business.converter;

import com.vitorpandini.fakeapi.apiv1.dto.ProductsDTO;
import com.vitorpandini.fakeapi.infrastructure.entities.Produto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProdutoConverter {

    public Produto toEntity(ProductsDTO dto) {
        return Produto.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .imagem(dto.getImagem())
                .dataCriacao(LocalDateTime.now())
                .build();
    }

    public Produto toEntityUpdated(Produto entity,ProductsDTO dto,String id) {
        return Produto.builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .categoria(dto.getCategoria() != null ? dto.getCategoria() : entity.getCategoria())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao())
                .preco(dto.getPreco() != null ? dto.getPreco() : entity.getPreco())
                .imagem(dto.getImagem() != null ? dto.getImagem() : entity.getImagem())
                .dataCriacao(entity.getDataCriacao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public ProductsDTO toDto(Produto entity) {
        return ProductsDTO.builder()
                .entityId(entity.getId())
                .nome(entity.getNome())
                .categoria(entity.getCategoria())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .imagem(entity.getImagem())
                .build();
    }

    public List<ProductsDTO> toListDto(List<Produto> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
