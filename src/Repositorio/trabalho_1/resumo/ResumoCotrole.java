

package Repositorio.trabalho_1.resumo;

import java.util.ArrayList;
import java.util.Scanner;

public class ResumoCotrole {

    Scanner entrada = new Scanner(System.in);

    private ArrayList<Resumo> resumos = new ArrayList();
    
    
    
    /**
     * inclui um novo item na lista
     * @param resumo 
     */
    public void incluir(Resumo resumo) {
        resumos.add(resumo);
    }
    
    
    /**
     * retorna um resumo da lista com base no index
     * @param i
     * @return 
     */
    public Resumo consultar(int i) {
        return resumos.get(i);
    }
    
    
    /**
     * retorna a lista de resumos
     * @return 
     */
    public ArrayList<Resumo> getResumos() {
        return resumos;
    }

    /**
     * exclui um item da lista com base no indice
     * @param i 
     */
    public void excluir(int i) {
        resumos.remove(i);
    }
}