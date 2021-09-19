package com.dz_fs_dev.finance.spotMarkets.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import com.dz_fs_dev.finance.spotMarkets.exception.CandleClosedException;
import com.dz_fs_dev.finance.spotMarkets.exception.TradeException;

/**
 * Exception handler for Spot Markets. Server-side.
 * 
 * @author DZ-FSDev
 * @version 0.0.1
 * @since 16.0.1
 */
@ControllerAdvice
public class SpotMarketExceptionHandler {
	/**
	 * Handles TradeExceptions.
	 * 
	 * @param req The originating request.
	 * @param ex The triggered exception.
	 * @return An {@link ErrorInfo} object.
	 */
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(TradeException.class)
    public ErrorInfo handleTradeException(HttpServletRequest req, Exception ex) {
    	return new ErrorInfo(req.getRequestURL(), ex);
    }
    
    /**
	 * Handles CandleClosedExceptions.
	 * 
	 * @param req The originating request.
	 * @param ex The triggered exception.
	 * @return An {@link ErrorInfo} object.
	 */
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(CandleClosedException.class)
    public ErrorInfo handleCandleClosedException(HttpServletRequest req, Exception ex) {
    	return new ErrorInfo(req.getRequestURL(), ex);
    }
}
