package com.cat.zsy.rest.exception;

public interface Exceptions {

    class MyException extends RuntimeException {
    }

    class MySubException extends MyException {
    }

    class MySubSubException extends MySubException {
    }

}
