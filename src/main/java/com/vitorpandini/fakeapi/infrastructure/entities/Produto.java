package com.vitorpandini.fakeapi.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "produto")
@Table(name = "tb_produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Produto {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title",length = 800)
    private String nome;
    @Column(name = "price")
    private BigDecimal preco;
    @Column(name = "description",length = 800)
    private String descricao;
    @Column(name = "image",length = 800)
    private String imagem;
    @Column(name = "category",length = 800)
    private String categoria;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime dataCriacao;
    @Column(name = "updated_at", updatable = true)
    private LocalDateTime dataAtualizacao;
}
