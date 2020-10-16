package app.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenMismatchException extends AppException{
    String email;

}
