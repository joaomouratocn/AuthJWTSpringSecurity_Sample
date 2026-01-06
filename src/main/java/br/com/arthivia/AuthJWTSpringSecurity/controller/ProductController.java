package br.com.arthivia.AuthJWTSpringSecurity.controller;

import br.com.arthivia.AuthJWTSpringSecurity.model.entity.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public ResponseEntity<List<ProductEntity>> getProducts() {
        List<ProductEntity> productEntities = List.of(
                new ProductEntity("Product 1", new BigDecimal(10), "Description 1"),
                new ProductEntity("Product 2", new BigDecimal(20), "Description 2"),
                new ProductEntity("Product 3", new BigDecimal(30), "Description 3"),
                new ProductEntity("Product 4", new BigDecimal(40), "Description 4")
        );

        return ResponseEntity.ok(productEntities);
    }
}
