package org.BancoDigital.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaCorrente extends Conta {
    private BigDecimal limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, BigDecimal limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(BigDecimal valor) {
        BigDecimal saldoTotalDisponivel = saldo.add(limiteChequeEspecial);
        if (saldoTotalDisponivel.compareTo(valor) >= 0) {
            if (saldo.compareTo(valor) >= 0) {
                saldo = saldo.subtract(valor);
            } else {
                BigDecimal valorRestante = valor.subtract(saldo);
                saldo = BigDecimal.ZERO;
                limiteChequeEspecial = limiteChequeEspecial.subtract(valorRestante);
            }
        } else {
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
        }
    }

    @Override
    public void transferir(BigDecimal valor, Conta contaDestino) {
        BigDecimal saldoTotalDisponivel = saldo.add(limiteChequeEspecial);
        if (saldoTotalDisponivel.compareTo(valor) >= 0) {
            if (saldo.compareTo(valor) >= 0) {
                saldo = saldo.subtract(valor);
            } else {
                BigDecimal valorRestante = valor.subtract(saldo);
                saldo = BigDecimal.ZERO;
                limiteChequeEspecial = limiteChequeEspecial.subtract(valorRestante);
            }
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        System.out.printf("Limite Cheque Especial: %.2f%n", this.limiteChequeEspecial);
    }
}
