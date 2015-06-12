package mnfc.com.br.atividadescolaborativasapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class RegistroActivity extends Activity {

    private EditText editTextMatriculaRegistro;
    private EditText editTextNomeRegistro;
    private EditText editTextSenhaRegistro;

    private Button buttonConfirmar;
    private Context contextoAtual;

    private final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        contextoAtual = this;

        buttonConfirmar = (Button) findViewById(R.id.buttonConfirmar);

        editTextMatriculaRegistro = (EditText) findViewById(R.id.editTextMatriculaRegistro);
        editTextNomeRegistro = (EditText) findViewById(R.id.editTextNomeRegistro);
        editTextSenhaRegistro = (EditText) findViewById(R.id.editTextSenhaRegistro);
    }


}
