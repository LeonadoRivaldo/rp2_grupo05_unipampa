package Repositorio.trabalho_1.palestra;


import java.util.ArrayList;
public class ControleDePalestras {
   ArrayList<Palestra> palestras = new ArrayList<Palestra>();
   
  /**
 * Metodo para criar e incluir uma Palestra
     * @param p
 */
   public void incluir(Palestra p){
        palestras.add(p);
    }

   /**
    * Metodo para excluir uma palestra
     * @param indice
    */
   public void excluir (int indice){
       palestras.remove(indice);       
   }
   
   /**
    * Metodo para editar uma palestra
     * @param indice
     * @param valor
     * @param palestra
    */
   public void editar(int indice, String valor, Palestra palestra){
      /* String titulo,
       String situacao,
       String autor, 
       String resumo,
       String Abstract,
       int duracao,
       String curriculo*/
       switch (indice) {
           case 1:
               palestra.setTitulo(valor);
             break;
           case 2:
               palestra.setAutor(valor);
               break;
           case 3:
               palestra.setResumo(valor);
               break;
           case 4:
               palestra.setabstract(valor);
               break;
           case 5:
               palestra.setDuracao(Integer.parseInt(valor));
               break;
           case 6:
               palestra.setCurriculo(valor);
               break;
               
               
       }
   }
   
  public Palestra consultar(int indice){
      return palestras.get(indice);
  }
     
    
}

