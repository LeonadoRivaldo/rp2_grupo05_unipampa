package Repositorio.trabalho_1;


import java.util.List;

/**
 * Interace que especifica a assinatura os métodos que devem ser implementados
 * pelas litas de submissoes.
 *
 * @author Aline
 */
public interface ListaSubmissoes {

    /**
     * Inclui uma submissão a lista de submissões.
     *
     * @param submissao Submissão a ser incluída.
     * @return True se a inclusão foi bem sucedida ou False em caso contrário.
     */
    public boolean incluir(Submissao submissao);

    /**
     * Consulta a submissão com o título informado.
     *
     * @param titulo Título a ser consultado.
     * @return Submissão com o título informado ou null em caso de não existir
     * submissão com o título informado.
     */
    public Submissao consultarTitulo(String titulo);

    /**
     * Consulta a lista de submissões com o autor informado.
     *
     * @param autor Autor a ser consultado.
     * @return Lista de submissões do autor informado ou null em caso de não
     * existir submissões do autor.
     */
    public List<Submissao> consultarAutor(String autor);

    /**
     * Edita a submissão com o título informado.
     *
     * @param titulo Título da submissão a ser editada.
     * @param submissao Submissão com as novas informações.
     * @return True se a submissão com o título informado for editada e False
     * caso nenhuma submissão com o título infornado for encontrada.
     */
    public boolean editar(String titulo, Submissao submissao);

    /**
     * Exclui a submissão com o título informado.
     *
     * @param titulo Título da submissão a ser excluída.
     * @return True se a submissão com o título informado for excluída e False
     * caso nenhuma submissão com o título infornado for encontrada.
     */
    public boolean excluir(String titulo);
}
