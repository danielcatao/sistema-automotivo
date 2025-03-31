package br.com.unifecaf.gestao_veiculos.service;

import br.com.unifecaf.gestao_veiculos.model.Marca;
import br.com.unifecaf.gestao_veiculos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca findById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }
}