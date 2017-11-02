package com.cat.zsy.rest.dto;

import lombok.*;
import org.glassfish.grizzly.http.util.*;

import static javax.ws.rs.core.Response.*;
import static org.glassfish.grizzly.http.util.HttpStatus.*;

@SuppressWarnings({"WeakerAccess", "unused"})
@RequiredArgsConstructor(staticName = "of")
@Data
public class Result<T> {
    private final int code;
    private final String message;
    private final T data;

    public static <T> Result<T> fromHttpStatus(HttpStatus httpStatus, T data) {
        return Result.of(httpStatus.getStatusCode(), httpStatus.getReasonPhrase(), data);
    }

    public static <T> Result<T> fromHttpStatus(HttpStatus httpStatus) {
        return fromHttpStatus(httpStatus, null);
    }

    public static <T> Result<T> fromStatus(Status status, String message, T data) {
        return Result.of(status.getStatusCode(), message, data);
    }

    public static <T> Result<T> fromStatus(Status status, String message) {
        return fromStatus(status, message, null);
    }

    public static <T> Result<T> success(String message, T data) {
        return fromStatus(Status.OK, message, data);
    }

    public static <T> Result<T> success(T data) {
        return fromHttpStatus(OK_200, data);
    }

    public static <T> Result<T> success() {
        return success(null, null);
    }

    public static <T> Result<T> error(Status status, String message, T data) {
        return fromStatus(status, message, data);
    }

    public static <T> Result<T> error(Status status, String message) {
        return error(status, message, null);
    }

    public static <T> Result<T> error(Status status) {
        return error(status, null);
    }

}
