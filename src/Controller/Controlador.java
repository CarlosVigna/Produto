package Controller;

import Model.Alimento;
import Model.Vestuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    Alimento alimento = new Alimento();
    Vestuario vestuario = new Vestuario();
    Scanner teclado = new Scanner(System.in);

    //armazenamento
    ArrayList<Alimento> ListaDeAlimentos = new ArrayList<>();
    ArrayList<Vestuario> ListaDeVestuarios = new ArrayList<>();
    ArrayList<Alimento> ListaDeAlimentosVendidos = new ArrayList<>();
    ArrayList<Vestuario> ListaDeVestuariosVendidos = new ArrayList<>();

    //menu
    final int CADASTRAR_ALIMENTO = 1;
    final int CADASTRAR_VESTUARIO = 2;
    final int MOSTRAR_ESTOQUE_ALIMENTO = 3;
    final int MOSTRAR_ESTOQUE_VESTUARIO = 4;
    final int REALIZAR_VENDA = 5;
    final int ALIMENTOS_VENDIDOS = 6;
    final int VESTUARIOS_VENDIDOS = 7;
    final int SAIR = 9;

    int escolha = 0;

    public void controle() {
        do {
            try {
                System.out.println("LOJÃO TEM TUDO!!! ");
                System.out.println("Escolha uma das opções abaixo: ");
                System.out.println("Aperte 01 para cadastrar um alimento.");
                System.out.println("Aperte 02 para cadastrar um vestuário.");
                System.out.println("Aperte 03 para visualizar o estoque de alimento.");
                System.out.println("Aperte 04 para visualizar o estoque de vestuário.");
                System.out.println("Aperte 05 para realizar uma venda.");
                System.out.println("Aperte 06 para visualizar os alimentos vendidos.");
                System.out.println("Aperte 07 para visualizar os vestuários vendidos.");
                System.out.println("09 para sair! ");
                escolha = teclado.nextInt();

                switch (escolha) {
                    case CADASTRAR_ALIMENTO:
                        alimento = new Alimento();
                        alimento.cadastrarAlimento(teclado);
                        ListaDeAlimentos.add(alimento);
                        System.out.println("Alimento cadastrado com sucesso!");
                        break;
                    case CADASTRAR_VESTUARIO:
                        vestuario = new Vestuario();
                        vestuario.cadastrarVestuario(teclado);
                        ListaDeVestuarios.add(vestuario);
                        System.out.println("Vestuário cadastrado com sucesso!");
                        break;
                    case MOSTRAR_ESTOQUE_ALIMENTO:
                        for (Alimento x : ListaDeAlimentos) {
                            System.out.println("Nome: " + x.getDescricao() + "\nQuantidade: " + x.getQuantidade());
                        }
                        break;
                    case MOSTRAR_ESTOQUE_VESTUARIO:
                        for (Vestuario y : ListaDeVestuarios) {
                            System.out.println("Nome: " + y.getDescricao() + "\nQuantidade: " + y.getQuantidade());
                        }
                        break;
                    case REALIZAR_VENDA:
                        int escolhaTipo = 0;
                        System.out.println("Escolha o tipo de produto: ");
                        System.out.println("Digite 1 para Alimento.");
                        System.out.println("Digite 2 para Vestuário.");
                        System.out.println("Digite 3 para voltar ao menu inicial.");
                        escolhaTipo = teclado.nextInt();

                        if (escolhaTipo == 1) {
                            realizarVendaAlimento();
                        } else if (escolhaTipo == 2) {
                            realizarVendaVestuario();
                        } else {
                            System.out.println("Opção inválida!! ");
                        }
                        break;
                    case ALIMENTOS_VENDIDOS:
                        System.out.println("Segue abaixo a listagem de Alimentos vendidos:");
                        for (Alimento alimentosVendidos : ListaDeAlimentosVendidos) {
                            System.out.println(alimentosVendidos.detalhesVendidos());
                        }
                        break;
                    case VESTUARIOS_VENDIDOS:
                        System.out.println("Segue abaixo a listagem de Roupas vendidas:");
                        for (Vestuario vestuariosVendidos : ListaDeVestuariosVendidos) {
                            System.out.println(vestuariosVendidos.detalhesVendidos());
                        }
                        break;
                    case SAIR:
                        System.out.println("FUI");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                teclado.nextLine(); // limpar buffer do scanner
            }

        } while (escolha != 9);
    }

    private void realizarVendaAlimento() {
        System.out.println("Escolha um dos alimentos abaixo: ");
        int i = 1;
        for (Alimento listinha : ListaDeAlimentos) {
            System.out.println(i + " - " + listinha);
            i++;
        }
        int escolhaAlimento;
        System.out.println("Digite o número correspondente ao alimento desejado:");
        escolhaAlimento = teclado.nextInt();
        Alimento alimentoSelecionado = ListaDeAlimentos.get(escolhaAlimento - 1);

        System.out.println("O alimento escolhido foi: " + alimentoSelecionado);
        System.out.println("Digite a quantidade desejada:");
        int quantidadeEscolhida = teclado.nextInt();

        if (alimentoSelecionado.getQuantidade() >= quantidadeEscolhida) {
            alimentoSelecionado.baixarEstoque(quantidadeEscolhida);
            alimentoSelecionado.setQuantidadeVendida(alimentoSelecionado.getQuantidadeVendida() + quantidadeEscolhida);
            ListaDeAlimentosVendidos.add(alimentoSelecionado); // Adiciona na lista de vendidos
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Quantidade em estoque insuficiente.");
        }

        mostrarEstoqueAtualAlimento();
    }

    private void realizarVendaVestuario() {
        System.out.println("Escolha uma das roupas abaixo: ");
        int i = 1;
        for (Vestuario listaVestuario : ListaDeVestuarios) {
            System.out.println(i + " - " + listaVestuario);
            i++;
        }
        int escolhaVestuario;
        System.out.println("Digite o número correspondente a roupa desejada:");
        escolhaVestuario = teclado.nextInt();
        Vestuario vestuarioSelecionado = ListaDeVestuarios.get(escolhaVestuario - 1);

        System.out.println("A roupa escolhida foi: " + vestuarioSelecionado);
        System.out.println("Digite a quantidade desejada:");
        int quantidadeEscolhida = teclado.nextInt();

        if (vestuarioSelecionado.getQuantidade() >= quantidadeEscolhida) {
            vestuarioSelecionado.baixarEstoque(quantidadeEscolhida);
            vestuarioSelecionado.setQuantidadeVendida(vestuarioSelecionado.getQuantidadeVendida() + quantidadeEscolhida);
            ListaDeVestuariosVendidos.add(vestuarioSelecionado); // Adiciona na lista de vendidos
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Quantidade em estoque insuficiente.");
        }

        mostrarEstoqueAtualVestuario();
    }

    private void mostrarEstoqueAtualAlimento() {
        System.out.println("Estoque atual de alimentos:");
        for (Alimento x : ListaDeAlimentos) {
            System.out.println("Nome: " + x.getDescricao() + "\nQuantidade: " + x.getQuantidade());
        }
    }

    private void mostrarEstoqueAtualVestuario() {
        System.out.println("Estoque atual de vestuários:");
        for (Vestuario y : ListaDeVestuarios) {
            System.out.println("Nome: " + y.getDescricao() + "\nQuantidade: " + y.getQuantidade());
        }
    }
}
