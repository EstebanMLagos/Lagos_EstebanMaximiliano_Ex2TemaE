package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value=Parameterized.class) 
public class parameterUserTest {
    
    
    private String valorIngresado;
    private int valorEsperado;
    private usuario miUsuario;

    
    public parameterUserTest(String valorIngresado, int valorEsperado) {
        this.valorIngresado = valorIngresado;
        this.valorEsperado = valorEsperado;
        this.miUsuario = new usuario("Prueba", 1234);
    }

    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"1234", 1234}, 
            {"123", 1234}, 
            {"4444", 1234}  
        });
    }

    @Test
    public void TestCambioPass() {
        
        miUsuario.cambioPassword(this.valorIngresado);
        assertEquals(this.valorEsperado, miUsuario.getPass());
    }
}
