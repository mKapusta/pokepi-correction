package fr.foreach.pokego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Type not found")
public class TypeNotFoundException extends RuntimeException{
}
