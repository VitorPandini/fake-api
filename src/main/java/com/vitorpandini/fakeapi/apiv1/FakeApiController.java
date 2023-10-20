package com.vitorpandini.fakeapi.apiv1;

import com.vitorpandini.fakeapi.apiv1.dto.ProductsDTO;
import com.vitorpandini.fakeapi.business.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService service;

    @Operation(summary = "Busca todos os produtos",method = "POST")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista de produtos"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),

            }
    )
    @PostMapping("/api")
    public ResponseEntity<List<ProductsDTO>> salvarProdutosApi() {
        return ResponseEntity.ok(service.buscarListaProdutos());
    }


}
