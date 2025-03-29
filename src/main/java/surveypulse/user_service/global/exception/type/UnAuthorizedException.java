package surveypulse.user_service.global.exception.type;


import surveypulse.user_service.global.exception.BaseException;
import surveypulse.user_service.global.exception.ExceptionType;

public class UnAuthorizedException extends BaseException {

    public UnAuthorizedException(ExceptionType exceptionType) {
        super(exceptionType);
    }

}
