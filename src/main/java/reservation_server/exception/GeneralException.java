package reservation_server.exception;

import javax.persistence.GeneratedValue;

public class GeneralException extends RuntimeException{

    private  String customMessage;

    public GeneralException(String erroMessage,String customMessage){
        super(erroMessage);
        this.customMessage = customMessage;
    }

    public GeneralException(String customMessage){
        super(customMessage);
        this.customMessage = customMessage;
    }


    public String getCustomMessage() {
        return customMessage;
    }
}
