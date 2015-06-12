package mnfc.com.br.atividadescolaborativasapp.modelo;

import java.util.List;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class Atividade {

    private int __v;
    private String _id;
    private String atividade;
    private String dataInicio;
    private String dataFim;
    private List<Contribuicao> contribuicoes;
    private List<Integrante> integrantes;

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

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public List<Contribuicao> getContribuicoes() {
        return contribuicoes;
    }

    public void setContribuicoes(List<Contribuicao> contribuicoes) {
        this.contribuicoes = contribuicoes;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade1 = (Atividade) o;

        return !(atividade != null ? !atividade.equals(atividade1.atividade) : atividade1.atividade != null);

    }

    @Override
    public int hashCode() {
        return atividade != null ? atividade.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "__v=" + __v +
                ", _id='" + _id + '\'' +
                ", atividade='" + atividade + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", contribuicoes=" + contribuicoes +
                ", integrantes=" + integrantes +
                '}';
    }
}
