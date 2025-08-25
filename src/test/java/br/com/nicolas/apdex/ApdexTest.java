// NICOLAS DOOBECK MENDES - RM:557605

package br.com.nicolas.apdex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApdexTest {

    private Apdex apdex;

    @BeforeEach
    void setUp() {
        apdex = new Apdex(400000, 100000, 57605);
    }

    @Test
    void getTotalSamples_deveRetornarValorFixoRM() {
        assertEquals(557605, apdex.getTotalSamples());
    }

    @Test
    void calculateApdex_deveRetornarValorEntre0e1() {
        double resultado = apdex.calculateApdex();
        assertTrue(resultado >= 0 && resultado <= 1);
    }

    @Test
    void classifyApdex_deveRetornarExcelente() {
        Apdex a = new Apdex(550000, 5000, 2605);
        assertEquals("Excelente", a.classifyApdex());
    }

    @Test
    void classifyApdex_deveRetornarBom() {
        Apdex a = new Apdex(500000, 40000, 17605);
        assertEquals("Bom", a.classifyApdex());
    }

    @Test
    void classifyApdex_deveRetornarRazoavel() {
        Apdex a = new Apdex(350000, 100000, 107605);
        assertEquals("Razoável", a.classifyApdex());
    }

    @Test
    void classifyApdex_deveRetornarRuim() {
        Apdex a = new Apdex(275000, 50000, 232605);
        assertEquals("Ruim", a.classifyApdex());
    }

    @Test
    void classifyApdex_deveRetornarInaceitavel() {
        Apdex a = new Apdex(10000, 10000, 537605);
        assertEquals("Inaceitável", a.classifyApdex());
    }
}