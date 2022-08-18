package com.za.user.exception.custo;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 下午6:46
 */
public class UniqueIndexException extends RuntimeException {
    
    public UniqueIndexException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
