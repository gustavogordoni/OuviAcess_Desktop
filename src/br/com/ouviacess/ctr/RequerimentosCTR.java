package br.com.ouviacess.ctr;

/**
 * Importando as classes necessárias para trabalhar nesta classe
 */
import java.sql.ResultSet;
import br.com.ouviacess.dto.RequerimentosDTO;
import br.com.ouviacess.dao.RequerimentosDAO;
import br.com.ouviacess.dao.ConexaoDAO;



public class RequerimentosCTR {
    
    RequerimentosDAO requerimentosDAO = new RequerimentosDAO();
     
    /**
     * Método utilizado para controlar o acesso ao método alterarRequerimentos da
     * classe RequerimentosDAO
     *
     * @param requerimentosDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarRequerimentos(RequerimentosDTO requerimentosDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (requerimentosDAO.alterarRequerimentos(requerimentosDTO)) {
                return "Requerimentos Alterado com Sucesso!!!";
            } else {
                return "Requerimentos NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Requerimentos NÃO Alterado!!!";
        }
    }//Fecha o método alterarRequerimentos

    
    /**
     * Método utilizado para controlar o acesso ao método consultarRequerimentos da
     * classe RequerimentosDAO
     *
     * @param requerimentosDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do produto
     */
    public ResultSet consultarRequerimentos(RequerimentosDTO requerimentosDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = requerimentosDAO.consultarRequerimentos(requerimentosDTO, opcao);

        return rs;
    }//Fecha o método consultarRequerimentos

    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}
