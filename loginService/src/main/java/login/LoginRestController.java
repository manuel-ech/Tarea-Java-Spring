package login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpClientErrorException;
import util.PropertiesUtil;

@RestController
public class LoginRestController {

    //Función que recibe el objeto JSON desde el fomulario de login con los valores de username e imagen
    @RequestMapping("/rest/login")
    public ResponseEntity<String> login(@RequestBody Login login) throws Exception {
        
        RestTemplate restTemplate = new RestTemplate();

	String urlString = PropertiesUtil.getPropValues("url.verifyUser.service").trim() + "?username="+login.getUsername();
	
	Image image = new Image(login.getImage());
	
	//Se crea una instancia de la clase ObjectMapper de la biblioteca jackson
	ObjectMapper objectMapper = new ObjectMapper();
	
	//Se configura el objectMapper para una mejor impresión del json
	objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	
	//Se realiza el mapeo del objeto login a un string con contenido JSON
	String requestJson = objectMapper.writeValueAsString(image);
	
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
	
	try{
	    //Se realiza la llamada al servicio de verificación de usuario
	    ResponseEntity<String> verifyUserServiceResponse = restTemplate.exchange(urlString, HttpMethod.POST, entity, String.class);
	    
	    //Se retorna la respuesta del servicio de verificación
	    return verifyUserServiceResponse;
	    
	} catch (HttpClientErrorException e) {
	    
	    //Se captura la exepción en caso de error, y si el status code es 401 se retona el mensaje requerido.
	    
	    if (e.getStatusCode().value() == 401)
		return new ResponseEntity<String> (HttpStatus.UNAUTHORIZED);
	    else
		return new ResponseEntity<String> (e.getStatusCode());
	}
    }
}