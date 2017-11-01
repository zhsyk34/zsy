package com.cat.zsy.exception;

public interface Exceptions {

    class MyException extends RuntimeException {
    }

    class MySubException extends MyException {
    }

    class MySubSubException extends MySubException {
    }

}
