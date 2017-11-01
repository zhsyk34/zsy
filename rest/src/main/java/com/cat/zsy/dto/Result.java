package com.cat.zsy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.glassfish.grizzly.http.util.HttpStatus;

import javax.ws.rs.core.Response;

@SuppressWarnings({"WeakerAccess", "unused"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Data
public class Result<T> {
    private int code;
    @NonNull
    private String message;
    private T data;

    public static <T> Result<T> from(HttpStatus httpStatus, T data) {
        return Result.of(httpStatus.getStatusCode(), httpStatus.getReasonPhrase(), data);
    }

    public static <T> Result<T> from(HttpStatus httpStatus) {
        return from(httpStatus, null);
    }

    public static <T> Result<T> success(T data) {
        return from(HttpStatus.OK_200, data);
    }

    public static <T> Result<T> from(Response.Status status, String message, T data) {
        return Result.of(status.getStatusCode(), message, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return from(Response.Status.OK, message, data);
    }

    public static <T> Result<T> error(String message, T data) {
        return from(Response.Status.INTERNAL_SERVER_ERROR, message, data);
    }

}
