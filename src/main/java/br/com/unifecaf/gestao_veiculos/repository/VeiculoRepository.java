package br.com.unifecaf.gestao_veiculos.repository;

import br.com.unifecaf.gestao_veiculos.model.Marca;
import br.com.unifecaf.gestao_veiculos.model.Modelo;
import br.com.unifecaf.gestao_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v " +
            "WHERE (:marca IS NULL OR v.marca = :marca) " +
            "AND (:modelo IS NULL OR v.modelo = :modelo) " +
            "AND (:precoMin IS NULL OR v.preco >= :precoMin) " +
            "AND (:precoMax IS NULL OR v.preco <= :precoMax) " +
            "AND (:anoMin IS NULL OR v.ano_fabricacao >= :anoMin) " +
            "AND (:anoMax IS NULL OR v.ano_fabricacao <= :anoMax) " +
            "AND (:status IS NULL OR v.status = :status)")
    List<Veiculo> findByFilters(
            @Param("marca") Marca marca,
            @Param("modelo") Modelo modelo,
            @Param("precoMin") BigDecimal precoMin,
            @Param("precoMax") BigDecimal precoMax,
            @Param("anoMin") Integer anoMin,
            @Param("anoMax") Integer anoMax,
            @Param("status") String status);
}