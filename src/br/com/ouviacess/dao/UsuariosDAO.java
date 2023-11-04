package br.com.ouviacess.dao;

import br.com.ouviacess.dto.UsuariosDTO;
import java.sql.*;

public class UsuariosDAO {

    /**
     * Método construtor da classe UsuariosDAO
     */
    public UsuariosDAO() {
    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para excluir um objeto usuariosDTO no banco de dados
     *
     * @param usuariosDTO que vem da classe UsuariosCTR
     * @return Um boolean
     */
    public boolean excluirUsuarios(UsuariosDTO usuariosDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "DELETE FROM arquivo "
                    + "WHERE id_requerimento IN (SELECT id_requerimento FROM requerimento WHERE id_usuario = " + usuariosDTO.getId_usuario() + "); "
                    + "DELETE FROM requerimento "
                    + "WHERE id_usuario = " + usuariosDTO.getId_usuario() + "; "
                    + "DELETE FROM usuario "
                    + "WHERE id_usuario = " + usuariosDTO.getId_usuario();

            System.out.println("USUÁRIO");
            System.out.println("COMANDO: " + comando + "'\n");

            //Executa o comando SQL no banco de Dados
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
    }//Fecha o método excluirUsuarios

    /**
     * Método utilizado para consultar um objeto usuariosDTO no banco de dados
     *
     * @param usuariosDTO, que vem da classe UsuariosCTR
     * @param opcao, que vem da classe UsuariosCTR
     * @return Um ResultSet com os dados do usuarios
     */
    public ResultSet consultarUsuarios(UsuariosDTO usuariosDTO, int opcao, String pesquisa) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT u.* "
                            + "FROM usuario u "
                            + "WHERE nome ILIKE '%" + pesquisa + "%' "
                            + "ORDER BY u.id_usuario";
                    break;
                case 2:
                    comando = "SELECT u.* "
                            + "FROM usuario u ";
                    if (pesquisa.matches("\\d+")) {
                        comando += "WHERE id_usuario = " + pesquisa;
                    } else {
                        if (pesquisa.isEmpty()) {
                        } else {
                            comando = null;
                        }
                    }
                    break;
                case 3:
                    comando = "SELECT u.* "
                            + "FROM usuario u ";
                    if (pesquisa.matches("\\d+")) {
                        comando += "WHERE id_usuario = " + pesquisa;
                    } else {
                        comando += "WHERE nome ILIKE '%" + pesquisa + "%' ";
                    }
//                    }
                    break;
            }
            //Executa o comando SQL no banco de Dados
            System.out.println("USUÁRIO");
            System.out.println("OPÇÃO: " + opcao + "\nCOMANDO: " + comando + "\n");
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarUsuarios

}//Fecha a classe UsuariosDAO
