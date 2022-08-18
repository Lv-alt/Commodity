package com.za.user.exception;

import com.za.user.enums.ErrorEnum;
import com.za.user.exception.custo.UniqueIndexException;
import com.za.user.response.ResponseDTO;
import com.za.user.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 上午10:15
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseDTO defaultException(HttpServletRequest request, Exception ex) {
        log.error("目标方法：{}，系统异常:{}", request.getRequestURL(), ex);
        return ResponseUtil.error(ErrorEnum.DEFAULT_ERROR);
    }

    /**
     * 方法参数校验异常捕捉，自定义message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.warn(exception.getMessage(), exception);
        String message = exception.getBindingResult().getAllErrors().stream().map(this::getMessage).collect(Collectors.joining("    "));
        return ResponseUtil.error("500", message);
    }

    private String getMessage(ObjectError error) {
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            return fieldError.getField() + ": " + fieldError.getDefaultMessage();
        }
        return error.getDefaultMessage();
    }

    /**
     * 方法参数校验异常捕捉，自定义message
     */
    @ExceptionHandler(UniqueIndexException.class)
    public ResponseDTO uniqueIndexExceptionHandler(Exception exception) {
        return ResponseUtil.error("500", exception.getMessage());
    }
    
    
}
