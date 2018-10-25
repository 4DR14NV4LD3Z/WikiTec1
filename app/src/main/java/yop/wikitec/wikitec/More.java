package yop.wikitec.wikitec;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class More extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
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
                    Intent lib_int = new Intent(getApplicationContext(), Library.class);
                    startActivity(lib_int);
                    finish();
                    return true;
                case R.id.More_menu:

                    return true;
            }
            return false;
        }
    };

}
