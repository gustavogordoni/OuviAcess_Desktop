package br.com.ouviacess.dao;

import br.com.ouviacess.dto.RequerimentosDTO;
import br.com.ouviacess.dto.AdministradorDTO;

import java.sql.*;

public class RequerimentosDAO {

    private int id_administrador;

    //AdministradorDTO administradorDTO = new AdministradorDTO(); //Cria um objeto carroDTO
    /**
     * Método construtor da classe RequerimentosDAO
     */
    public RequerimentosDAO() {
    }
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    /**
     * Método utilizado para inserir um objeto requerimentosDTO no banco de
     * dados
     *
     * @param requerimentosDTO, que vem da classe RequerimentosCTR
     * @return Um boolean
     */
    public boolean inserirRequerimentos(RequerimentosDTO requerimentosDTO, AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "INSERT INTO resposta (id_requerimento, id_administrador, resposta)" + "VALUES ( "
                    + "'" + requerimentosDTO.getId_requerimento() + ", "
                    + "'" + administradorDTO.getId_administrador() + ", "
                    + "'" + requerimentosDTO.getResposta() + "'";

            //System.out.println(comando);
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
    }//Fecha o método inserirRequerimentos

    /**
     * Método utilizado para excluir um objeto requerimentosDTO no banco de
     * dados
     *
     * @param requerimentosDTO que vem da classe RequerimentosCTR
     * @return Um boolean
     *
     */
    public boolean excluirRequerimentos(RequerimentosDTO requerimentosDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "DELETE FROM arquivo WHERE id_requerimento = " + requerimentosDTO.getId_requerimento() + "; ";
            comando += "DELETE FROM requerimento WHERE id_requerimento = " + requerimentosDTO.getId_requerimento();

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
    }//Fecha o método excluirRequerimento

    public boolean alterarRequerimentos(RequerimentosDTO requerimentosDTO, int id_administrador) {
        try {
            // Chama o método que está na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // Cria o Statement que é responsável por executar comandos no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            // Comando SQL que será executado no banco de dados
            String comando = "UPDATE requerimento SET "
                    + "situacao = '" + requerimentosDTO.getSituacao() + "', "
                    + "resposta = ?," // Usando ? para o valor da resposta
                    + "id_administrador = ? " // Usando ? para o valor do id_administrador
                    + "WHERE id_requerimento = ?"; // Usando ? para o valor do id_requerimento

            // Prepare a declaração com os parâmetros
            PreparedStatement preparedStatement = ConexaoDAO.con.prepareStatement(comando);
            preparedStatement.setString(1, requerimentosDTO.getResposta());
            preparedStatement.setInt(2, id_administrador);
            preparedStatement.setInt(3, requerimentosDTO.getId_requerimento());

            // Executa a declaração preparada
            preparedStatement.executeUpdate();

            // Dá um commit no banco de dados
            ConexaoDAO.con.commit();
            // Fecha a declaração
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            // Chama o método da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    private boolean verificaUsuario(String nomeUsuario) {
        if (nomeUsuario.equals("???")) {
            return false;
        } else {
            if (nomeUsuario != null && !nomeUsuario.isEmpty() && !nomeUsuario.equals("Nenhum usuário encontrado") && !nomeUsuario.equals("Não especificar usuário")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public ResultSet consultarRequerimentos(RequerimentosDTO requerimentosDTO, int opcao, String nomeUsuario) {

        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                // PREENCHE CAMPOS COM DADOS DO REQUERIMENTO
                case 1:
                    comando = "SELECT r.* "
                            + "FROM requerimento r "
                            + "WHERE r.id_requerimento = " + requerimentosDTO.getId_requerimento();
                    break;

                // FILTRO POR TITULO
                case 2:
                    comando = "SELECT r.* FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    comando += "WHERE r.titulo ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += " AND u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += "ORDER BY r.titulo";
                    break;

                // FILTRO POR SITUAÇÃO
                case 3:
                    comando = "SELECT r.* FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    comando += "WHERE r.situacao ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += " AND u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += "ORDER BY r.situacao";
                    break;

                // FILTRO POR TIPO
                case 4:
                    comando = "SELECT r.* "
                            + "FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    comando += "WHERE r.tipo ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += " AND u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += "ORDER BY r.tipo";
                    break;

                // FILTRO POR DATA
                case 5:
                    comando = "SELECT r.* FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    comando += "WHERE r.data ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += " AND u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += "ORDER BY TO_DATE(data, 'DD/MM/YYYY') ASC";
                    break;

                //  FILTRO POR ID REQUERIMENTO
                case 6:
                    comando = "SELECT r.* FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    if (requerimentosDTO.getPesquisaRequerimento().matches("\\d+")) {
                        comando += "WHERE r.id_requerimento = " + requerimentosDTO.getPesquisaRequerimento();

                        if (verificaUsuario(nomeUsuario)) {
                            comando += "AND u.nome = '" + nomeUsuario + "' ";
                        }
                    } else {
                        if (!requerimentosDTO.getPesquisaRequerimento().isEmpty()) {
                            comando = null;
                        }
                    }
                    comando += " ORDER BY r.id_requerimento";
                    break;

                //  NENHUM FILTRO (COM PESQUISA)    
                case 7:
                    String pesquisa = requerimentosDTO.getPesquisaRequerimento();
                    comando = "SELECT r.* "
                            + "FROM requerimento r ";

                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    // Verifique se a pesquisa é um número
                    if (pesquisa.matches("\\d+")) {
                        comando += "WHERE r.id_requerimento = " + pesquisa;
                    } else {
                        comando += "WHERE r.titulo ILIKE '%" + pesquisa + "%' ";
                    }

                    if (verificaUsuario(nomeUsuario)) {
                        comando += " AND u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += " OR r.situacao ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' "
                            + "OR r.tipo ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' "
                            + "OR r.data ILIKE '%" + requerimentosDTO.getPesquisaRequerimento() + "%' "
                            + " ORDER BY r.titulo";
                    break;

                //  NENHUM FILTRO (SEM PESQUISA)
                case 8:
                    comando = "SELECT r.* "
                            + "FROM requerimento r ";
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "INNER JOIN usuario u ON r.id_usuario = u.id_usuario ";
                    }
                    if (verificaUsuario(nomeUsuario)) {
                        comando += "WHERE u.nome = '" + nomeUsuario + "' ";
                    }
                    comando += "ORDER BY r.titulo";
                    break;
            }
            //Executa o comando SQL no banco de Dados
//            System.out.println("REQUERIMENTO");
//            System.out.println("OPÇÃO: " + opcao + "\nCOMANDO: " + comando + "\n");
            rs = stmt.executeQuery(comando);
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarRequerimentos

    public ResultSet consultarImagem(RequerimentosDTO requerimentosDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            String sql = "";
            if (opcao == 1) {
                sql = "SELECT a.* "
                        + "FROM requerimento r INNER JOIN usuario u "
                        + "ON r.id_usuario =  u.id_usuario "
                        + "INNER JOIN arquivo a "
                        + "ON r.id_requerimento =  a.id_requerimento "
                        + "WHERE a.id_requerimento = ?";
                pstmt = ConexaoDAO.con.prepareStatement(sql);
                pstmt.setInt(1, requerimentosDTO.getId_requerimento());
            }
            //Executa o comando SQL no banco de Dados
//            System.out.println("ARQUIVO");
//            System.out.println("OPÇÃO: " + opcao + "\nCOMANDO: " + sql + "\n");
            ResultSet rs = pstmt.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return rs;
        }
    }

}//Fecha a classe RequerimentosDAO
