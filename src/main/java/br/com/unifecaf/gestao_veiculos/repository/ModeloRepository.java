package br.com.unifecaf.gestao_veiculos.repository;

import br.com.unifecaf.gestao_veiculos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}