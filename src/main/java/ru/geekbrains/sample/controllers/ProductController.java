package ru.geekbrains.sample.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.sample.dao.ProductService;
import ru.geekbrains.sample.dto.ProductDTO;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void saveOne(ProductDTO productDTO) {
        productService.save(productDTO);
    }

}