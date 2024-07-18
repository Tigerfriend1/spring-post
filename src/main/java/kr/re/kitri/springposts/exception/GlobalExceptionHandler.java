package kr.re.kitri.springposts.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<String> handleBadSqlGrammarException(BadSqlGrammarException exception){
        log.info("실행 중 sql 문법에 예외발생\n"+exception.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("고객님 불편을 드려 죄송합니다.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception){
        log.info("실행 중 예외발생\n"+exception.toString());
        return ResponseEntity.status(500).body("불편을 드려 죄송합니다.");
    }
}
