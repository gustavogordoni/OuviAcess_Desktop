package br.com.ouviacess.ctr;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import java.sql.ResultSet;
import br.com.ouviacess.dto.UsuariosDTO;
import br.com.ouviacess.dao.UsuariosDAO;
import br.com.ouviacess.dao.ConexaoDAO;


public class UsuariosCTR {
    
    UsuariosDAO usuariosDAO = new UsuariosDAO();
    UsuariosDTO usuariosDTO = new UsuariosDTO();
    
    /**
     * Método construtor da classe
     */
    public UsuariosCTR() {
    }
    
    /**
     * Método utilizado para controlar o acesso ao método excluirUsuarios da
     * classe UsuariosDAO
     *
     * @param usuariosDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirUsuarios(UsuariosDTO usuariosDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (usuariosDAO.excluirUsuarios(usuariosDTO)) {
                return "Usuarios Excluído com Sucesso!!!";
            } else {
                return "Usuarios NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Usuarios NÃO Excluído!!!";
        }
    }//Fecha o método excluirUsuarios */
    
    
    /**
     * Método utilizado para controlar o acesso ao método consultarUsuarios da
     * classe UsuariosDAO
     *
     * @param usuariosDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do produto
     */
    public ResultSet consultarUsuarios(UsuariosDTO usuariosDTO, int opcao, String pesquisa) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = usuariosDAO.consultarUsuarios(usuariosDTO, opcao, pesquisa);

        return rs;
    }//Fecha o método consultarUsuarios

    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}
