package surveypulse.user_service.global.exception.type;


import surveypulse.user_service.global.exception.BaseException;
import surveypulse.user_service.global.exception.ExceptionType;

public class NotFoundException extends BaseException {

    public NotFoundException(ExceptionType exceptionType) {
        super(exceptionType);
    }

}