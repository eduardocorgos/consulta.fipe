# Consulta FIPE 🚗📊

Aplicação Java que consome a API pública da Tabela FIPE para consultar o valor médio de veículos (carros, motos e caminhões). O usuário pode selecionar o tipo de veículo, marca, modelo e ano para obter as informações detalhadas do preço de mercado.

## 🧰 Tecnologias utilizadas

- Java 17
- Biblioteca HTTP nativa (HttpClient)
- Jackson (para serialização/desserialização de JSON)
- API FIPE: https://parallelum.com.br/fipe/api/v1/

## 📦 Organização do Projeto

```
projeto.consulta.fipe
│
├── main                 # Contém a classe principal e o fluxo de execução
│   └── MainCode.java
│
├── model               # Classes que representam os dados da API
│   ├── DadosVeiculo.java
│   ├── DetalhesVeiculo.java
│   ├── Marca.java
│   └── ModelosAnosResponse.java
│
├── service             # Serviços de consumo da API e tratamento de dados
│   ├── ApiConsumer.java
│   └── DataConversor.java
│
└── util                # Utilitários (se aplicável)
```

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/eduardocorgos/consulta.fipe.git
   cd consulta.fipe
   ```

2. Compile o projeto (com o Java 17 ou superior instalado):
   ```bash
   javac -d out $(find . -name "*.java")
   ```

3. Execute:
   ```bash
   java -cp out projeto.consulta.fipe.main.MainCode
   ```

## 🧪 Funcionalidades

- Consulta por:
  - Tipo de veículo (carro, moto, caminhão)
  - Marca
  - Modelo
  - Ano
- Exibição de detalhes:
  - Valor médio
  - Combustível
  - Código Fipe
  - Mês de referência

## 📌 Exemplo de uso

```
Escolha o tipo de veículo (carros, motos, caminhoes):
carros
Digite o código da marca:
21
Digite o código do modelo:
4828
Digite o ano do veículo:
2021-1

Marca: Fiat
Modelo: Uno Mille Economy
Ano Modelo: 2021
Combustível: Gasolina
Valor: R$ 23.456,00
```

## ❗ Tratamento de erros

- Erros de conexão com a API são tratados e exibem mensagens amigáveis.
- Validação de entradas do usuário.
- Fallback para possíveis exceções de parsing com Jackson.


---

💡 Projeto desenvolvido por [Eduardo Corgos](https://github.com/eduardocorgos), como exercício prático de consumo de API REST com Java / SPRING.
