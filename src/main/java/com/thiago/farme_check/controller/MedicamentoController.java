package com.thiago.farme_check.controller;

import org.springframework.ui.Model;
import com.thiago.farme_check.entity.Medicamento;
import com.thiago.farme_check.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedicamentoController {

    @Autowired
    MedicamentoRepository repository;

    @GetMapping("/consulta-medicamento")
    public String pesquisa() {
        return "busca";
    }

    @GetMapping("/cadastro-medicamento")
    public String cadastroMedicamento() {
        return "cadastro-produto";
    }

    // 🔥 COM DISPONIBILIDADE
    @PostMapping("efetuar-cadastro-produto")
    public String efetuarCadastro(
            String nome,
            Double preco,
            String descricao,
            String fornecedor,
            @RequestParam(required = false) Boolean disponivel
    ) {

        Medicamento medicamento = new Medicamento();
        medicamento.setNomeMedicamento(nome);
        medicamento.setPreco(preco);
        medicamento.setDescricao(descricao);
        medicamento.setFornecedor(fornecedor);

        // 🔥 TRATAMENTO DO CHECKBOX
        medicamento.setDisponivel(disponivel != null && disponivel);

        repository.save(medicamento);

        return "cadastro-produto-sucesso";
    }

    // 🔍 BUSCA COM DISPONIBILIDADE
    @GetMapping("/buscar")
    public String buscarProduto(@RequestParam(name = "nome", required = false) String nome, Model model) {

        List<String> produtos = new ArrayList<>();

        var medicamento = repository.findByNomeMedicamento(nome);

        if (medicamento != null) {

            if (medicamento.isDisponivel()) {
                produtos.add("O medicamento " + medicamento.getNomeMedicamento() + " está disponível.");
            } else {
                produtos.add("O medicamento " + medicamento.getNomeMedicamento() + " NÃO está disponível.");
            }

        } else {
            produtos.add("Medicamento não encontrado.");
        }

        model.addAttribute("produtos", produtos);

        return "busca";
    }
}