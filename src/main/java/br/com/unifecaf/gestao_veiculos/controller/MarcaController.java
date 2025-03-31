package br.com.unifecaf.gestao_veiculos.controller;

import br.com.unifecaf.gestao_veiculos.model.Marca;
import br.com.unifecaf.gestao_veiculos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("marca", new Marca());
        return "marcas";
    }

    @PostMapping
    public String saveMarca(@ModelAttribute Marca marca) {
        marcaService.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/edit/{id}")
    public String editMarca(@PathVariable Long id, Model model) {
        Marca marca = marcaService.findById(id);
        if (marca == null) {
            return "redirect:/marcas";
        }
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("marca", marca);
        return "marcas";
    }

    @PostMapping("/delete/{id}")
    public String deleteMarca(@PathVariable Long id) {
        marcaService.delete(id);
        return "redirect:/marcas";
    }
}