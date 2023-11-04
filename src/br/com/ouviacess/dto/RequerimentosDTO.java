package br.com.ouviacess.dto;

public class RequerimentosDTO {
    private String resposta, situacao, pesquisaRequerimento, pesquisaUsuario;
    private int id_requerimento;

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPesquisaRequerimento() {
        return pesquisaRequerimento;
    }

    public void setPesquisaRequerimento(String pesquisaRequerimento) {
        this.pesquisaRequerimento = pesquisaRequerimento;
    }

    public String getPesquisaUsuario() {
        return pesquisaUsuario;
    }

    public void setPesquisaUsuario(String pesquisaUsuario) {
        this.pesquisaUsuario = pesquisaUsuario;
    }

    public int getId_requerimento() {
        return id_requerimento;
    }

    public void setId_requerimento(int id_requerimento) {
        this.id_requerimento = id_requerimento;
    }    
    
}
