package Model;


import java.util.*;
import DAO.PacienteDAO;
import java.sql.SQLException;

public class Paciente extends Pessoa {
    
    private String endereco;
    private String datanascimento;
     private final PacienteDAO dao;
    
    public Paciente(){
        this.dao = new PacienteDAO();
    }
    
    public Paciente(String endereco, String datanascimento){
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.dao = new PacienteDAO();
    }
    
    public Paciente(String endereco, String datanascimento, int id, String nome, long telefone){
        super(id, nome, telefone);
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.dao = new PacienteDAO();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Telefone: " + this.getTelefone()
                + "\n Endereço: " + this.getEndereco()
                + "\n Data de Nascimento:" + this.getDatanascimento()
                + "\n -----------";
    }
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    
    public boolean InsertPacienteBD(Paciente objeto) {
        dao.InsertPacienteBD(objeto);
        return true;
    }

    
    public boolean DeletePacienteBD(int id) {
        dao.DeletePacienteBD(id);
        return true;
    }

    
    public boolean UpdatePacienteBD(Paciente objeto) {
        dao.UpdatePacienteBD(objeto);
        return true;
    }

    
    public Paciente carregaPaciente(int id) {
        dao.carregaPaciente(id);
        return null;
    }

    
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}

