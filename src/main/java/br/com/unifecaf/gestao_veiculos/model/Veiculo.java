package br.com.unifecaf.gestao_veiculos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Modelo modelo;

    private Integer ano_fabricacao;
    private String cor;
    private BigDecimal preco;
    private Integer quilometragem;
    private String status;          // Ex.: "DISPONIVEL", "VENDIDO"
}