package br.quarkusspending.com.exceptions;

public class MessageExceptions extends RuntimeException {
    private int status = 500;

    public MessageExceptions(){
        super();
    }

    public MessageExceptions(String message){
        super(message);
    }

    public MessageExceptions(Exception exception){
        super(exception);
    }

    public MessageExceptions(String message, int httpStatus){
        super(message);
        this.status = httpStatus;
    }

    public MessageExceptions(Exception exception, int httpStatus){
        super(exception);
        this.status = httpStatus;
    }

    public int getStatus(){
        return this.status;
    }
}
