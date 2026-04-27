# ☕ Sistema de Gerenciamento de Cafeteria

Este projeto foi desenvolvido como parte do curso **Linguagem Backend: Ágil e Escalável - Desenvolvendo em Kotlin**, integrado ao programa **TIC em Trilhas**. O sistema simula o gerenciamento de uma cafeteria, permitindo controle de estoque e fluxo de vendas via console.

## 🚀 O que eu aprendi neste projeto:

- **Manipulação de Collections**: Uso estratégico de `MutableList` e `MutableMap` para gerenciar o estado da aplicação em memória, simulando um banco de dados.
- **Null Safety e Robustez**: Aplicação de recursos nativos do Kotlin, como `toIntOrNull()` e o operador Elvis (`?:`), para evitar crashes por entradas inválidas.
- **Validação de Dados**: Implementação de loops de verificação (`while`) para garantir que valores como preço e quantidade sejam sempre positivos e válidos.
- **Formatação de Dados (Output Formatting)**: Uso de formatadores de string para exibição profissional de valores monetários (ex: R$ 4.50).
- **Lógica de Negócio**: Desenvolvimento de regras para controle de estoque, prevenção de duplicidade de registros e fluxos condicionais de venda.
- **Paradigma Funcional**: Utilização da função `.find` para buscas ágeis e legíveis dentro das coleções.

## 🛠️ Funcionalidades

- [x] **Listagem Organizada**: Exibição formatada de todos os produtos, preços e estoque atual.
- [x] **Cadastro de Itens**: Adição de novos produtos com trava de segurança para evitar nomes duplicados.
- [x] **Fluxo de Vendas**: Verificação de saldo em estoque antes de confirmar a saída de mercadorias.
- [x] **Gestão de Reposição**: Atualização de estoque existente com integração ao fluxo de cadastro para itens não localizados.

## 💻 Como Rodar o Projeto:

Para executar este sistema em sua máquina, você precisa ter o JDK e o compilador Kotlin instalados. Siga os comandos abaixo no seu terminal:

```bash
git clone https://github.com/Joao-Gabriel-Martins-Callegari/Cafeteria-Kotlin.git
cd Cafeteria-Kotlin

kotlinc main.kt -include-runtime -d cafeteria.jar
java -jar cafeteria.jar
