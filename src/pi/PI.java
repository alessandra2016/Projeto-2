/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
import modelo.agendamento;
import pi.dao.Conexao;
import pi.dao.clienteDao;
import modelo.cliente;
import modelo.unidade;
import pi.dao.agendamentoDao;
import pi.dao.unidadeDao;

/**
 *
 * @author Alessandra
 */
public class PI {

    static int menu() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" >>>>>>>> Agendamento Eletrônico <<<<<<<<");
        System.out.println("");
        System.out.println(" ++++++  Esmalteria - Com que Cor? ++++++");
        System.out.println(" ");
        System.out.println(" 1 - Agendar "); // verificar agendas ou efetuar agendamentos
        System.out.println(" 2 - Relatorios"); // 
        System.out.println(" 3 - Cadastro "); // editar, excluir, visualizar
        System.out.println(" 0 - Sair ");
        System.out.println(" ");
        int op = leitor.nextInt();

        return op;
    }
// menu para editar, excluir e visualizar o cadastro

    static int submenu() {

        Scanner leitor = new Scanner(System.in);
        System.out.println(" Escolha a opção ");
        System.out.println(" 1 - Editar ");
        System.out.println(" 2 - Excluir ");
        System.out.println(" 3 - Visualizar ");

        int op3 = leitor.nextInt();

        return op3;
    }
// menu que vai diferenciar em qual cadastro a pessoa vai gerenciar, se é cliente ou funcionario

    static int submenu1() {
        Scanner leitor = new Scanner(System.in);

        System.out.println(" Escolha a opção que deseja gerenciar ");
        System.out.println(" 1 - Cliente ");
        System.out.println(" 2 - Funcionário ");
        int op2 = leitor.nextInt();

        return op2;
    }

    static int relatorios() {
        Scanner leitor = new Scanner(System.in);

        System.out.println(" Informe qual relatório deseja consultar ");
        System.out.println(" 1 - fluxo de atendimentos na unidade. ");
        System.out.println(" 2 - fluxo de atendimentos por funcionário");
        System.out.println(" 3 - fluxo de serviço prestado ");
        System.out.println(" 4 - total de clientes que participaram da promoção ");
        System.out.println(" 5 - total de frequencia de cada cliente ");
        //documentação ajustar a quantidade

        int opRelatorio = leitor.nextInt();

        return opRelatorio;
    }

    static int cadastro() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" 1 - Realizar Agendamento ");
        System.out.println(" 2 - Alterar Agendamento ");
        int opCadastro = leitor.nextInt();

        return opCadastro;
    }

    public static void main(String[] args) throws SQLException {
        Scanner leitor = new Scanner(System.in);
        leitor.nextLine();

        // conectar com o banco de dados
        Connection conn = Conexao.conectar();

        // importar as classes de conexão com banco de dados
        clienteDao cli = new clienteDao(conn);
        agendamentoDao agend = new agendamentoDao(conn);
        unidadeDao uni = new unidadeDao(conn);
        // importa as classes
        cliente clie = new cliente();
        agendamento agendar = new agendamento();
        unidade unidade1 = new unidade();

        int op; //menu principal
        do {
            op = menu();
            switch (op) {

                case 1:
                    int opCadastro = cadastro();
                    switch (opCadastro) {

                        case 1: // efetuar o agendamento
                            System.out.println(" Informe qual unidade deseja realizar o serviço ");
                            System.out.println(" ");
                            /*uni.buscar(unidade1);
                            int unidade = leitor.nextInt();
                            agendar.setIdUnidade(unidade);
                            agend.insere(agendar);*/
                            System.out.println(" Escolha a Funcionário(a) ");
                            System.out.println("  ");
                            System.out.println(" Nome do (a) Cliente ");
                            System.out.println("  ");
                            System.out.println(" Escolha o serviço ");
                            System.out.println("  ");
                            System.out.println(" Informe a data ");
                            System.out.println("  ");
                            System.out.println(" Informe o horário inicial ");
                            System.out.println("  ");
                            System.out.println(" Informe o horário final ");
                            System.out.println("  ");
                            System.out.println(" Participa da Promoção ? ");
                            System.out.println("  ");
                            System.out.println(" Valor ");
                            System.out.println("  ");
                            System.out.println(" Status ");
                            System.out.println("  ");
                            System.out.println(" Participa da Fila de Espera?");
                            

                            break;
                        case 2:
                            break;
                    }
                    break;
                case 2:
                    int opRelatorio = relatorios();

                    switch (opRelatorio) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                    }
                    break;

                case 3:

                    int op2 = submenu1(); //submenu para gerenciar cadastro -  escolhe qual cadastro gerenciar
                    switch (op2) {

                        case 1: //cliente
                            int opcaoCliente = submenu(); // editar, excluir ou visualizar - cliente
                            switch (opcaoCliente) {
                                case 1:
                                    System.out.println(" Informe qual cliente deseja editar ");// condição, precisa ver no banco qual chave primaria
                                    break;
                                case 2:
                                    System.out.println(" Informe qual cliente deseja excluir ");
                                    break;
                                case 3:
                                    System.out.println(" ");
                                    System.out.println(" Nome | CPF | RG | Telefone | Celular |");
                                    System.out.println(" ");
                                    cli.buscar(clie);
                                    System.out.println(" ");

                                    break;

                            }
                            break;

                        case 2: //funcionario
                            int opcaoFuncionario = submenu();// editar, excluir ou visualizar - Funcionario

                            switch (opcaoFuncionario) {
                                case 1:
                                    // System.out.println(" Informe qual funcionário deseja editar ");// condição, precisa ver no banco qual chave primaria
                                    break;
                                case 2:
                                    System.out.println(" Informe qual funcionário deseja excluir ");// condição, precisa ver no banco qual chave primaria
                                    break;
                                case 3:
                                    //select
                                    break;
                            }
                    }
                    break;

                default:
                    System.out.println(
                            " Opção invalida !!! ");
            }

            /*System.out.println(" Nome: ");
        String nome = leitor.nextLine();
        System.out.println(" CPF: ");
        String cpf = leitor.nextLine();
        System.out.println(" RG: ");
        String rg = leitor.nextLine();
        System.out.println(" Telefone: ");
        String tel = leitor.nextLine();
        System.out.println(" Celular: ");
        String cel = leitor.nextLine();

        clie.setNome(nome);
        clie.setRg(rg);
        clie.setCpf(cpf);
        clie.setCelular(cel);
        clie.setTelefone(tel);

        cli.insere(clie);*/
        } while (op != 0);

    }
}
