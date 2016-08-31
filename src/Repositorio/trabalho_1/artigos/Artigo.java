/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;



/**
 *
 * @author Amanda Lopes
 */
public class Artigo {

    private String titulo;
    private String situacao = "Em Avaliação";
    private String[] autor;
    private String[] instituicao;
    private String[] palavrachave;
    private String resumo;
    private String Abstract;
    
  public Artigo(){
    
}
  
 public Artigo(String titulo, String[] autor, String[] instituicao, String[] palavrachave, String resumo, String Abstract){
    this.titulo = titulo;
    this.autor = autor;
    this.instituicao = instituicao;
    this.palavrachave = palavrachave;
    this.resumo = resumo;
    this.Abstract = Abstract;
    
 }
 
     public String getTitulo(){
         return titulo;
     }
 
    public void  setTitulo(String titulo){
        this.titulo = titulo; 
    }
    
    
    public String getSituacao(){
         return situacao;
     }
     
    public void setSituacao(String situacao){
         this.situacao = situacao;
     }
     
     
    public String[] getAutor(){
         return autor;
     }
 
    public void  setAutor(String[] autor){
        this.autor = autor; 
    }
    
    public String[] getInstituicao(){
         return instituicao;
     }
 
    public void  setInstituicao(String[] instituicao){
        this.instituicao = instituicao; 
    }
    
    public String[] getPalavrachave(){
         return palavrachave;
     }
 
    public void  setPalavrachave(String[] palavrachave){
        this.palavrachave = palavrachave; 
    }
    
    public String getResumo(){
        return resumo;
    }
    
    public void setResumo(String resumo){
        this.resumo = resumo;
    }
    
    public String getAbstract(){
        return Abstract;
    }
    
    public void setAbstract(String Abstract){
        this.Abstract = Abstract;
    }

   

   
}

