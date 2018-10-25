package yop.wikitec.wikitec;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;

import yop.wikitec.wikitec.AccesoUsuarios.AccesoUsuariosDAO;
import yop.wikitec.wikitec.AccesoUsuarios.AccesoUsuariosDTO;

public class Inicio extends AppCompatActivity {
    private Button btn_login;
    private Thread sqlThread;
    private AccesoUsuariosDTO auDto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button btn_next = (Button) findViewById(R.id.Inicio);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryParticipanteDatabase(getApplicationContext());
               // Intent intent = new Intent(getApplicationContext(), login.class);
               // startActivity(intent);
               // finish();
            }
        });
    }
    private void queryParticipanteDatabase(final Context ctx){

        sqlThread = new Thread(){
            public void run(){
                AccesoUsuariosDAO auDao = new AccesoUsuariosDAO();
                auDto = new AccesoUsuariosDTO();
                try {
                    auDto = auDao.buscausuario(ctx);
                    Toast.makeText(getApplicationContext(), "conexion correcta",
                            Toast.LENGTH_SHORT).show();

                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "conexion incorrecta",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };
        sqlThread.start();
        try {
            sqlThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
