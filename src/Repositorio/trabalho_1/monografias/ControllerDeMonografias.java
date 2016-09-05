/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leona_000
 */
public class ControllerDeMonografias {

    ArrayList<Monografia> monografias = new ArrayList<Monografia>();

    /**
     * inclui uma monografia na biblioteca
     *
     * @param m objeto monografia criado na interface
     * @return
     */
    public boolean incluir(Monografia m) {
        monografias.add(m);
        return true;
    }

    /**
     * faz consulta utilizando uma lista enumerada, e seleciona qual item da
     * lista quer mostrar
     *
     * @param indice da monografia dentro da lista
     * @return
     */
    public Monografia consultar(int indice) {
        return monografias.get(indice);
    }

    /**
     * funçao para exlcuir uma monografia
     *
     * @param indice da monografia dentro da lista
     * @return
     */
    public boolean excluir(int indice) {
        monografias.remove(indice);
        return true;
    }

    /**
     * <p>
     * metodo que recebe um inteiro que representa um atributo da classe, o
     * valor para modificar o objeto e o objeto a ser modificado</p>
     * <i>
     * Titulo = 1<br/>
     * tipo = 2<br/>
     * autor = 3<br/>
     * Instituicao = 4 <br/>
     * orientador = 5<br/>
     * curso = 6<br/>
     * ano = 7<br/>
     * numeroDePaginas = 8<br/>
     * palavrasChaves = 9<br/>
     * resumo = 10<br/>
     * Abstract = 11<br/>
     * </i>
     *
     * @param atributo
     * @param valor
     * @param monografia
     */
    public boolean editar(int atributo, String valor, Monografia monografia) {
        switch (atributo) {
            case 1:
                monografia.setTituloSubmissao(valor);
                break;
            case 3:
                Tipo tipoMonografia = null;
                tipoMonografia = Submissao.verificaTipo(valor);
                while (tipoMonografia == null) {
                    tipoMonografia = Submissao.verificaTipo(PreencheMonografia.preencheTipo());
                }
                monografia.setTipo(tipoMonografia);
                break;

            case 2:
                Situacao situacao = null;
                situacao = Submissao.verificaSituacao(valor);
                while (situacao == null) {
                    situacao = Submissao.verificaSituacao(PreencheMonografia.preencheSituacao());
                }
                monografia.setSituacaoSubmissao(situacao);
                break;
            case 4:
                List<String> autor = new ArrayList<String>();
                autor.add(valor);
                monografia.setAutor(autor);
                break;
            case 5:
                List<String> insti = new ArrayList<String>();
                insti.add(valor);
                monografia.setInstituicao(insti);
                break;
            case 6:
                monografia.setOrientador(valor);
                break;
            case 7:
                monografia.setCurso(valor);
                break;
            case 8:
                monografia.setAno(Integer.parseInt(valor));
                break;
            case 9:
                monografia.setNumeroDePaginas(Integer.parseInt(valor));
                break;
            case 10:
                String[] p = valor.split("-");
                List<String> palavras = new ArrayList<>();
                for (String pala : p) {
                    palavras.add(pala);
                }
                monografia.setPalavrasChave(palavras);
                break;
            case 11:
                monografia.setResumo(valor);
                break;
            case 12:
                monografia.setAbstract(valor);
                break;
        }
        return true;
    }

    /**
     * Função para criar o objeto monografia
     *
     * @param monografia
     * @return
     */
    public boolean criar(Monografia monografia) {
        incluir(monografia);
        return true;
    }

}
