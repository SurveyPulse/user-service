package surveypulse.user_service.global.exception.type;


import surveypulse.user_service.global.exception.BaseException;
import surveypulse.user_service.global.exception.ExceptionType;

public class BadRequestException extends BaseException {

    public BadRequestException(ExceptionType exceptionType) {
        super(exceptionType);
    }

}
