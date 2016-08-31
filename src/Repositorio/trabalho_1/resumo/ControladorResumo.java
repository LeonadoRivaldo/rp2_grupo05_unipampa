package Repositorio.trabalho_1.resumo;

import java.util.ArrayList;
import java.util.Scanner;

public class ControladorResumo {

    private static ArrayList<Resumo> resumos = new ArrayList();

    Resumo open;

    public void incluir(String titulo, int situacao, String autor, String instituicao, ArrayList<String> palavraschave) {
        open = new Resumo(titulo, situacao, autor, instituicao, palavraschave);
        resumos.add(open);
    }

    public static void consulta(String titulo) {
        Scanner e = new Scanner(System.in);
        boolean naoAcho = true;
        for (Resumo resumo : resumos) {

            if (resumo.getTitulo().trim().equalsIgnoreCase(titulo)) {

                System.out.println("DADOS");
                System.out.println("Titulo: " + resumo.getTitulo());
                System.out.println("Autor: " + resumo.getAutor());
                System.out.println("Instituição: " + resumo.getInstituicao());
                System.out.println("Situação: " + resumo.getSituacao());
                for (String palavrachave : resumo.getPalavrachave()) {
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
            if (resumos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                resumos.remove(resumos.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean editar() {
        String titulo;
        int situacao;
        String autor;
        String instituicao;
        ArrayList<String> palavrachave = new ArrayList<>();
        Scanner e = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Editar resumos");
        System.out.println("***************");
        System.out.println("Digite o nome do titulo do resumo que deseja editar");
        titulo = e.nextLine();
        for (int i = 0; i < resumos.size(); i++) {
            if (titulo.equalsIgnoreCase(resumos.get(i).getTitulo())) {
                Resumo resumoEditado = resumos.get(i);

                System.out.println("Escolha o novo titulo");
                resumoEditado.setTitulo(e.nextLine());

                System.out.println("Escolha a nova situação");
                resumoEditado.setInstituicao(e.nextLine());

                System.out.println("Escolha o novo autor");
                resumoEditado.setAutor(e.nextLine());

                int opcao;
                ArrayList<String> palavraschave = new ArrayList();
                do {
                    System.out.println("informe a palavra chave: ");
                    palavrachave.add(e.next());
                    System.out.println("Você quer digitar mais palavras chaves? 1 sim 2 não");
                    opcao = e.nextInt();

                } while (opcao != 2);
                resumoEditado.setPalavrachave(palavrachave);

                return true;
            }
        }
        return false;
    }
}
