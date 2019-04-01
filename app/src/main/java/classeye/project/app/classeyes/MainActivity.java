package classeye.project.app.classeyes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import classeye.project.app.classeyes.Contracts.CheckinContract;
import classeye.project.app.classeyes.Dao.Attendance;
import classeye.project.app.classeyes.Presenter.CheckInPresenter;


public class MainActivity extends AppCompatActivity implements CheckinContract.View {

    public DrawerLayout drawerLayout;
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public PageAdapter pageAdapter;
    public CheckinContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar=findViewById(R.id.MainActivityToolBar);
        drawerLayout=findViewById(R.id.myDrawerLayout);
        tabLayout=findViewById(R.id.myTabLayout);
        viewPager=findViewById(R.id.myViewPager);

        presenter=new CheckInPresenter(this);



        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setTitle("Class Eye");

        SharedPreferences sp=getSharedPreferences("classeye", Context.MODE_PRIVATE);

        String fname=sp.getString("firstname","");
        String lname=sp.getString("lastname","");
        String admNo=sp.getString("admnumber","");

        TextView username=(TextView) findViewById(R.id.username);
        TextView admnumber=(TextView)findViewById(R.id.admnumber);
        username.setText(fname +" "+lname);
        admnumber.setText(admNo);


        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Chart"));
        tabLayout.addTab(tabLayout.newTab().setText("Records"));

        pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    drawerLayout.openDrawer(Gravity.START);

            }
        });

    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(MainActivity.this, "Scan Again", Toast.LENGTH_LONG).show();
            } else {
                presenter.passLessonName(result.getContents().toString());

             }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }



    }
    public void Logout(View view){
        SharedPreferences.Editor editor=getSharedPreferences("classeye", Context.MODE_PRIVATE).edit();
        editor.putInt("id",0);
        editor.apply();
        startActivity(new Intent(this,LoginActivity.class));


    }



    @Override
    public void showError(String error) {
        Toast.makeText(MainActivity.this,error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showResponse(Attendance attendance) {
        if (attendance==null){

            Toast.makeText(MainActivity.this,"Invalid", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(MainActivity.this,"Signed In", Toast.LENGTH_LONG).show();

            Button button=findViewById(R.id.checkIn);
            button.setEnabled(false);
        }
    }
}
