package com.glamora.ref.common.error;//
//package com.glamora.common.error;
//
//import com.glamora.common.model.ResponseModel;
//import jakarta.validation.ConstraintViolationException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
////    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
////
////    @ExceptionHandler(Exception.class)
////    @ResponseBody
////    public ResponseEntity<?> handleAll(Exception ex) {
////        log.error("Unhandled exception", ex);
////        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                .body(ResponseModel.error(500, "Internal server error"));
////    }
////
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    @ResponseBody
////    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
////
////        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
////                .map(e -> e.getField() + " " + e.getDefaultMessage())
////                .collect(Collectors.toList());
////
////        return ResponseEntity.badRequest().body(ResponseModel.error(1001, String.valueOf(errors)));
////    }
////
////    @ExceptionHandler(ConstraintViolationException.class)
////    @ResponseBody
////    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
////
////        List<String> errors = ex.getConstraintViolations().stream()
////                .map(cv -> cv.getPropertyPath() + " " + cv.getMessage())
////                .collect(Collectors.toList());
////
////        return ResponseEntity.badRequest().body(ResponseModel.error(1002, String.valueOf(errors)));
////
////    }
//}
