# Sistema de Gerenciamento de Eventos 
##### Trabalho da disciplina de  Gerenciamento de Config. de Software - Turma 030 - 2025/2 - Prof. Daniel Antonio Callegari

---
## Descrição
Este projeto é um sistema para gerenciar eventos, ingressos e participantes. O sistema foi implementado em Java, sem frameworks ou dependências externas.

---

## Diretrizes do Enunciado
Dados em Memória: não há persistência de dados, os dados existem apenas durante a execução.

Dados pré-preenchidos: o sistema deve iniciar com dados pré-preenchidos, de boa qualidade para facilitar os testes.

Sem Login: Não é necessário implementar um sistema de login ou autenticação.

---
## Requisitos do Sistema
1. Para cada evento armazena-se: nome do evento, data, valor do ingresso, responsável e quantidade de ingressos.
2. Cada evento recebe um código único.
3. Os ingressos podem ser normais  ou especiais, 15%  são reservados para os casos especiais.
4. Cada ingresso é nominal, ou seja, está associado a um participante (nome completo e CPF).


---

## Funcionalidades
1. **Cadastrar novos eventos**
    - Validar a data, somente eventos com datas futuras podem ser cadastrados.
    - Atribuir código único automaticamente.
    - Definir quantidade de ingressos e reservra 15% para casos especiais (cadeirantes, deficientes físicos e outras situações).
    - Criar os códigos dos ingressos no seguinte formato `{cod-evento}-{seq}` e `{cod-evento}-{seq}E` para ingressos especiais.

2. **Listar todos os eventos**

3. **Procurar eventos por nome**

4. **Emitir ingressos**
    - Selecionar tipo de ingresso (normal ou especial).
    - Emitidos sequencialmente.
    - Limite máximo conforme definido no evento.

5. **Registrar participação**
    - O ingresso é o critério para a entrada.
    - Registro de presença.

6. **Consultar detalhes de um evento específico**
    - Total de ingressos disponíveis.
    - Número de ingressos normais e especiais.
    - Número de ingressos vendidos e seus respectivos percentuais.
    - Percentual de lotação do evento.
   
7. **Gerar relatório mensal**
    - Escolher  no formato mês e ano.
    - Mostrar eventos e estatísticas detalhadas do mês e ano.

8. **Funcionalidades adicionais**

---

## Estrutura do Projeto
- `src/` : código-fonte em java.
- `docs/`: enunciado em pdf. 
- `tests/`: 

---

## Como Rodar
**Usando uma IDE**
1. Abra a pasta do projeto em sua IDE.
2. Configure o JDK.
3. Localize a classe Main.java.
4. Compile o projeto.
5. Interaja com o sistema via console.

---
