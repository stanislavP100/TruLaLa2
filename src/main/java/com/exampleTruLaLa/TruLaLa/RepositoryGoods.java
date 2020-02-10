package com.exampleTruLaLa.TruLaLa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryGoods extends JpaRepository<Goods, Long> {

    public Optional<Goods> findById(Long id);
}
