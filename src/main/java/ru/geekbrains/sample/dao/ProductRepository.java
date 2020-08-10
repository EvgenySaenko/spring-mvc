package ru.geekbrains.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findById(UUID uuid);

    //@Query("SELECT name FROM Product p WHERE p.cost=300")
    //@Query(value = "SELECT name FROM product p WHERE p.cost=300",nativeQuery = true)
    List<Product>findAllByIdAndNameAndCost(UUID id, String name, Integer cost);
}
