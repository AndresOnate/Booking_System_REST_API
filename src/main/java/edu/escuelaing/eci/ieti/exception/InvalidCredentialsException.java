package edu.escuelaing.eci.ieti.exception;


import edu.escuelaing.eci.ieti.error.ErrorCodeEnum;
import edu.escuelaing.eci.ieti.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException()
    {
        super( new ServerErrorResponseDto( "Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED ), HttpStatus.UNAUTHORIZED );
    }
}
