package com.totoropcbeta.studentmanagesystem.handler;

import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * @author yuanhang08
 * @date 2022年11月23日
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // POST PUT请求校验不通过会抛出如下异常,在这对它处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVo handleBindException(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        // 记录日志。。。
        return fieldError == null ? ResultVo.fail() : ResultVo.fail(fieldError.getDefaultMessage());
    }

    // GET请求校验不通过会抛出如下异常,在这对它处理
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultVo handleConstraintViolationException(ValidationException exception) {
        if (exception instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) exception;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                return ResultVo.fail(item.getMessage());
            }
        }
        return ResultVo.fail();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResultVo handleIllegalArgumentException(IllegalArgumentException exception) {
        return exception == null ? ResultVo.fail() : ResultVo.fail(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVo handleRuntimeException(RuntimeException exception) {
        return exception == null ? ResultVo.fail() : ResultVo.fail(exception.getMessage());
    }


}
