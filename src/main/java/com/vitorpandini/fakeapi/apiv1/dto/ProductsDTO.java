package com.vitorpandini.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "entity_id")
    private String entityId;
    @JsonProperty(value = "title")
    private String titulo;
    @JsonProperty(value = "name")
    private String nome;
    @JsonProperty(value = "price")
    private BigDecimal preco;
    @JsonProperty(value = "cateogry")
    private String categoria;
    @JsonProperty(value = "description")
    private String descricao;
    @JsonProperty(value = "image")
    private String imagem;

}
