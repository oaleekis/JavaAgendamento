package DAO;

import Model.Agendamento;
import Model.Medico;
import Model.Paciente;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AgendamentoDAO {

    public static ArrayList<Agendamento> MinhaLista = new ArrayList<Agendamento>();

    public AgendamentoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_agendamentos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;

        try {

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_bonzina";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    public ArrayList getMinhaLista() {

        MinhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT tb_agendamentos.id,data,horario,tb_agendamentos.telefone,idpaciente,idmedico,tb_medicos.nome as medico_nome,tb_pacientes.nome as paciente_nome FROM tb_agendamentos INNER JOIN tb_medicos on tb_medicos.id = tb_agendamentos.idmedico INNER JOIN tb_pacientes ON tb_pacientes.id = tb_agendamentos.idpaciente");

            while (res.next()) {
                Agendamento a = new Agendamento();
                Medico m = new Medico();
                Paciente p = new Paciente();

                a.setId(res.getInt("id"));
                a.setData(res.getString("data"));
                a.setHorario(res.getString("horario"));
                a.setTelefone(res.getLong("telefone"));
                p.setId(res.getInt("idpaciente"));
                p.setNome(res.getString("paciente_nome"));
                m.setId((res.getInt("Idmedico")));
                m.setNome(res.getString("medico_nome"));
                a.setIdmedico(m);
                a.setIdpaciente(p);

                MinhaLista.add(a);

            }
            return MinhaLista;

        } catch (Exception e) {

            return null;
        }

    }

    public boolean InsertAgendamentoBD(Agendamento objeto) {
        String sql = "INSERT INTO tb_agendamentos(idpaciente,telefone,data, horario, idmedico) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdpaciente().getId());
            stmt.setLong(2, objeto.getTelefone());
            stmt.setString(3, objeto.getData());
            stmt.setString(4, objeto.getHorario());
            stmt.setInt(5, objeto.getIdmedico().getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean DeleteAgendamentoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_agendamentos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateAgendamentoBD(Agendamento objeto) {

        String sql = "UPDATE tb_agendamentos SET idpaciente = ? ,telefone = ? ,data = ? ,horario = ? ,idmedico = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdpaciente().getId());
            stmt.setLong(2, objeto.getTelefone());
            stmt.setString(3, objeto.getData());
            stmt.setString(4, objeto.getHorario());
            stmt.setInt(5, objeto.getIdmedico().getId());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (Exception erro) {
            System.out.println(objeto.toString());
            throw new RuntimeException(erro);
        }

    }

    public Paciente retornapaciente(String nome){

        String sql = "SELECT id , nome FROM tb_pacientes WHERE nome = ? " ;

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet res = stmt.executeQuery();

            res.first();
            Paciente p = new Paciente();
            
            p.setNome(res.getString("nome"));
            p.setId(res.getInt("id"));
           

            return p;

        } catch (SQLException erro) {

            return null;
        }

    }
    
    

    public Agendamento carregaAgendamento(int id) {

        Agendamento objeto = new Agendamento();
        Medico objetomedico = new Medico();
        Paciente objetopaciente = new Paciente();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_agendamentos WHERE id = " + id);
            res.next();

            objetopaciente.setId(res.getInt("idpaciente"));
            objeto.setIdpaciente(objetopaciente);
            objeto.setTelefone(res.getLong("telefone"));
            objeto.setData(res.getString("data"));
            objeto.setHorario(res.getString("horario"));
            objetomedico.setId(res.getInt("idmedico"));
            objeto.setIdmedico(objetomedico);

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }

}
