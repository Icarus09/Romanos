import java.util.HashMap;
import java.util.Map;

public class ConversorRomanos {
	
	Map<String, Integer> letras;
	Map<String, Integer> letrasInvalidas;
	public ConversorRomanos() {
		
		letras = new HashMap<>();
		letras.put("I", 1);
		letras.put("V", 5);
		letras.put("X", 10);
		letras.put("L", 50);
		letras.put("C", 100);
		letras.put("D", 500);
		letras.put("M", 1000);
		
	}	
	
	public Integer converter(String letra) {
		
		if(letra.isEmpty()) throw new IllegalArgumentException();
		
		Integer numeroFinal = 0;
		Integer maiorValor = letras.get(String.valueOf(letra.charAt(0)));
		for(int i = 0; i < letra.length(); i++){
			
			if(!letras.containsKey(String.valueOf(letra.charAt(i)))){
				throw new IllegalArgumentException();
			}
			
			Integer valor = letras.get(String.valueOf(letra.charAt(i)));
			if(maiorValor < valor){
				numeroFinal -= valor;
				return Math.abs(numeroFinal); 
			}
			
			numeroFinal += valor;
		}
		
		return numeroFinal;
	}
}
