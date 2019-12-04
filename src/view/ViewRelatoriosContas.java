/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.ControllerConta;
import controller.ControllerVendas;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelConta;
import util.BLDatas;

/**
 *
 * @author Administrador
 */
public class ViewRelatoriosContas extends javax.swing.JFrame {

    /**
     * Creates new form ViewRelatoriosContas
     */
    public ViewRelatoriosContas() {
        initComponents();
        this.jdDataDia.setDate(new java.util.Date());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrbPagar = new javax.swing.JRadioButton();
        jrbReceber = new javax.swing.JRadioButton();
        jrbRecebidas = new javax.swing.JRadioButton();
        jrbPagas = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jrbTodas = new javax.swing.JRadioButton();
        jtbData = new javax.swing.JRadioButton();
        jbCancelar = new javax.swing.JButton();
        jbGerarRelatorio = new javax.swing.JButton();
        jdDataDia = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de contas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione a conta"));

        buttonGroup1.add(jrbPagar);
        jrbPagar.setSelected(true);
        jrbPagar.setText("Contas a pagar");

        buttonGroup1.add(jrbReceber);
        jrbReceber.setText("Contas a receber");

        buttonGroup1.add(jrbRecebidas);
        jrbRecebidas.setText("Contas recebidas");

        buttonGroup1.add(jrbPagas);
        jrbPagas.setText("Contas pagas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbPagar)
                    .addComponent(jrbPagas))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbRecebidas)
                    .addComponent(jrbReceber))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagar)
                    .addComponent(jrbReceber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagas)
                    .addComponent(jrbRecebidas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione a forma"));

        buttonGroup2.add(jrbTodas);
        jrbTodas.setText("Todas");

        buttonGroup2.add(jtbData);
        jtbData.setSelected(true);
        jtbData.setText("Data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jtbData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbTodas)
                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbData)
                    .addComponent(jrbTodas))
                .addGap(41, 41, 41))
        );

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/No.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Report.png"))); // NOI18N
        jbGerarRelatorio.setText("Gerar relatório");
        jbGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setText("Preencher a data para usar as formas de data e mês");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGerarRelatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jdDataDia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jdDataDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGerarRelatorio))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarRelatorioActionPerformed
        ControllerConta controllerConta = new ControllerConta();
        ModelConta modelConta = new ModelConta();
        BLDatas bl = new BLDatas();
        if (jtbData.isSelected()) {
            if (jrbReceber.isSelected()) {
                modelConta.setTipoConta("RECEBER");
                modelConta.setSituacao(0);
                try {
                    modelConta.setPagamento(bl.converterDataParaDateUS(bl.converterDataParaDateUS(jdDataDia.getDate())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                controllerConta.gerarRelatorioContasReceberDATA(modelConta);
            } else if (jrbRecebidas.isSelected()) {
                modelConta.setTipoConta("RECEBER");
                modelConta.setSituacao(1);
                try {
                    modelConta.setPagamento(bl.converterDataParaDateUS(bl.converterDataParaDateUS(jdDataDia.getDate())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                controllerConta.gerarRelatorioContasReceberDATA(modelConta);
            }
            if (jrbPagar.isSelected()) {
                modelConta.setTipoConta("PAGAR");
                modelConta.setSituacao(0);
                try {
                    modelConta.setPagamento(bl.converterDataParaDateUS(bl.converterDataParaDateUS(jdDataDia.getDate())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                controllerConta.gerarRelatorioContasPagarDATA(modelConta);
            } else if (jrbPagas.isSelected()) {
                modelConta.setTipoConta("PAGAR");
                modelConta.setSituacao(1);
                try {
                    modelConta.setPagamento(bl.converterDataParaDateUS(bl.converterDataParaDateUS(jdDataDia.getDate())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                controllerConta.gerarRelatorioContasPagarDATA(modelConta);
            }
            

        } else if (jrbTodas.isSelected()) {
            //relatório de todas as contas receber
            if (jrbReceber.isSelected()) {
                modelConta.setTipoConta("RECEBER");
                modelConta.setSituacao(0);
                controllerConta.gerarRelatorioContasReceberTODAS(modelConta);
            } else if (jrbRecebidas.isSelected()) {
                modelConta.setTipoConta("RECEBER");
                modelConta.setSituacao(1);
                controllerConta.gerarRelatorioContasReceberTODAS(modelConta);
            }
            //relatório de todas contas pagar
            if (jrbPagar.isSelected()) {
                modelConta.setTipoConta("PAGAR");
                modelConta.setSituacao(0);
                controllerConta.gerarRelatorioContasPagarTODAS(modelConta);
            } else if (jrbPagas.isSelected()) {
                modelConta.setTipoConta("PAGAR");
                modelConta.setSituacao(1);
                controllerConta.gerarRelatorioContasPagarTODAS(modelConta);
            }
        }
    }//GEN-LAST:event_jbGerarRelatorioActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewRelatoriosContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRelatoriosContas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGerarRelatorio;
    private com.toedter.calendar.JDateChooser jdDataDia;
    private javax.swing.JRadioButton jrbPagar;
    private javax.swing.JRadioButton jrbPagas;
    private javax.swing.JRadioButton jrbReceber;
    private javax.swing.JRadioButton jrbRecebidas;
    private javax.swing.JRadioButton jrbTodas;
    private javax.swing.JRadioButton jtbData;
    // End of variables declaration//GEN-END:variables
}
