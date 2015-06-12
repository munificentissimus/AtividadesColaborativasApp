package mnfc.com.br.atividadescolaborativasapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import mnfc.com.br.atividadescolaborativasapp.lib.Config;
import mnfc.com.br.atividadescolaborativasapp.lib.utils.ServiceResponse;
import mnfc.com.br.atividadescolaborativasapp.lib.utils.StringUtils;
import mnfc.com.br.atividadescolaborativasapp.modelo.Aluno;


public class LoginActivity extends Activity {

    private EditText editTextMatricula;
    private EditText editTextSenha;

    private Button buttonEntrar;
    private Button buttonRegistrar;
    private Context contextoAtual;
    private static LoginActivity parent;

    private Aluno alunoLogado;

    private final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contextoAtual = this;

        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        buttonEntrar.setOnClickListener(aoClicarEntrar);

        buttonRegistrar = (Button) findViewById(R.id.buttonRegistrar);

        editTextMatricula = (EditText) findViewById(R.id.editTextMatricula);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
    }

    private View.OnClickListener aoClicarEntrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (editTextMatricula.getText().length() == 0 || editTextSenha.getText().length() == 0){
                exibirMensagemCurta("Matrícula e senha obrigatórios");
            } else {
                //Chamar webservice de login
                Log.i(TAG, "Chamar webservice de login");
                new LogarTask().execute();

                //Receber o aluno e atribuir para aluno atual
                Log.i(TAG, "Receber o aluno atual");
                //Chamar activity da lista de atividades do aluno
                Log.i(TAG, "Receber o aluno atual");
            }
        }
   };

    private void exibirMensagemCurta(String mensagem){
        Toast.makeText(contextoAtual,mensagem,Toast.LENGTH_SHORT).show();
    }

    private class LogarTask extends AsyncTask<String,Void, ServiceResponse>{

        @Override
        protected ServiceResponse doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                String postURL = Config.getUrlApi() + "/login";
                HttpPost post = new HttpPost(postURL);
                post.setHeader("User-Agent", "Aplicacao cliente");
                post.setHeader("Content-type", "application/json");
                ArrayList<NameValuePair> parametros = new ArrayList<NameValuePair>();
                Log.i(TAG, "matricula: " + editTextMatricula.getText().toString());
                Log.i(TAG, "senha: " + editTextSenha.getText().toString());

                Aluno aluno = new Aluno();
                long matricula = editTextMatricula.getText().toString().isEmpty() ? 0 : Long.parseLong(editTextMatricula.getText().toString());
                aluno.setMatricula(matricula);
                aluno.setSenha(editTextSenha.getText().toString());


                //parametros.add(new BasicNameValuePair("matricula", editTextMatricula.getText().toString() ));
                //parametros.add(new BasicNameValuePair("senha", editTextSenha.getText().toString()));
                //UrlEncodedFormEntity ent = new UrlEncodedFormEntity(parametros, HTTP.UTF_8);

                StringEntity se;
                se = new StringEntity(new Gson().toJson(aluno, Aluno.class) , HTTP.UTF_8);
                post.setEntity(se);
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
            if (resposta.getStatusCode() == 200 || resposta.getStatusCode() == 201){
                //Ir para a lista de atividades do usuario
            }else {
                exibirMensagemCurta(resposta.getMensagem());
            }
        }
    }

}
