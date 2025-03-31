package br.com.unifecaf.gestao_veiculos.controller;

import br.com.unifecaf.gestao_veiculos.model.Modelo;
import br.com.unifecaf.gestao_veiculos.service.ModeloService;
import br.com.unifecaf.gestao_veiculos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("modelos", modeloService.findAll());
        model.addAttribute("modelo", new Modelo());
        model.addAttribute("marcas", marcaService.findAll());
        return "modelos";
    }

    @PostMapping
    public String saveModelo(@ModelAttribute Modelo modelo) {
        modeloService.save(modelo);
        return "redirect:/modelos";
    }

    @GetMapping("/edit/{id}")
    public String editModelo(@PathVariable Long id, Model model) {
        Modelo modelo = modeloService.findById(id);
        if (modelo == null) {
            return "redirect:/modelos";
        }
        model.addAttribute("modelos", modeloService.findAll());
        model.addAttribute("modelo", modelo);
        model.addAttribute("marcas", marcaService.findAll());
        return "modelos";
    }

    @PostMapping("/delete/{id}")
    public String deleteModelo(@PathVariable Long id) {
        modeloService.delete(id);
        return "redirect:/modelos";
    }
}