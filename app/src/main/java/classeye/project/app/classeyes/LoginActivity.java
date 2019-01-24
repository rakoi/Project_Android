package classeye.project.app.classeyes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar=findViewById(R.id.logintoolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);



    }
    public void Login(View View){

      startActivity(new Intent(this,MainActivity.class));
    }
}
