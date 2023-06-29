package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class principalController {
    @GetMapping("/principal")
    public String Tela_Principal() {
        return "principal.html";
    }

    @GetMapping("/mostrar")
    public String mostrarResultado(@RequestParam("aluguel") String aluguel,
            @RequestParam("supermercado") String supermercado,
            @RequestParam("conta") String conta,
            @RequestParam("gastos") String gastos,
            Model model) {
        Double aluguelValor = null;
        Double supermercadoValor = null;
        Double contaValor = null;
        Double gastosValor = null;

        if (aluguel != null && !aluguel.isEmpty() && aluguel.matches("[0-9]+")) {
            aluguelValor = Double.parseDouble(aluguel);

        }

        if (supermercado != null && !supermercado.isEmpty() && supermercado.matches("[0-9]+")) {
            supermercadoValor = Double.parseDouble(supermercado);

        }

        if (conta != null && !conta.isEmpty() && conta.matches("[0-9]+")) {
            contaValor = Double.parseDouble(conta);

        }

        if (gastos != null && !gastos.isEmpty() && gastos.matches("[0-9]+")) {
            gastosValor = Double.parseDouble(gastos);

        }

        if (aluguelValor != null && supermercadoValor != null && contaValor != null && gastosValor != null) {
            double total = aluguelValor + supermercadoValor + contaValor + gastosValor;
            model.addAttribute("valor_aluguel", "$" + aluguelValor);
            model.addAttribute("valor_super", "$" + supermercadoValor);
            model.addAttribute("valor_conta", "$" + contaValor);
            model.addAttribute("total", "The total amount spent is: $" + total);
            model.addAttribute("valor_outros", "$" + gastosValor);
            return "principal";
        } else {
            model.addAttribute("vazio", "Fill in all fields with numeric values to show the total amount");
            return "principal";
        }
    }
}
