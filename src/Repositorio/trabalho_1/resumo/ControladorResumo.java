package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.monografias.Monografia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorResumo {

    private static ArrayList<Resumo> resumos = new ArrayList();

    public ArrayList<Resumo> getResumos() {
        return resumos;
    }
    private Resumo open;
    /**
     * incluir publicação resumo
     * @param titulo
     * @param situacao
     * @param autor
     * @param instituicao
     * @param palavraschave 
     */
    public void incluir(String titulo, Situacao situacao, ArrayList<String> autor, ArrayList<String> instituicao, ArrayList<String> palavraschave) {
        open = new Resumo(titulo, situacao, autor, 8, instituicao, palavraschave, 4, 8);
        resumos.add(open);
    }
    /**
     * 
     * @param titulo
     * @return 
     */
    public boolean excluir(String titulo) {
        for (int i = 0; i < resumos.size(); i++) {
            if (resumos.get(i).getTituloSubmissao().equalsIgnoreCase(titulo)) {
                resumos.remove(resumos.get(i));
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param atributo
     * @param valor
     * @param resumo
     * @return 
     * @deprecated tá usando um na main
     */
    public boolean editar(int atributo, String valor, Resumo resumo) {
        switch (atributo) {
            case 1:
                resumo.setTituloSubmissao(valor);
                break;
            case 2:
                List<String> autor = new ArrayList<String>();
                autor.add(valor);
                resumo.setAutor(autor);
                break;
            case 3:
                List<String> insti = new ArrayList<String>();
                insti.add(valor);
                resumo.setInstituicao(insti);
                break;
            case 4:
                String[] p = valor.split(" ");
                List<String> palavras = new ArrayList<>();
                for (String pala : p) {
                    palavras.add(pala);
                }
                resumo.setPalavrasChave(palavras);
                break;

        }
        return true;
    }

}
