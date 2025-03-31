package br.com.unifecaf.gestao_veiculos.controller;

import br.com.unifecaf.gestao_veiculos.model.Veiculo;
import br.com.unifecaf.gestao_veiculos.service.VeiculoService;
import br.com.unifecaf.gestao_veiculos.service.MarcaService;
import br.com.unifecaf.gestao_veiculos.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("veiculos", veiculoService.findAll());
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("modelos", modeloService.findAll());
        return "index";
    }

    @PostMapping("/")
    public String saveVeiculo(@ModelAttribute Veiculo veiculo) {
        veiculoService.save(veiculo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editVeiculo(@PathVariable Long id, Model model) {
        Veiculo veiculo = veiculoService.findById(id);
        if (veiculo == null) {
            return "redirect:/";
        }
        model.addAttribute("veiculos", veiculoService.findAll());
        model.addAttribute("veiculo", veiculo);
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("modelos", modeloService.findAll());
        return "index";
    }

    @PostMapping("/delete/{id}")
    public String deleteVeiculo(@PathVariable Long id) {
        veiculoService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String filterVeiculos(
            @RequestParam(required = false) String marcaId,
            @RequestParam(required = false) String modeloId,
            @RequestParam(required = false) String precoMin,
            @RequestParam(required = false) String precoMax,
            @RequestParam(required = false) String anoMin,
            @RequestParam(required = false) String anoMax,
            @RequestParam(required = false) String status,
            Model model) {
        // Conversão de strings vazias para null
        Long marcaIdParsed = (marcaId == null || marcaId.isEmpty()) ? null : Long.parseLong(marcaId);
        Long modeloIdParsed = (modeloId == null || modeloId.isEmpty()) ? null : Long.parseLong(modeloId);
        BigDecimal precoMinParsed = (precoMin == null || precoMin.isEmpty()) ? null : new BigDecimal(precoMin);
        BigDecimal precoMaxParsed = (precoMax == null || precoMax.isEmpty()) ? null : new BigDecimal(precoMax);
        Integer anoMinParsed = (anoMin == null || anoMin.isEmpty()) ? null : Integer.parseInt(anoMin);
        Integer anoMaxParsed = (anoMax == null || anoMax.isEmpty()) ? null : Integer.parseInt(anoMax);
        String statusParsed = (status == null || status.isEmpty()) ? null : status;

        List<Veiculo> veiculos = veiculoService.findByFilters(marcaIdParsed, modeloIdParsed, precoMinParsed, precoMaxParsed, anoMinParsed, anoMaxParsed, statusParsed);
        model.addAttribute("veiculos", veiculos);
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("modelos", modeloService.findAll());
        return "index";
    }
}