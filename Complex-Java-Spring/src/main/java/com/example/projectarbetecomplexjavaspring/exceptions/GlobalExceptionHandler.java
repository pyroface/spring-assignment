package com.example.projectarbetecomplexjavaspring.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // CUSTOM EXCEPTIONS

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex) {
        logger.info(ex.getClass().getName());
        String errorMessage = "Entity not found.";

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, ex));
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<Object> unauthorizedException(UnauthorizedException ue) {
        logger.info(ue.getClass().getName());
        String errorMessage = "You are not authorized.";

        return buildResponseEntity(new ApiError(HttpStatus.UNAUTHORIZED, errorMessage, ue));
    }

    @ExceptionHandler({NoContentException.class})
    public ResponseEntity<Object> noContentException(NoContentException nce) {
        logger.info(nce.getClass().getName());
        String errorMessage = "There is no content to show.";

        return buildResponseEntity(new ApiError(HttpStatus.NO_CONTENT, errorMessage, nce));
    }




    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception e, WebRequest request) {
        logger.info(e.getClass().getName());
        logger.error("Error: ", e);
        String errorMessage = "An unexpected error occurred";

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, e));
    }



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        String errorMessage = "Malformed JSON request.";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, ex));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> builder.append(t + " "));

        return buildResponseEntity(new ApiError(HttpStatus.METHOD_NOT_ALLOWED, builder.toString(), ex));
    }


}
