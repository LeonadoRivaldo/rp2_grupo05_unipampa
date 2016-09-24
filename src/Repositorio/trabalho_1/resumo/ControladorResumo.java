package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.Situacao;
<<<<<<< HEAD
import Repositorio.trabalho_1.Submissao;
import Repositorio.trabalho_1.monografias.Monografia;
=======
import Repositorio.trabalho_1.monografias.novo.Monografia;
>>>>>>> 97e058a6b2f2ff41b35cafab6ddd61309e68d239
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorResumo {

    //private static ArrayList<Resumo> resumos = new ArrayList();
    private static ListaSubmissao resumo = new ListaSubmissao();

    public List<Submissao> getResumos() {
        return resumo.getSubmissoes();
    }
    private Resumo open;

    /**
     * incluir publicação resumo
     *
     * @param titulo
     * @param situacao
     * @param autor5
     * @param instituicao
     *
     * @param palavraschave
     *
     * =======
     * @param palavraschave
     *
     */
    public void incluir(String titulo, Situacao situacao, ArrayList<String> autor, ArrayList<String> instituicao, ArrayList<String> palavraschave) {
        open = new Resumo(titulo, situacao, autor, 8, instituicao, palavraschave, 4, 8);
        resumo.incluir(open);
    }

    /**
     *
     * @param titulo
     *
     * @return Função para excluir um resumo usando seu titulo =======
     * @return
     *
     */
    public boolean excluir(String titulo) {
        return resumo.excluir(titulo);

    }
    
    public Resumo consulta  (String titulo){
        return (Resumo)resumo.consultarTitulo(titulo);
    }

    /**
     *
     * @param autor
     * @return
     */
    public List<Submissao> consultaAutor(String autor){
        return resumo.consultarAutor(autor);
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
