
package Repositorio.trabalho_1;


public enum Situacao {

    sobAvaliacao("Sob avaliacao"), aprovado("Aprovado"), reprovado("Reprovado");

    private final String nome;

    Situacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    /**
     * Verifica se a situação da submissao digitada pelo usuario é valida!
     * @param situacao
     * @return 
     */
    public static Situacao verifica(String situacao) {
        if (situacao.equalsIgnoreCase(aprovado.getNome())) {
            return aprovado;
        } else if (situacao.equalsIgnoreCase(sobAvaliacao.getNome())) {
            return sobAvaliacao;
        } else if (situacao.equalsIgnoreCase(reprovado.getNome())) {
            return reprovado;
        }
        return null;
    }
}
