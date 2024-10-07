package spring_boot_token_for_a_access_key;

import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    public ExpressionResponse processExpression(ExpressionRequest request) {

        String message = "Processed request for mode: " + request.getMode();

        String text = request.getPrompt(); // Use the prompt directly from the request

        return new ExpressionResponse(message, text);
    }


//    public String processExpression(ExpressionRequest request) {
//        return "Processed request for mode: " + request.getMode()
//                +"\n"+
//                "text: \"" + request.getPrompt() + "\"";
//    }
}