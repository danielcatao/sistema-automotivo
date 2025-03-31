package br.com.unifecaf.gestao_veiculos.service;

import br.com.unifecaf.gestao_veiculos.model.Marca;
import br.com.unifecaf.gestao_veiculos.model.Modelo;
import br.com.unifecaf.gestao_veiculos.model.Veiculo;
import br.com.unifecaf.gestao_veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> findByFilters(Long marcaId, Long modeloId, BigDecimal precoMin, BigDecimal precoMax,
                                       Integer anoMin, Integer anoMax, String status) {
        Marca marca = marcaId != null ? new Marca(marcaId, null) : null;
        Modelo modelo = modeloId != null ? new Modelo(modeloId, null, null) : null;
        return veiculoRepository.findByFilters(marca, modelo, precoMin, precoMax, anoMin, anoMax, status);
    }
}