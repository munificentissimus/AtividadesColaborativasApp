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
                Toast.makeText(contextoAtual,"Matrícula e senha obrigatórios",Toast.LENGTH_SHORT).show();
            } else {
                //Chamar webservice de login
                Log.i(TAG, "Chamar webservice de login");
                Thread thread = new Thread()
                {
                    @Override
                    public void run() {
                        try {
                            HttpClient client = new DefaultHttpClient();
                            String postURL = Config.getUrlApi() + "/login";
                            HttpPost post = new HttpPost(postURL);
                            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("matricula", editTextMatricula.getText().toString() ));
                            params.add(new BasicNameValuePair("senha", editTextSenha.getText().toString()));
                            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                            post.setEntity(ent);
                            HttpResponse responsePOST = client.execute(post);
                            HttpEntity resEntity = responsePOST.getEntity();
                            String _response = EntityUtils.toString(resEntity);
                            if (responsePOST.getStatusLine().getStatusCode() == 200  ){
                                ServiceResponse sr = new Gson().fromJson(_response,ServiceResponse.class);
                                Toast.makeText(getApplicationContext() ,sr.getMensagem(),Toast.LENGTH_SHORT).show();
                            } else {
                                alunoLogado = new Gson().fromJson(_response,Aluno.class);
                                Toast.makeText(getApplicationContext(),"Login efetuado com sucesso",Toast.LENGTH_SHORT).show();
                            }

                            Log.e("XXX",_response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();

                //Receber o aluno e atribuir para aluno atual
                Log.i(TAG, "Receber o aluno atual");
                //Chamar activity da lista de atividades do aluno
                Log.i(TAG, "Receber o aluno atual");
            }
        }
    };

}
