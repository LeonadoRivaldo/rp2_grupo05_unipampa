/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_1.artigos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amanda Gobus
 */
public class ControleDeArtigos {

  
    ArrayList<Artigo> artigos = new ArrayList<Artigo>();
    /**
     * Método para incluir um artigo
     */
    
    public void incluir(Artigo artigo){
        artigos.add(artigo);
    }
    
    /**
     * Método para consultar um artigo
     */
    public Artigo consultar(int y){
          return artigos.get(y);
           
     }
    
    /**
     * Método para editar uma artigo
     * 1 - String titulo,
     * 2 - String[] autor,
     * 3 - String[] instituicao, 
     * 4 - String[] palavrachave, 
     * 5 - String resumo,
     * 6 - String Abstract
     */
    public void editar(int atributo, String valor, Artigo artigo ){
        switch(atributo) {
            case 1:
                artigo.setTitulo(valor);
                break;
            case 2:
                String[] autor = valor.split(" ");
                artigo.setAutor(autor);
                break;
            case 3:
                String[] instituicao = valor.split(" ");
                artigo.setInstituicao(instituicao);
                break;
            case 4:
                String[] palavrachave = valor.split(" ");
                artigo.setPalavrachave(palavrachave);
                break;
            case 5:
                artigo.setResumo(valor);
                break;
            case 6:
                artigo.setAbstract(valor);
                break;
        }
        
    }
    /**
     * Método para excluir uma artigo
     */
    public void excluir(int y){
         artigos.remove(y);
        
    }
  
    
}
