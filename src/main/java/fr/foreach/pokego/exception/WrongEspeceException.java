package fr.foreach.pokego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong espece")
public class WrongEspeceException extends RuntimeException {
}
