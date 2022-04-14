package Control;

import Model.Agendamento;
import Model.Medico;
import Model.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoControl {

    private final Agendamento agendamento;

    public AgendamentoControl() {
        this.agendamento = new Agendamento();

    }

    public boolean Cadastrar(Paciente idpaciente, long telefone, String data, String horario, Medico idmedico) throws SQLException {

        int id = agendamento.maiorID() + 1;

        Agendamento objeto = new Agendamento(id, idpaciente, telefone, data, horario, idmedico);
        if (agendamento.InsertAgendamentoBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Editar(int id, Paciente idpaciente, long telefone, String data, String horario, Medico idmedico) {
        Agendamento objeto = new Agendamento(id, idpaciente, telefone, data, horario, idmedico);
        if (agendamento.UpdateAgendamentoBD(objeto)) {

            return true;
        } else {
            return false;
        }
    }

    public boolean Apagar(int id) {
        if (agendamento.DeleteAgendamentoBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Agendamento LoadAgendamento(int id) {

        return agendamento.carregaAgendamento(id);
    }

    public ArrayList getMinhaLista() {
        return agendamento.getMinhaLista();
    }

    public Paciente getpaciente(String nome) {
        return agendamento.getpaciente(nome);
    }

    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {

        ArrayList<Agendamento> minhalista = agendamento.getMinhaLista();
        int tamanho = minhalista.size();

        String MatrizAgendamentos[][] = new String[tamanho][7];
        for (int i = 0; i < tamanho; i++) {
            MatrizAgendamentos[i][0] = minhalista.get(i).getId() + "";
            MatrizAgendamentos[i][1] = minhalista.get(i).getIdpaciente().getId() + "";
            MatrizAgendamentos[i][2] = minhalista.get(i).getIdpaciente().getNome() + "";
            MatrizAgendamentos[i][3] = minhalista.get(i).getTelefone() + "";
            MatrizAgendamentos[i][4] = minhalista.get(i).getData();
            MatrizAgendamentos[i][5] = minhalista.get(i).getHorario();
            MatrizAgendamentos[i][6] = minhalista.get(i).getIdmedico().getNome() + "";
        }

        return MatrizAgendamentos;
    }

}
