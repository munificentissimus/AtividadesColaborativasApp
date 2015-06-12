package mnfc.com.br.atividadescolaborativasapp.modelo;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class Integrante {

    private int __v;
    private String _id;
    private long matricula;
    private String nome;

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

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Integrante that = (Integrante) o;

        return matricula == that.matricula;

    }

    @Override
    public int hashCode() {
        return (int) (matricula ^ (matricula >>> 32));
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "__v=" + __v +
                ", _id='" + _id + '\'' +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
