package yop.wikitec.wikitec;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Home_menu:
                    Intent home_int = new Intent(getApplicationContext(), home.class);
                    startActivity(home_int);
                    finish();
                    return true;
                case R.id.Library_menu:

                    return true;
                case R.id.More_menu:
                    Intent more_int = new Intent(getApplicationContext(), More.class);
                    startActivity(more_int);
                    finish();
                    return true;
            }
            return false;
        }
    };
}
