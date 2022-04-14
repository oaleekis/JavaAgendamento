package Model;


import DAO.MedicoDAO;
import java.util.*;
import java.sql.SQLException;

public class Medico extends Pessoa {
    
    private String especialidade;
    private int crm;
    private String periodoatendimento;
     private final MedicoDAO dao;
    
    public Medico(){
        this.dao = new MedicoDAO();
    }
    
    public Medico(String especialidade, int crm, String periodoatendimento ){
        this.especialidade = especialidade;
        this.crm = crm;
        this.periodoatendimento = periodoatendimento;
        this.dao = new MedicoDAO();
    }
    
    public Medico(String especialidade, int crm, String periodoatendimento, int id, String nome, long telefone){
        super(id, nome, telefone);
        this.especialidade = especialidade;
        this.crm = crm;
        this.periodoatendimento = periodoatendimento;
        this.dao = new MedicoDAO();
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getPeriodoatendimento() {
        return periodoatendimento;
    }

    public void setPeriodoatendimento(String periodoatendimento) {
        this.periodoatendimento = periodoatendimento;
    }
    
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
    
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    
    public boolean InsertMedicoBD(Medico objeto) {
        dao.InsertMedicoBD(objeto);
        return true;
    }

    
    public boolean DeleteMedicoBD(int id) {
        dao.DeleteMedicoBD(id);
        return true;
    }

    
    public boolean UpdateMedicoBD(Medico objeto) {
       
        dao.UpdateMedicoBD(objeto);
        return true;
    }

    
    public Medico carregaMedico(int id) {
        dao.carregaMedico(id);
        return null;
    }

    
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
