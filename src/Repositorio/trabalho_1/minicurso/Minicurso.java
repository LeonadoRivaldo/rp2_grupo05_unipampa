package Repositorio.trabalho_1.minicurso;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoApresentacao;
import java.util.List;

/**
 * Classe para objetos do tipo Minicurso que contem os atributos e operações do
 * mesmo
 */
public class Minicurso extends SubmissaoApresentacao {

    private String recursos;
    private String metodologia;

    /**
     * Construtor que recebe por parametro todos os atributos de um minicurso
     *
     * @param titulo String do titulo
     * @param autores List de autores, no máximo 3
     * @param resumo String do resumo
     * @param situacao Situacao situação
     * @param abstrac String abstract
     * @param metodologia String metodologia
     * @param recursos String recursos
     * @param duracao int duracão, este onde o numero de horas deve ser
     * envia em minutos
     */
    public Minicurso(String titulo, List autores, String resumo, Situacao situacao,
            String abstrac, String metodologia, String recursos, int duracao) {
        super(resumo, abstrac, duracao, titulo, situacao, autores, 3);
        this.recursos = recursos;
        this.metodologia = metodologia;
    }

    /**
     * @return the recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the metodologia
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    /**
     * Metodo que transforma em String os dados do minicurso
     *
     * @return Retorna os dados em String do minicurso
     */
    @Override
    public String toString() {
        String string;
        string = (super.toString()
                + "\n7- Recursos: " + recursos
                + "\n8-Metodologia: " + metodologia);
        return string;
    }
}
