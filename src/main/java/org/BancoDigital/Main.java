package org.BancoDigital;

import org.BancoDigital.model.Cliente;
import org.BancoDigital.model.Conta;
import org.BancoDigital.model.ContaCorrente;
import org.BancoDigital.model.ContaPoupanca;

import java.math.BigDecimal;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente 1");

        Conta cc = new ContaCorrente(cliente, BigDecimal.valueOf(500));
        Conta poupanca = new ContaPoupanca(cliente, BigDecimal.valueOf(0.08));

        cc.depositar(BigDecimal.valueOf(100));
        cc.transferir(BigDecimal.valueOf(150), poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}