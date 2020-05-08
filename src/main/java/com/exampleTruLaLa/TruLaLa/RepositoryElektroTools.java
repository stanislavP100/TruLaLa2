package com.exampleTruLaLa.TruLaLa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryElektroTools extends JpaRepository<ElectroTools, Long> {

    public Optional<ElectroTools> findById(Long id);

}
