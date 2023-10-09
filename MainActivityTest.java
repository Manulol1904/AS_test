package com.example.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.robolectric.Robolectric;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import static org.junit.Assert.assertEquals;

import android.widget.TextView;

public class MainActivityTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void calcularPotencia() {
        MainActivity mainActivity = new MainActivity();

        int resultado = mainActivity.calcularPotencia(2, 3);
        assertEquals(8, resultado);
    }

    @Test
    public void calcularSuma() {
        MainActivity mainActivity = new MainActivity();

        // Simular entrada de datos
        String numero1Str = "2";
        String numero2Str = "3";

        // Inicializar resultado en el contexto de la prueba
        mainActivity.resultado = new TextView(mainActivity);

        // Llamar al método calcular directamente
        mainActivity.calcular("+", numero1Str, numero2Str);

        // Obtener el resultado
        String resultadoText = mainActivity.resultado.getText().toString();

        // Verificar que el resultado sea el esperado
        assertEquals("Resultado: 5.0", resultadoText);
    }
    @Test
    public void calcularResta() {
        MainActivity mainActivity = new MainActivity();

        double resultado = mainActivity.calcular("-", "5", "3");
        assertEquals(2, resultado, 0.001);
    }

    @Test
    public void calcularMultiplicacion() {
        MainActivity mainActivity = new MainActivity();

        double resultado = mainActivity.calcular("*", "4", "2");
        assertEquals(8, resultado, 0.001);
    }

    @Test
    public void calcularDivision() {
        MainActivity mainActivity = new MainActivity();

        double resultado = mainActivity.calcular("/", "4", "1");
        assertEquals(4, resultado, 0.001);
    }

    @Test
    public void calcularDivisionPorCero() {
        MainActivity mainActivity = new MainActivity();

        double resultado = mainActivity.calcular("/", "4", "0");
        assertEquals(Double.POSITIVE_INFINITY, resultado);
    }

    @Test
    public void calcularOperadorInvalido() {
        MainActivity mainActivity = new MainActivity();

        double resultado = mainActivity.calcular("%", "4", "2");
        assertEquals(Double.NaN, resultado, 0.001); // NaN (No es un número)
    }
}
