package com.exampleTruLaLa.TruLaLa.Repository;

import com.exampleTruLaLa.TruLaLa.Entity.Goods;
import com.exampleTruLaLa.TruLaLa.Entity.Instrumenty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInstrument extends JpaRepository<Instrumenty, Long> {
}
