package br.com.jpaveiro.thunderpos.domain.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {
    private HttpStatus httpStatus;
    private String message;
}
