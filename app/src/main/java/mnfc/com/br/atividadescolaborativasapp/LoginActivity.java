package mnfc.com.br.atividadescolaborativasapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    private EditText editTextMatricula;
    private EditText editTextSenha;

    private Button buttonEntrar;
    private Button buttonRegistrar;
    private Context contextoAtual;

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
                //Receber o aluno e atribuir para aluno atual
                Log.i(TAG, "Receber o aluno atual");
                //Chamar activity da lista de atividades do aluno
                Log.i(TAG, "Receber o aluno atual");
            }
        }
    };


}
