package br.com.ouviacess.dao;

import br.com.ouviacess.dto.AdministradorDTO;
import java.sql.*;

public class AdministradorDAO {

    /**
     * Método construtor da classe AdministradorDAO
     */
    public AdministradorDAO() {
    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto administradorDTO no banco de
     * dados
     *
     * @param administradorDTO, que vem da classe AdministradorCTR
     * @return Um boolean
     */
    public boolean inserirAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "INSERT INTO administrador (nome, email, senha, ddd, telefone)" + "VALUES ( "
                    + "'" + administradorDTO.getNome() + "', "
                    + "'" + administradorDTO.getEmail() + "', "
                    + "md5('" + administradorDTO.getSenha() + "'),"
                    + "'" + administradorDTO.getDdd() + "', "
                    + "'" + administradorDTO.getTelefone()
                    + "') ";

            //Executa o comando SQL no banco de Dados
            // System.out.println("ADMINISTRADOR");
            //System.out.println("OPÇÃO: default\nCOMANDO: " + comando + "'\n");
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirAdministrador

    /**
     * Método utilizado para excluir um objeto administradorDTO no banco de
     * dados
     *
     * @param administradorDTO que vem da classe AdministradorCTR
     * @return Um boolean
     */
    public boolean excluirAdministrador(AdministradorDTO administradorDTO) {
        try {
            // Chama o método que está na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // Desabilitar o auto commit para que as alterações ocorram em uma transação
            ConexaoDAO.con.setAutoCommit(false);
            // Atualizar os requerimentos associados ao administrador
            atualizarRequerimentos(administradorDTO.getId_administrador());
            // Comando SQL para excluir o administrador
            String comando = "DELETE FROM administrador WHERE id_administrador = ?";
            // Criar o PreparedStatement para evitar SQL Injection
            try (PreparedStatement preparedStatement = ConexaoDAO.con.prepareStatement(comando)) {
                // Configurar parâmetro
                preparedStatement.setInt(1, administradorDTO.getId_administrador());
                // Executar o comando SQL para excluir o administrador
                preparedStatement.executeUpdate();
            }
            // Commit da transação
            System.out.println("ADMINISTRADOR");
            System.out.println("COMANDO: " + comando + "'\n");
            ConexaoDAO.con.commit();

            return true;
        } catch (Exception e) {
            // Lidar com exceções
            e.printStackTrace();
            return false;
        } finally {
            // Chama o método da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    private void atualizarRequerimentos(int idAdministrador) throws SQLException {
        // Comando SQL para atualizar os requerimentos associados ao administrador
        String sqlUpdateRequerimentos = "UPDATE requerimento SET id_administrador = NULL WHERE id_administrador = ?";
        // Criar o PreparedStatement para evitar SQL Injection
        try (PreparedStatement preparedStatement = ConexaoDAO.con.prepareStatement(sqlUpdateRequerimentos)) {
            // Configurar parâmetro
            preparedStatement.setInt(1, idAdministrador);
            // Executar a atualização dos requerimentos
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Método utilizado para alterar um objeto administradorDTO no banco de
     * dados
     *
     * @param administradorDTO, que vem da classe AdministradorCTR
     * @return Um boolean
     */
    public boolean alterarAdministrador(AdministradorDTO administradorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "UPDATE administrador SET "
                            + "nome = '" + administradorDTO.getNome() + "', "
                            + "email = '" + administradorDTO.getEmail() + "', "
                            + "ddd = '" + administradorDTO.getDdd() + "', "
                            + "telefone = '" + administradorDTO.getTelefone() + "' "
                            + "WHERE id_administrador = " + administradorDTO.getId_administrador();

                    break;
                case 2:
                    comando = "UPDATE administrador SET "
                            + "senha = md5('" + administradorDTO.getSenha() + "')"
                            + "WHERE id_administrador = " + administradorDTO.getId_administrador();
                    break;
            }
            //Executa o comando SQL no banco de Dados
            ///System.out.println("ADMINISTRADOR");
            ///System.out.println("OPÇÃO: " + opcao + "\nCOMANDO: " + comando + "'\n");
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarAdministrador

    /**
     * Método utilizado para consultar um objeto administradorDTO no banco de
     * dados
     *
     * @param administradorDTO, que vem da classe AdministradorCTR
     * @param opcao, que vem da classe AdministradorCTR
     * @return Um ResultSet com os dados do administrador
     */
    public ResultSet consultarAdministrador(AdministradorDTO administradorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT a.* "
                            + "FROM administrador a "
                            + "WHERE a.id_administrador = " + administradorDTO.getId_administrador();

                    break;
                case 2:
                   comando = "SELECT a.* "
                            + "FROM administrador a "
                            + "WHERE a.email = '" + administradorDTO.getEmail()+ "'";
                    break;
            }
            //Executa o comando SQL no banco de Dados
            System.out.println("ADMINISTRADOR");
            System.out.println("OPÇÃO: " + opcao + "\nCOMANDO: " + comando + "\n");
            rs = stmt.executeQuery(comando);
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarAdministrador

    public int logarAdministrador(AdministradorDTO administradorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT a.id_administrador "
                    + "FROM administrador a "
                    + "WHERE a.email = '" + administradorDTO.getEmail() + "'"
                    + " AND a.senha = md5('" + administradorDTO.getSenha() + "')";

            rs = null;
            //System.out.println("ADMINISTRADOR - LOGIN");
            //System.out.println("OPÇÃO: default \nCOMANDO: " + comando + "'\n");            
            rs = stmt.executeQuery(comando);
            if (rs.next()) {
                return rs.getInt("id_administrador");
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método logarUsuario

}//Fecha a classe AdministradorDAO
