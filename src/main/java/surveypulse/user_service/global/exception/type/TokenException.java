package surveypulse.user_service.global.exception.type;


import surveypulse.user_service.global.exception.BaseException;
import surveypulse.user_service.global.exception.ExceptionType;

public class TokenException extends BaseException {

    public TokenException(ExceptionType exceptionType){
        super(exceptionType);
    }

}
