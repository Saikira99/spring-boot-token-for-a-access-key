package spring_boot_token_for_a_access_key;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpressionResponse {
    private String message;
    private String text;
}