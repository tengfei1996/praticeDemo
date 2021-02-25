package com.example.demo.base.config;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.example.demo.base.baseEnum.BaseEnum;
import com.example.demo.model.common.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>
     * 自定义 REST 业务异常
     * <p>
     *
     * @param e 异常类型
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseModel handleBadRequest(HttpServletRequest request, Exception e) {
//        logger.error("_"+e.getMessage(),e);
        /*
         * 业务逻辑异常
         */
        /*
         * 异常日志的保存数据库
         */
        //TODO 异常日志的保存数据库

        if (e instanceof ApiException) {

            IErrorCode errorCode = ((ApiException) e).getErrorCode();
            return new ResponseModel(false, BaseEnum.ResponseStatus.SERVER_EXCEPTION.getCode(), BaseEnum.ResponseStatus.SERVER_EXCEPTION.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {// 请求参数模型验证失败
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            if (null != bindingResult) {
                List<ObjectError> errors = bindingResult.getAllErrors();
                if (errors.size() > 0) {
                    return new ResponseModel(false, BaseEnum.ResponseStatus.VALID_EXCEPTION.getCode(), errors.get(0).getDefaultMessage());
                }
            }
            return new ResponseModel(false, BaseEnum.ResponseStatus.VALID_EXCEPTION.getCode(), BaseEnum.ResponseStatus.VALID_EXCEPTION.getMessage());
        } else if (e instanceof AuthException) {
            return new ResponseModel(false, BaseEnum.ResponseStatus.TOKEN_TIME_OUT.getCode(), ((AuthException) e).getMessage());
        } else if (e instanceof DataIntegrityViolationException) {
            return new ResponseModel(false, BaseEnum.ResponseStatus.SQL_ERROR.getCode(), BaseEnum.ResponseStatus.SQL_ERROR.getMessage());
        }
        return new ResponseModel(false, BaseEnum.ResponseStatus.SERVER_EXCEPTION.getCode(), BaseEnum.ResponseStatus.SERVER_EXCEPTION.getMessage());
    }
}
