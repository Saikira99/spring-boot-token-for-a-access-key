package spring_boot_token_for_a_access_key;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expression")
public class ExpressionController {

    private final ExpressionService expressionService;

    public ExpressionController(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }

    @PostMapping
    public ResponseEntity<ExpressionResponse> createExpression(@RequestBody ExpressionRequest request,
                                                               @RequestHeader("Authorization") String token) {
        if (!validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExpressionResponse("Invalid access token", null));
        }

        ExpressionResponse response = expressionService.processExpression(request);
        return ResponseEntity.ok(response);
    }

    private boolean validateToken(String token) {
        return token != null && token.startsWith("Bearer ") &&
                token.substring(7).equals("eyJraWQiOiI5YTQxMzA4ZS01MzM5LTQ5ZjktOTc2ZS05OTc5MDVlOTU5YjEiLCJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2FzY2VuZGlvbi5jb20iLCJpZGVudGlmaWVyIjoiYXZhIy0qZ3B0IiwibmFtZSI6Ik1pY2hlbGFuZ2VsbyIsImVtYWlsIjoibWljaGVsYW5nZWxvQGFzY2VuZGlvbi5jb20iLCJpYXQiOjE3MTY1MjgyNTcsImV4cCI6MTkyNDkwNTYwMH0.AKPztEZFDt2BNBiKUfy9-l-LavPdtcLW97JCBP5qi1OQAdGmPl_IHvHO4fwYe_aycqKEXQvcFkw5sT5w9UXcjA");
    }
}
