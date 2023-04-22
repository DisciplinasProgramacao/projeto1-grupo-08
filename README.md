[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10309616)
# Trabalho: Gestão de estoque
Grupo 08 do laboratório da disciplina LPM 1/2023 PUC Minas - Praça da Liberdade
- completando: Sistema simples de gestão de estoque, calculando preços de venda de produtos e verificando quantidades mínimas para novos pedidos.
 
 ---

## Nota base do grupo: 8,2

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

- códigos usando 'package' que não existe (package org.example)

### Diagrama + aderência das classes ao diagrama: 1,2/2 pontos 
	- diversos métodos de Storage não implementados (nem mesmo a assinatura para não dar erro de compilação).
### Requisitos corretamente implementados: 2/6 pontos 
	- produto (preço, estoque)
        - set sem validação (cost, minimumQuantity)
        - preço não é set: o produto deve calcular seu preço
        - addQuantity sem validação
	- estoque (valor, abaixo do estoque)
        - vários métodos não aderentes ao diagrama, prejudicando funcionamento
	- sistema (vender, comprar, consultas)
        - não rodou por haver diversos métodos de Storage não implementados

### Documentação de código: 2/3 pontos 
    - formato não respeitado em "Storage"
		
### Testes (quantidade e qualidade): 3/4 pontos 
	- produto: 1,5/2 pontos
	- estoque: 1,5/2 pontos
	
---

## Alunos integrantes da equipe

* Bernardo Cavanellas Biondini
* João Vitor Bessa Lacerda
* Nathan Gonçalves de Oliveira

## Professores responsáveis

* João Caram Santos de Oliveira

