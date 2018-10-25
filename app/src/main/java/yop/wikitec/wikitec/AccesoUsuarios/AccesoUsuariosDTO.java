package yop.wikitec.wikitec.AccesoUsuarios;

public class AccesoUsuariosDTO {
    private String email;
    private String pass;
    private int Id;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
