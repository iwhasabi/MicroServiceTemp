package microservertemp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {

	@Autowired
	Temp temp;
	
	Counter contador;
	
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	public TestController(MeterRegistry registry) {
		this.contador = Counter.builder("Invocaciones.contador")
				.description("Invocaciones de Consultas de Temperatura totales").register(registry);

	}
	
	@GetMapping("/")
	public ResponseEntity<String> index() {
		logger.info("Llamada al endpoint inicial");
		return new ResponseEntity<String>(HttpStatus.OK).ok(
				"Inicio si quieres consultar entra en: /consultatemp - para consultar la temperatura <br /> /consultaconvers - para el conversor");

	}
	@GetMapping(path="/consultatemp")
	public String consultaTemp (){
		contador.increment();
		
		return "la temperatura en "+temp.metrica+"es igual a "+temp.grado;
		
	}
	
		
		counterConversion.increment();
		
		return "la temperatura en Farenheit es igual a " ;
	}
}
