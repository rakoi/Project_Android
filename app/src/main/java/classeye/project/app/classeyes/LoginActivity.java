package classeye.project.app.classeyes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import classeye.project.app.classeyes.Contracts.LoginContract;
import classeye.project.app.classeyes.Presenter.UserPresenter;
import classeye.project.app.classeyes.root.MyApp;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
@Inject
    LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.logintoolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);

//        presenter=new UserPresenter(this);
        ((MyApp)getApplication()).getApplicationComponent().inject(this);




    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getSavedCredentials();
        checkLoggedInStatus();
    }

    public void Login(View View) throws JSONException {

        final EditText regNo = (EditText) findViewById(R.id.regnuber);
        final EditText passwd = (EditText) findViewById(R.id.password);
        TextView warning = (TextView) findViewById(R.id.warning);



        if (regNo.getText().toString().equals("") || passwd.getText().toString().equals("")) {
            warning.setText("Fill in all fields");
        } else {
                warning.setText("");
                presenter.getInput(regNo.getText().toString(),passwd.getText().toString());
                loginUser();
          }
    }


    @Override
    public void checkSavedCredentials(HashMap hashMap) {
        if (hashMap!=null){
           // Toast.makeText(this,"NO HISTORY",Toast.LENGTH_SHORT).show();
            final EditText regNo = (EditText) findViewById(R.id.regnuber);
            final EditText passwd = (EditText) findViewById(R.id.password);

            regNo.setText(hashMap.get("admnumber").toString());
            passwd.setText(hashMap.get("password").toString());

        }
    }
    public void loginUser(){
        presenter.loginUser();
    }

   public void checkLoggedInStatus(){
        SharedPreferences sharedPreferences=getSharedPreferences("classeye",Context.MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",0);

        if (id!=0){
            startActivity(new Intent(this,MainActivity.class));
        }

   }

}