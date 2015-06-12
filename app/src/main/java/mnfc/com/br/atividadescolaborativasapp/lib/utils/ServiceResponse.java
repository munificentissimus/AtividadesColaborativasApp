package mnfc.com.br.atividadescolaborativasapp.lib.utils;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class ServiceResponse {
    private int statusCode;
    private Object dados;
    private String mensagem;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }
}
