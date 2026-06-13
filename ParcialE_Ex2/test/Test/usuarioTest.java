package Test;

import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class usuarioTest {
    
    
    static usuario usr;
    static int numTest = 1;

    
    @BeforeClass
    public static void antesDeTodo() {
        usr = new usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }

   
    @AfterClass
    public static void despuesDeTodo() {
        
        LocalDate fechaAyer = LocalDate.of(2026, 6, 12); 
        System.out.println("Fin de las pruebas " + fechaAyer);
    }

    
    @Before
    public void antesDeCada() {
        System.out.println("Test i: " + numTest++);
    }

    @After
    public void despuesDeCada() {
        System.out.println("-----------------------------------");
    }

   

    @Test
    public void testValidarUsr() {
        int contra = 2222;
       
        assertTrue("Debería fallar porque la contraseña no coincide", usr.validarPassword(contra)); 
    }

    @Test
    public void testValidarEmail() {
        String email = "maxi@ulp.edu.ar";
        
        assertTrue(email.contains("@") && email.contains(".") && email.length() < 20);
    }

    @Test
    public void testCambioPass() {
        String newPass = "1234";
        usr.cambioPassword(newPass);
       
        assertEquals(1234, usr.getPass());
        System.out.println("Nuevo Pass> " + usr.getPass());
    }

    @Test(timeout = 30) 
    public void testDelay() {
        usr.delay(50);
    }

    @Test
    public void testUsuariosDiferentes() {
        usuario u1 = new usuario("Maxi", 1234);
        usuario u2 = new usuario("Profe", 5678);
        
        assertNotSame("mismo usuario", u1, u2); 
    }
}
