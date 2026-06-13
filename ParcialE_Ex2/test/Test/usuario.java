package Test;

public class usuario {
    private String user;
    private int pass;

    public usuario() { }

    public usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public boolean validarPassword(int contra) {
        return this.pass == contra;
    }

    public void cambioPassword(String newPass) {
        this.pass = Integer.parseInt(newPass);
    }

    public void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
        }
    }

    public boolean usuariosDiferentes(usuario u2) {
        return this != u2; 
    }
    
    public int getPass() {
        return this.pass;
    }
    
}
