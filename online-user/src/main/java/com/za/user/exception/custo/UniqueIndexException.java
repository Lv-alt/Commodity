package com.za.user.exception.custo;

/**
 * @author lvweichen πΊ β β β β¦β¦ οΈπ
 * @date 2022/8/18 δΈε6:46
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
