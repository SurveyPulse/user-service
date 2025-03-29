package surveypulse.user_service.global.exception.type;


import surveypulse.user_service.global.exception.BaseException;
import surveypulse.user_service.global.exception.ExceptionType;

public class SignInException extends BaseException {

    public Object data;
    public SignInException(ExceptionType exceptionType) {
        super(exceptionType);
    }

    public SignInException(ExceptionType exceptionType, Object data) {
        super(exceptionType);
        this.data = data;
    }

}
