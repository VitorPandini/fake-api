package com.vitorpandini.fakeapi.infrastructure.client;

import com.vitorpandini.fakeapi.apiv1.dto.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "api-fake",url = "${fake-api.url:#{null}}")
public interface FakeApiClient {

    @GetMapping("/products")
    List<ProductsDTO> buscarListaProdutos();

}
