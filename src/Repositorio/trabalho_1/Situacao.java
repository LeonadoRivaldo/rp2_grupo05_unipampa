/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

/**
 *
 * @author leona_000
 */
public enum Situacao {

    sobAvaliacao("Sob avaliacao"), aprovado("Aprovado"), reprovado("Reprovado");

    private final String nome;

    Situacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    
   

}
