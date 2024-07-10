# Banco Digital - Projeto Conta Corrente

Este projeto implementa uma aplicação básica de Conta Corrente em um banco digital, utilizando Java e Orientação a Objetos.

## Funcionalidades Implementadas

- **ContaCorrente:** Classe que representa uma conta corrente bancária com suporte a limite de cheque especial.
- **Cliente:** Classe que representa um cliente do banco.
- **Operações:** Implementação de operações básicas como depósito, saque e transferência entre contas.

## Estrutura do Projeto

O projeto está estruturado da seguinte maneira:

- src/
    - org/
        - BancoDigital/
            - model/
                - Conta.java
                - ContaCorrente.java
                - ContaPoupanca.java
                - Cliente.java
                - Main.java
            - README.md

## Como Utilizar

1. **Configuração do Ambiente:**
    - Certifique-se de ter o Java JDK instalado.
    - Utilize uma IDE Java, como IntelliJ IDEA ou Eclipse, para abrir o projeto.

2. **Executando o Projeto:**
    - Execute a classe `Main.java` para testar as funcionalidades implementadas.

3. **Funcionalidades Disponíveis:**
    - Criação de contas correntes com limite de cheque especial.
    - Operações de depósito, saque e transferência entre contas.

## Exemplo de Uso

```java
package org.BancoDigital.model;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente 1");

        // Exemplo de criação de uma ContaCorrente com limite de cheque especial de R$ 500
        Conta cc = new ContaCorrente(cliente, BigDecimal.valueOf(500));

        // Realizando operações
        cc.depositar(BigDecimal.valueOf(100));
        cc.transferir(BigDecimal.valueOf(150), outraConta);

        // Imprimindo extrato da conta corrente
        cc.imprimirExtrato();
    }
}