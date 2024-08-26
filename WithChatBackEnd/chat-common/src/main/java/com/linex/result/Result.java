package com.linex.result;

import com.linex.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linexsong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Status status;
    private String msg;
    private T data;

    public static Result<?> success() {
        return new Result<>(Status.SUCCESS, "", null);
    }

    public static Result<?> error(String error) {
        return new Result<>(Status.ERROR, error, null);
    }

    public static <D> Result<D> success(D data) {
        return new Result<>(Status.SUCCESS, "", data);
    }
}
