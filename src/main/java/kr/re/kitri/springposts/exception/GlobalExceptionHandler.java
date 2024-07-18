package kr.re.kitri.springposts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<String> handleBadSqlGrammarException(BadSqlGrammarException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("고객님 불편을 드려 죄송합니다.");
    }
}
