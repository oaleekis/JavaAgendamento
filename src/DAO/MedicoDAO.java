 package DAO;

import Model.Medico;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MedicoDAO {

    public static ArrayList<Medico> MinhaLista = new ArrayList<Medico>();
    
   

    public MedicoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_medicos");
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
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_medicos");
            while (res.next()) {

                String especialidade = res.getString("especialidade");
                int crm = res.getInt("crm");
                String periodoatendimento = res.getString("periodoatendimento");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                long telefone = res.getLong("telefone");

                Medico objeto = new Medico(especialidade, crm, periodoatendimento , id, nome, telefone);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    
    public boolean InsertMedicoBD(Medico objeto) {
        String sql = "INSERT INTO tb_medicos(id,nome,telefone,especialidade, crm, periodoatendimento) VALUES(?, ?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setLong(3, objeto.getTelefone());
            stmt.setString(4, objeto.getEspecialidade());
            stmt.setInt(5, objeto.getCrm());
            stmt.setString(6, objeto.getPeriodoatendimento());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    
    public boolean DeleteMedicoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_medicos WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    
    public boolean UpdateMedicoBD(Medico objeto) {

        String sql = "UPDATE tb_medicos set nome = ? ,telefone = ? ,especialidade = ? ,crm = ? ,periodoatendimento = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setLong(2, objeto.getTelefone());
            stmt.setString(3, objeto.getEspecialidade());
            stmt.setInt(4, objeto.getCrm());
            stmt.setString(5, objeto.getPeriodoatendimento());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println(objeto.toString());
            throw new RuntimeException(erro);
        }

    }
    

    public Medico carregaMedico(int id) {
        
        Medico objeto = new Medico();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_medicos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getLong("telefone"));
            objeto.setEspecialidade(res.getString("especialidade"));
            objeto.setCrm(res.getInt("crm"));
            objeto.setPeriodoatendimento(res.getString("periodoatendimento"));

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
    
}
