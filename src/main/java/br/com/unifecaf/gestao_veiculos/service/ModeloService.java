package br.com.unifecaf.gestao_veiculos.service;

import br.com.unifecaf.gestao_veiculos.model.Modelo;
import br.com.unifecaf.gestao_veiculos.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    public Modelo findById(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo save(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void delete(Long id) {
        modeloRepository.deleteById(id);
    }
}