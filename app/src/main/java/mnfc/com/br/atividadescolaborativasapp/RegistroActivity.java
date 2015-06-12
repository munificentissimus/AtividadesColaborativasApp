package mnfc.com.br.atividadescolaborativasapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

import mnfc.com.br.atividadescolaborativasapp.lib.Config;
import mnfc.com.br.atividadescolaborativasapp.lib.utils.ServiceResponse;
import mnfc.com.br.atividadescolaborativasapp.modelo.Aluno;


public class RegistroActivity extends Activity {

    private EditText editTextMatriculaRegistro;
    private EditText editTextNomeRegistro;
    private EditText editTextSenhaRegistro;

    private String strMatricula = editTextMatriculaRegistro.getText().toString();
    private String strNome = editTextNomeRegistro.getText().toString();
    private String strSenha =  editTextSenhaRegistro.getText().toString();


    SharedPreferences sharedpreferences;

    private Button buttonConfirmar;
    private Context contextoAtual;

    private final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        contextoAtual = this;

        buttonConfirmar = (Button) findViewById(R.id.buttonConfirmar);
        buttonConfirmar.setOnClickListener(aoClicarConfirmar);

        editTextMatriculaRegistro = (EditText) findViewById(R.id.editTextMatriculaRegistro);
        editTextNomeRegistro = (EditText) findViewById(R.id.editTextNomeRegistro);
        editTextSenhaRegistro = (EditText) findViewById(R.id.editTextSenhaRegistro);

        strMatricula = editTextMatriculaRegistro.getText().toString();
        strNome = editTextNomeRegistro.getText().toString();
        strSenha =  editTextSenhaRegistro.getText().toString();


        if (strMatricula.isEmpty() || strNome.isEmpty() || strSenha.isEmpty()){
            exibirMensagemCurta("Todos os campos devem ser preenchidos!");
        }


    }

    private View.OnClickListener aoClicarConfirmar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new RegistrarTaskAsync().execute();
        }
    };

    private class RegistrarTaskAsync extends AsyncTask<String,Void,ServiceResponse>{
        @Override
        protected ServiceResponse doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                String postURL = Config.getUrlApi() + "/alunos";
                HttpPost post = new HttpPost(postURL);
                post.setHeader("User-Agent", "Aplicacao cliente");
                post.setHeader("Content-type", "application/json");
                ArrayList<NameValuePair> parametros = new ArrayList<NameValuePair>();

                Aluno aluno = new Aluno();
                aluno.setMatricula(Long.parseLong(strMatricula));
                aluno.setSenha(strSenha);
                aluno.setNome(strNome);

                post.setEntity(new StringEntity(new Gson().toJson(aluno, Aluno.class) , HTTP.UTF_8));
                HttpResponse httpResponse = client.execute(post);
                HttpEntity resEntity = httpResponse.getEntity();
                final String _response = EntityUtils.toString(resEntity);
                return new Gson().fromJson(_response, ServiceResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ServiceResponse resposta) {
            Log.i(TAG, resposta.toString());
            if (resposta.getStatusCode() == 201){
                Aluno alunoRegistrado = (Aluno) resposta.getDados();
                exibirMensagemCurta("Aluno registrado com sucesso!");
                //Salva o token nas preferencias do usuario
                sharedpreferences = getSharedPreferences(Config.getPREFERENCES() , Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("token",alunoRegistrado.getToken() );
                editor.commit();
                //Retorna para a tela de login
                finish();
            }else {
                exibirMensagemCurta(resposta.getMensagem());
            }
        }
    }

    private void exibirMensagemCurta(String mensagem){
        Toast.makeText(contextoAtual, mensagem, Toast.LENGTH_SHORT).show();
    }
}
