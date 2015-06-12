package mnfc.com.br.atividadescolaborativasapp.modelo;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class Contribuicao {
    private int __v;
    private String _id;
    private String nomeArquivo;
    private String caminhoArquivo;
    private String mimetype;
    private long postadoPorMatricula;
    private String postadoPorNome;

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public long getPostadoPorMatricula() {
        return postadoPorMatricula;
    }

    public void setPostadoPorMatricula(long postadoPorMatricula) {
        this.postadoPorMatricula = postadoPorMatricula;
    }

    public String getPostadoPorNome() {
        return postadoPorNome;
    }

    public void setPostadoPorNome(String postadoPorNome) {
        this.postadoPorNome = postadoPorNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contribuicao that = (Contribuicao) o;

        if (nomeArquivo != null ? !nomeArquivo.equals(that.nomeArquivo) : that.nomeArquivo != null)
            return false;
        return !(caminhoArquivo != null ? !caminhoArquivo.equals(that.caminhoArquivo) : that.caminhoArquivo != null);

    }

    @Override
    public int hashCode() {
        int result = nomeArquivo != null ? nomeArquivo.hashCode() : 0;
        result = 31 * result + (caminhoArquivo != null ? caminhoArquivo.hashCode() : 0);
        return result;
    }
}
