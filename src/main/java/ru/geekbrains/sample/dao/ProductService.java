package ru.geekbrains.sample.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dto.ProductDTO;
import ru.geekbrains.sample.persistence.entity.Product;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //@Transactional уже зашита сюда ненадо указывать
    public void save(ProductDTO productDTO) {
        productRepository.save(
                Product.builder()
                        .name(productDTO.getName())
                        .cost(productDTO.getCost())
                        .build()
        );
    }
//    public Product getProduct(UUID id){
//        Optional<Product>productOptional = productRepository.findById(id);
        //если даже поймаем НПЕ метод просто выполнится и программа продолжит работать
//        if (productOptional.isPresent()){
//            Product product = productOptional.get();
//            System.out.println(product);
//        }
//    }


}