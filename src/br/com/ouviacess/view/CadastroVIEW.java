package br.com.ouviacess.view;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.ouviacess.dto.AdministradorDTO;
import br.com.ouviacess.ctr.AdministradorCTR;

public class CadastroVIEW extends javax.swing.JFrame {

    AdministradorDTO administradorDTO = new AdministradorDTO(); //Cria um objeto cadastroDTO
    AdministradorCTR administradorCTR = new AdministradorCTR(); //Cria um objeto cadastrorCTR

    ResultSet rs; //Variavel usada para preenchimeto da tabela e dos campos
    int gravar_alterar; //Variavel usada para saber se esta alterando o incluindo
    DefaultTableModel modelo_jtl_consultar_cad; //Variavel para guardar o modelo da tabela

    /**
     * Creates new form CadastroVIEW
     */
    public CadastroVIEW() {
        initComponents();

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
        // Impedir que a janela seja maximizada
        setResizable(false);
    }

//    public void setPosicao() {
//        //Dimension d = this.getDesktopPane().getSize();
//        //this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
//    }//Fecha método setPosicao()
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        inputDdd = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inputTelefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        inputSenha = new javax.swing.JPasswordField();
        jPanel14 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ouviacess/view/imagens/sign_up_ajustado.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Faça seu cadastro no sistema");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Nome completo: ");

        inputNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeActionPerformed(evt);
            }
        });

        try {
            inputDdd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("DDD:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Telefone:");

        try {
            inputTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelefoneActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email: (para efetuar login)  ");

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Senha: (para efetuar login)  ");

        inputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSenhaActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparMouseClicked(evt);
            }
        });
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparbtnLimparActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarbtnCadastrarActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginbtnAlterarRequerimento1MouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginbtnAlterarRequerimento1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnLimpar, btnLogin});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastrar, btnLimpar, btnLogin});

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(inputDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(inputEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel5)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputEmail, inputNome, inputSenha});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputDdd, inputTelefone});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputDdd, inputEmail, inputNome, inputSenha, inputTelefone});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginbtnAlterarRequerimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginbtnAlterarRequerimento1ActionPerformed
        this.dispose();
        new LoginVIEW().setVisible(true);
    }//GEN-LAST:event_btnLoginbtnAlterarRequerimento1ActionPerformed

    private void btnLoginbtnAlterarRequerimento1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginbtnAlterarRequerimento1MouseClicked

    }//GEN-LAST:event_btnLoginbtnAlterarRequerimento1MouseClicked

    private void btnCadastrarbtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarbtnCadastrarActionPerformed
        if (verificaPreenchimento()) {
            gravar();
            logar();
        }
    }//GEN-LAST:event_btnCadastrarbtnCadastrarActionPerformed

    private void btnLimparbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparbtnLimparActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnLimparbtnLimparActionPerformed

    private void inputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSenhaActionPerformed

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void inputTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelefoneActionPerformed

    private void inputNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNomeActionPerformed

    private void btnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseClicked

    }//GEN-LAST:event_btnLimparMouseClicked

    /**
     * Método utilizado para gravar os dados do administrador.
     */
    private void gravar() {
        try {
            administradorDTO.setNome(inputNome.getText());
            administradorDTO.setDdd(inputDdd.getText());
            administradorDTO.setTelefone(inputTelefone.getText());
            administradorDTO.setEmail(inputEmail.getText());
            administradorDTO.setSenha(inputSenha.getText());

            JOptionPane.showMessageDialog(null,
                    administradorCTR.inserirAdministrador(administradorDTO)
            );
        } catch (Exception e) {
            System.out.println("Erro ao Gravar os dados" + e.getMessage());
        }
    }//Fecha método gravar()    

    /**
     * Método utilizado para verificar se os campos estão preenchidos.
     *
     * @param não recebe parametro.
     * @return boolean false(campo não preenchido) true(campo preenchido).
     */
    private boolean verificaPreenchimento() {
        if (inputNome.getText().trim().isEmpty()) {
            showMessage("O campo Nome deve ser preenchido");
            inputNome.requestFocus();
            inputNome.setText("");
            return false;
        } else if (inputNome.getText().length() < 4 || inputNome.getText().length() > 150) {
            showMessage("O campo Nome deve ter entre 4 e 150 caracteres");
            inputNome.requestFocus();
            inputNome.setText("");
            return false;
        }

        String ddd = inputDdd.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        if (ddd.isEmpty() || ddd.length() != 2) {
            showMessage("O campo DDD deve conter exatamente 2 dígitos numéricos");
            inputDdd.requestFocus();
            inputDdd.setText("");
            return false;
        }

        String telefone = inputTelefone.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        if (telefone.isEmpty() || telefone.length() != 9) {
            showMessage("O campo Telefone deve conter exatamente 9 dígitos numéricos");
            inputTelefone.requestFocus();
            inputTelefone.setText("");
            return false;
        }

        if (inputEmail.getText().trim().isEmpty()) {
            showMessage("O campo Email deve ser preenchido");
            inputEmail.requestFocus();
            inputEmail.setText("");
            return false;
        } else if (inputEmail.getText().length() < 7 || inputEmail.getText().length() > 150) {
            showMessage("O campo Email deve ter entre 7 e 150 caracteres");
            inputEmail.requestFocus();
            inputEmail.setText("");
            return false;
        }

        if (new String(inputSenha.getPassword()).trim().isEmpty()) {
            showMessage("O campo Senha deve ser preenchido");
            inputSenha.requestFocus();
            inputSenha.setText("");
            return false;
        } else if (new String(inputSenha.getPassword()).length() < 3 || new String(inputSenha.getPassword()).length() > 150) {
            showMessage("O campo Senha deve ter entre 3 e 150 caracteres");
            inputSenha.requestFocus();
            inputSenha.setText("");
            return false;
        }
        
//        administradorCTR.consultarEmail(administradorDTO);
//        if () {
//           
//            inputSenha.requestFocus();
//            inputSenha.setText("");
//            return false;
//        }
        
        return true;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Método utilizado para logar o administrador.
     *
     * @param Não recebe parametro.
     */
    private void logar() {
        administradorDTO.setEmail(inputEmail.getText());
        administradorDTO.setSenha(String.valueOf(inputSenha.getPassword()));
        administradorDTO.setId_administrador(administradorCTR.logarAdministrador(administradorDTO));

        if (administradorDTO.getId_administrador() > 0) {
            this.dispose();
            new PrincipalVIEW(administradorDTO).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha\nIncorreto!");
        }
    }//Fecha método logar()

    /**
     * Método utilizado para limpar os campos da tela.
     */
    private void limpaCampos() {
        inputNome.setText("");
        inputDdd.setText("");
        inputTelefone.setText("");
        inputEmail.setText("");
        inputSenha.setText("");
    }//Fecha método limpaCampos()

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLogin;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFormattedTextField inputDdd;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputNome;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JFormattedTextField inputTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
