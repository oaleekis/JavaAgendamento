
package View;

import Control.PacienteControl;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;



public class CadastroPaciente extends javax.swing.JFrame {

    private PacienteControl controlador; 
    private Date Date;
    
    
     
    public CadastroPaciente() {
        initComponents();
        
        this.controlador = new PacienteControl(); 
        this.carregaTabela();
        
        
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        b_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_endereco = new javax.swing.JTextField();
        t_telefone = new javax.swing.JTextField();
        t_nome = new javax.swing.JTextField();
        b_novo1 = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        b_editar1 = new javax.swing.JButton();
        t_date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Cadastro de Pacientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePacientes.setAutoCreateRowSorter(true);
        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Telefone", "Endere??o", "Data Nasc."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePacientes.setGridColor(new java.awt.Color(255, 255, 255));
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, 505, 170));

        b_excluir.setBackground(new java.awt.Color(0, 204, 153));
        b_excluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b_excluir.setForeground(new java.awt.Color(255, 255, 255));
        b_excluir.setText("Excluir");
        b_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluirActionPerformed(evt);
            }
        });
        getContentPane().add(b_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 90, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endere??o:");

        jLabel5.setText("Data de");

        jLabel6.setText("Nascimento:");

        t_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nomeActionPerformed(evt);
            }
        });

        b_novo1.setBackground(new java.awt.Color(0, 204, 153));
        b_novo1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        b_novo1.setForeground(new java.awt.Color(255, 255, 255));
        b_novo1.setText("Novo");
        b_novo1.setMaximumSize(new java.awt.Dimension(73, 25));
        b_novo1.setMinimumSize(new java.awt.Dimension(73, 25));
        b_novo1.setPreferredSize(new java.awt.Dimension(73, 25));
        b_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_novo1ActionPerformed(evt);
            }
        });

        b_cancelar.setBackground(new java.awt.Color(0, 204, 153));
        b_cancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_editar1.setBackground(new java.awt.Color(0, 204, 153));
        b_editar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        b_editar1.setForeground(new java.awt.Color(255, 255, 255));
        b_editar1.setText("Editar");
        b_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(21, 21, 21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_endereco)
                            .addComponent(t_nome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(t_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_date, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addGap(99, 99, 99))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(b_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(t_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(t_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_novo1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_cancelar)
                        .addComponent(b_editar1)))
                .addGap(33, 33, 33))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, 500, 230));

        jLabel1.setText("Paciente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/medicina11.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nomeActionPerformed
       
    }//GEN-LAST:event_t_nomeActionPerformed

    private void b_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluirActionPerformed
     try {
            
            int id = 0;
            if (this.jTablePacientes.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Paciente para APAGAR");
            } else {
                id = Integer.parseInt(this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 0).toString());
            }

            
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Paciente ?");

            if (resposta_usuario == 0) {

               
                if (this.controlador.Apagar(id)) {

                   
                    this.t_nome.setText("");
                    this.t_telefone.setText("");
                    this.t_endereco.setText("");
                     this.t_date.setDate(null);
                     
                    
                    JOptionPane.showMessageDialog(rootPane, "Paciente Apagado com Sucesso!");

                }

            }

            System.out.println(this.controlador.getMinhaLista().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            
            carregaTabela();
        }
    }//GEN-LAST:event_b_excluirActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
                    this.t_nome.setText("");
                    this.t_telefone.setText("");
                    this.t_endereco.setText("");
                    this.t_date.setDate(null);
                    
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_novo1ActionPerformed
       
       
        try {
            
            String nome = "";
            String datanascimento ="";
            String endereco = "";
            long telefone = 0;
            
            if (this.t_nome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.t_nome.getText();
            }

            if (this.t_telefone.getText().length() <= 0) {
                throw new Mensagens("Telefone deve ser n??mero e maior que zero.");
            } else {
                telefone = Long.parseLong(this.t_telefone.getText());
            }

            if (this.t_endereco.getText().length() < 2) {
                throw new Mensagens("Endere??o deve conter ao menos 2 caracteres.");
            } else {
                endereco = this.t_endereco.getText();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(t_date.getDate());
          
            
            datanascimento = date;
           

           
            
            if (this.controlador.Cadastrar(endereco, datanascimento, nome, telefone)) {
                JOptionPane.showMessageDialog(rootPane, "Paciente Cadastrado com Sucesso!");
                
           
                
                this.t_nome.setText("");
                this.t_telefone.setText("");
                this.t_endereco.setText("");
                this.t_date.setDate(null);
               


            }

           

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n??mero.");
        } catch (SQLException ex) {
        
        } 
            carregaTabela();
    }//GEN-LAST:event_b_novo1ActionPerformed

    private void b_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editar1ActionPerformed
       try {
            
            int id = 0;
            String nome = "";
            long telefone = 0;
            String endereco = "";
           String datanascimento = "";
            
            if (this.t_nome.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.t_nome.getText();
            }

            if (this.t_telefone.getText().length() <= 0) {
                throw new Mensagens("Telefone deve ser n??mero e maior que zero.");
            } else {
                telefone = Long.parseLong(this.t_telefone.getText());
            }

            if (this.t_endereco.getText().length() < 2) {
                throw new Mensagens("Endere??o deve conter ao menos 2 caracteres.");
            } else {
                endereco = this.t_endereco.getText();
            }
           

            if (this.jTablePacientes.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Paciente para Alterar");
            } else {
                id = Integer.parseInt(this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 0).toString());
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(t_date.getDate());
            
            datanascimento = date;

            
            if (this.controlador.Editar(endereco, datanascimento, id, nome, telefone)) {

               
                this.t_nome.setText("");
                this.t_telefone.setText("");
                this.t_endereco.setText("");
                this.t_date.setDate(null);
                
                
                JOptionPane.showMessageDialog(rootPane, "Paciente Alterado com Sucesso!");

            }
            System.out.println(this.controlador.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n??mero.");
        } finally {
            carregaTabela(); 
        }
    }//GEN-LAST:event_b_editar1ActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked
          if (this.jTablePacientes.getSelectedRow() != -1) {

            String nome = this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 1).toString();
            String telefone = this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 2).toString();
            String endereco = this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 3).toString();
            String datanascimento = this.jTablePacientes.getValueAt(this.jTablePacientes.getSelectedRow(), 4).toString();
            

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
              try {
                  Date =sdf.parse(datanascimento);
              } catch (ParseException ex) {
                  Logger.getLogger(CadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
              }
            
            this.t_nome.setText(nome);
            this.t_telefone.setText(telefone);
            this.t_endereco.setText(endereco);
            this.t_date.setDate(Date);
            
            

        }
    }//GEN-LAST:event_jTablePacientesMouseClicked

   public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTablePacientes.getModel();
        modelo.setNumRows(0);
        
        

        String linhasMatriz[][] = controlador.getMinhaMatrizTexto();
        for (int i = 0; i < linhasMatriz.length; i++) {
            modelo.addRow(
                    
            new Object[]{
                linhasMatriz[i][0],
                linhasMatriz[i][1],
                linhasMatriz[i][2],
                linhasMatriz[i][3],
                linhasMatriz[i][4]
             }
            
            
            );

        }


    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_editar1;
    private javax.swing.JButton b_excluir;
    private javax.swing.JButton b_novo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacientes;
    private com.toedter.calendar.JDateChooser t_date;
    private javax.swing.JTextField t_endereco;
    private javax.swing.JTextField t_nome;
    private javax.swing.JTextField t_telefone;
    // End of variables declaration//GEN-END:variables

  
}
