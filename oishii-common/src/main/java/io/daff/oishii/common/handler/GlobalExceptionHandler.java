package io.daff.oishii.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.daff.logging.DaffLogger;
import io.daff.oishii.common.enums.BaseModule;
import io.daff.web.entity.R;
import io.daff.web.enums.GenericHint;
import io.daff.web.exception.BaseException;
import io.daff.web.exception.BizLogicException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * 全局异常处理
 *
 * @author daff
 * @since 2020/7/12
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final DaffLogger log = DaffLogger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<Void> error(HttpMessageNotReadableException e) {
        log.info("参数格式有误", BaseModule.CMS, e);
        return R.error("参数格式有误");
    }

    @ExceptionHandler(JsonProcessingException.class)
    public R<Void> error(JsonProcessingException e) {
        log.error("jackson序列化错误", BaseModule.CMS, e);
        return R.error(GenericHint.ERROR.msg());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R<Void> error(HttpRequestMethodNotSupportedException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.error("请求方法错误，请确认后重试");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public R<Void> error(MaxUploadSizeExceededException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.error("上传的文件过大，请压缩或降低画质后上传");
    }

    @ExceptionHandler(BindException.class)
    public R<Void> error(BindException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.error(Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(BizLogicException.class)
    public R<Void> error(BizLogicException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler({Exception.class, BaseException.class})
    public R<Void> error(Exception e) {
        log.error(e.getMessage(), BaseModule.CMS, e);
        return R.error(GenericHint.ERROR.msg());
    }

    /**
     * validator参数校验失败的异常处理器
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Void> error(MethodArgumentNotValidException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.fail(Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public R<Void> error(ConstraintViolationException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.fail(e.getConstraintViolations().iterator().next().getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R<Void> error(MissingServletRequestParameterException e) {
        log.info(e.getMessage(), BaseModule.CMS, e);
        return R.fail("请求参数缺失：" + e.getParameterName());
    }
}
