package br.com.unifecaf.gestao_veiculos.controller;

import br.com.unifecaf.gestao_veiculos.model.Veiculo;
import br.com.unifecaf.gestao_veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class ApiController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculoById(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado");
        }
        return veiculo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo createVeiculo(@RequestBody Veiculo body) {
        System.out.println("Recebido: " + body.getMarca() + ", " + body.getModelo() + ", " + body.getCor() + ", " + body.getQuilometragem());
        return veiculoService.save(body);
    }

    @PutMapping("/{id}")
    public Veiculo updateVeiculo(@PathVariable Long id, @RequestBody Veiculo updatedVeiculo) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado");
        }
        veiculo.setMarca(updatedVeiculo.getMarca());
        veiculo.setModelo(updatedVeiculo.getModelo());
        veiculo.setCor(updatedVeiculo.getCor());
        veiculo.setQuilometragem(updatedVeiculo.getQuilometragem());
        return veiculoService.save(veiculo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVeiculo(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado");
        }
        veiculoService.delete(id);
    }
}
