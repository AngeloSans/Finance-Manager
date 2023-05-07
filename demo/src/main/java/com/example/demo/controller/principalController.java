package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;



@Controller
public class principalController {
    @GetMapping("/principal")
    public String login(){
        return "principal.html";
    }

    @PostMapping("/voltar")
    public String voltar(){
        return "login.html";
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
    
        if (aluguel != null && !aluguel.isEmpty()) {
            aluguelValor = Double.parseDouble(aluguel);

        }
    
        if (supermercado != null && !supermercado.isEmpty()) {
            supermercadoValor = Double.parseDouble(supermercado);

        }
    
        if (conta != null && !conta.isEmpty()) {
            contaValor = Double.parseDouble(conta);
   
        }
    
        if (gastos != null && !gastos.isEmpty()) {
            gastosValor = Double.parseDouble(gastos);

        }
    
        if (aluguelValor != null && supermercadoValor != null && contaValor != null && gastosValor != null) {
            double total = aluguelValor + supermercadoValor + contaValor + gastosValor;
            model.addAttribute("valor_aluguel","$" + aluguelValor);
            model.addAttribute("valor_super","$" + supermercadoValor);
            model.addAttribute("valor_conta","$" + contaValor);
            model.addAttribute("total","O valor total gasto é: $" + total);
            model.addAttribute("valor_outros","$" + gastosValor);
            return "principal";
        } else {
            model.addAttribute("vazio", "Preencha todos os campos com valores numéricos para mostrar o valor total");
            return "principal";
        }
    }
}
