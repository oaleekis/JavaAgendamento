package Control;

import Model.Medico;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoControl {

    private final Medico medico;

    public MedicoControl() {
        this.medico = new Medico();
        this.getMedicos();
    }

    public boolean Cadastrar(String especialidade, int crm, String periodoatendimento, String nome, long telefone) throws SQLException {

        int id = medico.maiorID() + 1;
        Medico objeto = new Medico(especialidade, crm, periodoatendimento, id, nome, telefone);
        if (medico.InsertMedicoBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Editar(String especialidade, int crm, String periodoatendimento, int id, String nome, long telefone) {
        Medico objeto = new Medico(especialidade, crm, periodoatendimento, id, nome, telefone);
        if (medico.UpdateMedicoBD(objeto)) {
           
            return true;
        } else {
            return false;
        }
    }

    public boolean Apagar(int id) {
        if (medico.DeleteMedicoBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Medico LoadMedico(int id) {

        return medico.carregaMedico(id);
    }

    public ArrayList getMinhaLista() {
        return medico.getMinhaLista();
    }

    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {

        ArrayList<Medico> minhalista = medico.getMinhaLista();
        int tamanho = minhalista.size();

        String MatrizMedicos[][] = new String[tamanho][6];
        for (int i = 0; i < tamanho; i++) {
            MatrizMedicos[i][0] = minhalista.get(i).getId() + "";
            MatrizMedicos[i][1] = minhalista.get(i).getNome();
            MatrizMedicos[i][2] = minhalista.get(i).getTelefone() + "";
            MatrizMedicos[i][3] = minhalista.get(i).getEspecialidade();
            MatrizMedicos[i][4] = minhalista.get(i).getCrm() + "";
            MatrizMedicos[i][5] = minhalista.get(i).getPeriodoatendimento();
        }

        return MatrizMedicos;
    }

    @SuppressWarnings("unchecked")
    public String[] getMedicos() {

        ArrayList<Medico> listamedicos = medico.getMinhaLista();
        int tamanho = listamedicos.size();

        String VetorMedicos[] = new String[tamanho];
        for (int i = 0; i < tamanho; i++) {
            VetorMedicos[i] = listamedicos.get(i).getNome();

        }

        return VetorMedicos;
    }

}
