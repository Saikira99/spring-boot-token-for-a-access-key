package spring_boot_token_for_a_access_key;

import lombok.Data;

@Data
public class ExpressionRequest {
    private String mode;
    private String prompt;
    private boolean promptOverride;
    private String useCaseIdentifier;
    private String userSignature;
}