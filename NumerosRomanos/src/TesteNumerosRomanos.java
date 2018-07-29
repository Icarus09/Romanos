import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteNumerosRomanos {
	
	ConversorRomanos conversor;

	@BeforeEach
	void setUp() throws Exception {
		
		conversor = new ConversorRomanos();
	}

	@Test
	void deve_converter_romanos_com_uma_letra_valida() {
		Integer esperado = 10;
		Integer atual = conversor.converter("X");
		assertEquals(esperado, atual);

	}
	
	@Test
	void deve_recusar_romano_com_uma_letra_invalida() {
		assertThrows(IllegalArgumentException.class, () -> {
			conversor.converter("");
		});
	}
	
	@Test
	void deve_converter_dois_romanos_validos_e_iguais(){
		
		Map<String, Integer> letrasIguaisInvalidas = new HashMap();
		letrasIguaisInvalidas.put("V", -1);
		letrasIguaisInvalidas.put("L", -1);
		letrasIguaisInvalidas.put("D", -1);
		
		for(String letra: conversor.letras.keySet()) {
			
			if(!letrasIguaisInvalidas.containsKey(letra)) {
			
				String letraFinal = letra + letra;
			
				int valorEsperado = conversor.converter(letra).intValue();

				assertEquals(Integer.valueOf(valorEsperado*2), conversor.converter(letraFinal));
			}
		}
	}
	
	@Test
	void deve_subtrair_dois_romanos_validos_diferentes_quando_o_primeiro_for_menor(){
		
		Integer numero = 9;
		assertEquals(numero, conversor.converter("IX"));
	}
	
	@Test
	void deve_somar_dois_romanos_validos_diferentes_quando_o_segundo_for_menor(){
		Integer numero = 700;
		assertEquals(numero, conversor.converter("DCC"));
	}
	
	@Test
	void deve_somar_tres_romanos_validos_iguais(){
		
		Map<String, Integer> letrasIguaisInvalidas = new HashMap();
		letrasIguaisInvalidas.put("V", -1);
		letrasIguaisInvalidas.put("L", -1);
		letrasIguaisInvalidas.put("D", -1);
		
		for(String letra: conversor.letras.keySet()) {
			
			if(!letrasIguaisInvalidas.containsKey(letra)) {
			
				String letraFinal = letra + letra + letra;
			
				int valorEsperado = conversor.converter(letra).intValue();

				assertEquals(Integer.valueOf(valorEsperado*3), conversor.converter(letraFinal));
			}
		}
	}
}
	