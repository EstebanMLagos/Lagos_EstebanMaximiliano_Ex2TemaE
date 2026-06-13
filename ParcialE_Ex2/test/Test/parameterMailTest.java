package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(value=Parameterized.class) 
public class parameterMailTest {
    
    
    private String email;
    private boolean resultadoEsperado;

    public parameterMailTest(String email, boolean resultadoEsperado) {
        this.email = email;
        this.resultadoEsperado = resultadoEsperado;
    }

    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"jorgesys@tototita.com", true},
            {"jorgesys@tototitacom", false},
            {"jorgesystototita.com", false},
            {"@jorgesystototita.com", false},
            {".jorgesystototita@com", false}
        });
    }

    
    public static boolean ValidarMail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    @Test
    public void testValidarEmail() {
        assertEquals(this.resultadoEsperado, ValidarMail(this.email));
    }
}
