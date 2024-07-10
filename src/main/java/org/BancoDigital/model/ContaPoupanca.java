package org.BancoDigital.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    private BigDecimal taxaRendimento;
    public ContaPoupanca(Cliente cliente, BigDecimal taxaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public BigDecimal calcularRendimentoMensal() {
        return saldo.multiply(taxaRendimento);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
        System.out.printf("Taxa de Rendimento: %.2f%%%n", this.taxaRendimento.multiply(BigDecimal.valueOf(100)));
        System.out.printf("Rendimento Previsto para o Próximo Mês: %.2f%n", calcularRendimentoMensal());
        System.out.printf("Saldo Previsto para o Próximo Mês: %.2f%n", saldo.add(calcularRendimentoMensal()));
    }
}
