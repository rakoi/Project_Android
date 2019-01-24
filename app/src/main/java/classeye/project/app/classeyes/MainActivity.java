package classeye.project.app.classeyes;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.MainActivityToolBar);
        drawerLayout=findViewById(R.id.myDrawerLayout);
        tabLayout=findViewById(R.id.myTabLayout);
        viewPager=findViewById(R.id.myViewPager);


        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setTitle("Class Eye");



        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Sign In"));
        tabLayout.addTab(tabLayout.newTab().setText("Extra"));
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
}
