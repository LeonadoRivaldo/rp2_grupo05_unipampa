/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;

/**
 *
 * @author leona_000
 */
public enum Tipo {

    graduacao("graduação"), especializacao("especialização"), mestrado("mestrado"), doutorado("doutorado");
   private String nome;

    Tipo(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return this.nome;
    }
}
