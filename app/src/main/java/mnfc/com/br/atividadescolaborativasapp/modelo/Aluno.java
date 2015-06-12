package mnfc.com.br.atividadescolaborativasapp.modelo;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class Aluno {

    private String _id;
    private long matricula;
    private String token;
    private String senha;
    private String nome;
    private int __v;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return matricula == aluno.matricula;

    }

    @Override
    public int hashCode() {
        return (int) (matricula ^ (matricula >>> 32));
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "_id='" + _id + '\'' +
                ", matricula='" + matricula + '\'' +
                ", senha='" + senha + '\'' +
                ", token='" + token + '\'' +
                ", __v=" + __v +
                '}';
    }
}
