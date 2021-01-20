package tsi.ws.lucaschfonseca.introductionwebservices.config.validation;

@SuppressWarnings("unused")
public class FormErrorDto {
    private final String field;
    private final String errorMessage;

    public FormErrorDto(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
