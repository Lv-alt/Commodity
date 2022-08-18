package com.za.user.exception;

import com.za.user.enums.ErrorEnum;
import com.za.user.response.ResponseDTO;
import com.za.user.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 上午10:15
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseDTO defaultException(HttpServletRequest request, Exception ex) {
        log.error("系统异常", ex);
        return ResponseUtil.error(ErrorEnum.DEFAULT_ERROR);
    }
    
}
