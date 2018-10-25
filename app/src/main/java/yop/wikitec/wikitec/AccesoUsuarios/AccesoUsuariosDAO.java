package yop.wikitec.wikitec.AccesoUsuarios;

import android.content.Context;
import android.content.res.AssetManager;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class AccesoUsuariosDAO {

    public AccesoUsuariosDTO buscausuario(Context context) throws SQLException {
        AccesoUsuariosDTO auDto = new AccesoUsuariosDTO();
        AssetManager assetManager = context.getAssets();
        Properties properties = new Properties();
        InputStream inputStream;
        String resultado;
        try{
            inputStream = assetManager.open("database.properties");
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        String jdbc_driver = properties.getProperty("jdbc.driver");
        String jdbc_url = properties.getProperty("jdbc.url");
        String jdbc_username = properties.getProperty("jdbc.username");
        String jdbc_password = properties.getProperty("jdbc.password");



        try {
            Class.forName(jdbc_driver);
            Connection conn = DriverManager.getConnection(
                    jdbc_url,jdbc_username,jdbc_password);
            String query = "SELECT * FROM ADRIAN.BITACORA";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            conn.close();

        }catch (SQLException se){
            System.err.println(se.toString());
            auDto.setPass(se.toString());
            return auDto;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return auDto;
    }
}
