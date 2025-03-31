package br.com.unifecaf.gestao_veiculos.repository;

import br.com.unifecaf.gestao_veiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}