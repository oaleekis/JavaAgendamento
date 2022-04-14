package Model;


import DAO.AgendamentoDAO;
import java.util.*;
import java.sql.SQLException;

public class Agendamento extends Pessoa {
    
    private int id;
    private Paciente idpaciente;
    private long telefone;
    private String data;
    private String horario;
    private Medico idmedico;
     private final AgendamentoDAO dao;
    
    public Agendamento(){
        this.dao = new AgendamentoDAO();
    }
    
    public Agendamento(int id, Paciente idpaciente, long telefone, String data, String horario, Medico idmedico){
        
       this.id = id;
       this.idpaciente = idpaciente;
       this.telefone = telefone;
       this.data = data;
       this.horario = horario;
       this.idmedico = idmedico;   
        this.dao = new AgendamentoDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Medico getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Medico idmedico) {
        this.idmedico = idmedico;
    }
     @Override
    public String toString() {
        return this.getNome();
    }
    
    @Override
    public boolean equals(Object objeto) {
        try {

            Medico e = (Medico) objeto;
            if (this.id == e.getId()) {

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;

    }


    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    
    public boolean InsertAgendamentoBD(Agendamento objeto) {
        dao.InsertAgendamentoBD(objeto);
        return true;
    }

    
    public boolean DeleteAgendamentoBD(int id) {
        dao.DeleteAgendamentoBD(id);
        return true;
    }

    
    public boolean UpdateAgendamentoBD(Agendamento objeto) {
      
        dao.UpdateAgendamentoBD(objeto);
        return true;
    }

    
    public Agendamento carregaAgendamento(int id) {
        dao.carregaAgendamento(id);
        return null;
    }

     public Paciente getpaciente(String nome){
        return dao.retornapaciente(nome);
    }
    
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
    
    
}