 package DAO;

import Model.Paciente;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PacienteDAO {

    public static ArrayList<Paciente> MinhaLista = new ArrayList<Paciente>();

    public PacienteDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_pacientes");
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
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_pacientes");
            while (res.next()) {

                String endereco = res.getString("endereco");
                String datanascimento = res.getString("datanascimento");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                long telefone = res.getLong("telefone");

                Paciente objeto = new Paciente(endereco, datanascimento, id, nome, telefone);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    
    public boolean InsertPacienteBD(Paciente objeto) {
        String sql = "INSERT INTO tb_pacientes(id,nome,telefone,endereco,datanascimento) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setLong(3, objeto.getTelefone());
            stmt.setString(4, objeto.getEndereco());
            stmt.setString(5, objeto.getDatanascimento());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    
    public boolean DeletePacienteBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_pacientes WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    
    public boolean UpdatePacienteBD(Paciente objeto) {

        String sql = "UPDATE tb_pacientes set nome = ? ,telefone = ? ,endereco = ? ,datanascimento = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setLong(2, objeto.getTelefone());
            stmt.setString(3, objeto.getEndereco());
            stmt.setString(4, objeto.getDatanascimento());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Paciente carregaPaciente(int id) {
        
        Paciente objeto = new Paciente();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_pacientes WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getLong("telefone"));
            objeto.setEndereco(res.getString("endereco"));
            objeto.setDatanascimento(res.getString("datanascimento"));

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
