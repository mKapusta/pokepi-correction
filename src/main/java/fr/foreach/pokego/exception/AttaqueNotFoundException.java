package fr.foreach.pokego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Attaque not found")
public class AttaqueNotFoundException extends RuntimeException {
}
