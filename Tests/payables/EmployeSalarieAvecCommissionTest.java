package payables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeSalarieAvecCommissionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    EmployeSalarieAvecCommission employe = new EmployeSalarieAvecCommission(12, "Aline Brullemans",
            "123327832", 4000, 0.1, 15000, "Peu motivée");

    @Test
    public void voirSiCaMarche() {
        assertEquals(0, employe.toStringSauvegarde());
    }

}