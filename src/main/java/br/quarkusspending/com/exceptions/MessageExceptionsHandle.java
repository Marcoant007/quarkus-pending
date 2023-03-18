package br.quarkusspending.com.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MessageExceptionsHandle implements ExceptionMapper<MessageExceptions>{

    @Override
    public Response toResponse(MessageExceptions exception) {
        Throwable rootCause = getRootCause(exception);
        exception.printStackTrace();

        return Response
            .status(exception.getStatus())
            .entity("{\"message\":\"" + rootCause.getMessage() + "\"}")
            .build();
    }

    private Throwable getRootCause(Throwable throwable) {
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
    
}
