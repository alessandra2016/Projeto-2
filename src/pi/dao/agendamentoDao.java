/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import modelo.agendamento;

public class agendamentoDao {

    private Connection comando;

    public agendamentoDao(Connection comando) {
        this.comando = comando;
    }

    public void insere(agendamento agendar) throws SQLException {

        Statement comando1 = this.comando.createStatement();

        //string com a consulta que serao executada no banco
        String sql = "INSERT INTO AGENDAMENTO(ID_CLIENTE,ID_UNIDADE,ID_FUNCIONARIO,ID_SERVICO,ID_STATUS,ID_AGENDAMENTO,HORARIO_INICIAL,HORARIO_FINAL,FILA_ESPERA,PROMOCAO,DATA_AGEN) value(?,?,?,?,?,?,?,?,?,?,?);";

        try {
            //tenta realizar a conexao, se retornar verdadeiro entra no IF
            if (!this.comando.isClosed()) {
                //prepara a sentensão com a consulta da string
                PreparedStatement sentenca = this.comando.prepareStatement(sql);

                //subtitui as interrogações da consulta, pelo valor especifico
                sentenca.setInt(1, agendar.getIdCliente());
                sentenca.setInt(2, agendar.getIdUnidade());
                sentenca.setInt(3, agendar.getIdFuncionario());
                sentenca.setInt(4, agendar.getIdServico());
                sentenca.setInt(5, agendar.getIdStatus());
                sentenca.setInt(6, agendar.getIdAgendamento());
                sentenca.setString(7, agendar.getHoraInicial());
                sentenca.setString(8, agendar.getHoraFinal()); //subsitui a primeira ocorrÃªncia da interrogaÃ§Ã£o pelo atributo nome
                sentenca.setBoolean(9, agendar.isFilaEspera());
                sentenca.setBoolean(10, agendar.isPromocao());
                sentenca.setString(11, agendar.getDataAgendamento());
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentenÃ§a
                this.comando.prepareStatement(sql).close(); //fecha a conexÃ£o com o banco
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    


}
