package com.thiago.farme_check.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void enviarNotificacaoSimulada(String nomeUsuario, String nomeMedicamento, String unidade) {
        System.out.println("========= NOTIFICAÇÃO SMS (SIMULADA) =========");
        System.out.println("Enviando para o paciente: " + nomeUsuario);
        System.out.println("Mensagem: Olá! O medicamento " + nomeMedicamento +
                " já está disponível na unidade " + unidade + ".");
        System.out.println("==============================================");
    }
}
