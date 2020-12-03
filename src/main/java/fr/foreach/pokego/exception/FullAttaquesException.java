package fr.foreach.pokego.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Your Pokemon can not learn more than 4 attacks")
public class FullAttaquesException extends RuntimeException {
}
