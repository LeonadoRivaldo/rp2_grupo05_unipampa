package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.monografias.Monografia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorResumo {

    private static ArrayList<Resumo> resumos = new ArrayList();

    Resumo open;

    public void incluir(String titulo, int situacao, String autor, String instituicao, ArrayList<String> palavraschave) {
      open=new Resumo(titulo, Situacao.sobAvaliacao, palavraschave, situacao, palavraschave, palavraschave, situacao, situacao);
        resumos.add(open);
    }

    public static void consulta(String titulo) {
        Scanner e = new Scanner(System.in);
        boolean naoAcho = true;
        for (Resumo resumo : resumos) {

            if (resumo.getTituloSubmissao().trim().equalsIgnoreCase(titulo)) {

                System.out.println("DADOS");
                System.out.println("Titulo: " + resumo.getTituloSubmissao());
                System.out.println("Autor: " + resumo.getAutor());
                System.out.println("Instituição: " + resumo.getInstituicao());
                System.out.println("Situação: " + resumo.getSituacaoSubmissao());
                for (String palavrachave : resumo.getPalavrasChave()) {
                    System.out.println("palavra chave: " + palavrachave);
                }
                naoAcho = false;
                break;
            }
        }

        if (naoAcho == true) {
            System.out.println("Nenhum resumo ");
        }
    }

    public boolean excluir(String titulo) {
        for (int i = 0; i < resumos.size(); i++) {
            if (resumos.get(i).getTituloSubmissao().equalsIgnoreCase(titulo)) {
                resumos.remove(resumos.get(i));
                return true;
            }
        }
        return false;
    }

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
