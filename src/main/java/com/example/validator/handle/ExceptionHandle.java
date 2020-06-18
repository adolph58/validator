package com.example.validator.handle;

import com.example.validator.enumeration.ReturnCode;
import com.example.validator.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result businessException(BusinessException e) {
        logger.warn("【业务异常】", e);
        return Result.fail(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public Result sqlException(SQLException e) {
        logger.warn("【SQL错误】", e);
        return Result.fail(e.getErrorCode(), e.getMessage());
    }

    /**
     * 捕获 @Valid 参数校验抛出的异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        logger.warn("【参数错误】" + objectError.getDefaultMessage());
        // 然后提取错误提示信息进行返回
        return Result.fail(ReturnCode.parameterError.getCode(), objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public Result missingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.warn("【参数错误】"+ e.getMessage());
        return Result.fail(ReturnCode.data_not_null.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.warn("【系统异常】", e);
        return Result.error(500, e.getMessage());
    }
}
