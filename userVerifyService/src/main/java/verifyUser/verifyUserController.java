package verifyUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class verifyUserController {

    //Función que recibe el objeto JSON con el contenido de la imagen además del parámetro username
    @RequestMapping("/rest/verifyUser")
    public ResponseEntity<String> verifyUser(@RequestParam(value="username", required = false) String userName, @RequestBody Image image) {
    
	//Servicio funciona como dumy respondiendo HTTP status 200 si el username es h001
	//y HTTP status 401 si el username es h002 o algun otro nombre de usuario
	if (userName.compareTo("h001") == 0)
	    return new ResponseEntity<String> ("OK", HttpStatus.OK);
	else
	    return new ResponseEntity<String> ("No Autorizado", HttpStatus.UNAUTHORIZED);
	
    }
}