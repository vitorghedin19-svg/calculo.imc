package br.com.senac.imc.controllers;

import br.com.senac.imc.dtos.CalculadoraIMCResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/imc")
@CrossOrigin

public class CalculadoraIMCController {

    @GetMapping("/calcular")
    public ResponseEntity<CalculadoraIMCResponseDTO> calcularImc (@RequestParam double peso, @RequestParam double altura){

        CalculadoraIMCResponseDTO imc = new CalculadoraIMCResponseDTO();
        imc.setImc(peso / (altura * altura));

        if (imc.getImc() <= 18.5){
            imc.setClassificacao("Abaixo do peso");
        }

        else if (imc.getImc() <= 24.9){
            imc.setClassificacao("Peso normal");
        }

        else if (imc.getImc() <= 29.9){
            imc.setClassificacao("Sobrepeso");
        }

        else if (imc.getImc() <= 34.9){
            imc.setClassificacao("Obesidade Grau I");
        }

        else if (imc.getImc() <= 39.9){
            imc.setClassificacao("Obesidade Grau II");
        }

        else if (imc.getImc() >= 40){
            imc.setClassificacao("Obesidade Grau III (Mórbida)");
        }

        return ResponseEntity.ok(imc);
 }

}
