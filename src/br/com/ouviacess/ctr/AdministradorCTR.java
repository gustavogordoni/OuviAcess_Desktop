package br.com.ouviacess.ctr;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import java.sql.ResultSet;
import br.com.ouviacess.dto.AdministradorDTO;
import br.com.ouviacess.dao.AdministradorDAO;
import br.com.ouviacess.dao.ConexaoDAO;

public class AdministradorCTR {    
    AdministradorDAO administradorDAO = new AdministradorDAO();
    
    /**
     * Método construtor da classe
     */
    public AdministradorCTR() {
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirAdministrador da
     * classe AdministradorDAO
     *
     * @param administradorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (administradorDAO.inserirAdministrador(administradorDTO)) {
                return "Administrador Cadastrado com Sucesso!!!";
            } else {
                return "Administrador NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Cadastrado";
        }
    }//Fecha o método inserirAdministrador
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarAdministrador da
     * classe AdministradorDAO
     *
     * @param administradorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (administradorDAO.alterarAdministrador(administradorDTO)) {
                return "Administrador Alterado com Sucesso!!!";
            } else {
                return "Administrador NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Alterado!!!";
        }
    }//Fecha o método alterarAdministrador

    
    /**
     * Método utilizado para controlar o acesso ao método excluirAdministrador da
     * classe AdministradorDAO
     *
     * @param administradorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirAdministrador(AdministradorDTO administradorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (administradorDAO.excluirAdministrador(administradorDTO)) {
                return "Administrador Excluído com Sucesso!!!";
            } else {
                return "Administrador NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Administrador NÃO Excluído!!!";
        }
    }//Fecha o método excluirAdministrador
    
    
    /**
     * Método utilizado para controlar o acesso ao método consultarAdministrador da
     * classe AdministradorDAO
     *
     * @param administradorDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do produto
     */
    public ResultSet consultarAdministrador(AdministradorDTO administradorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = administradorDAO.consultarAdministrador(administradorDTO, opcao);

        return rs;
    }//Fecha o método consultarAdministrador

    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
       
}// FECHA A CLASSE
