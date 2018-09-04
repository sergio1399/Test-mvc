package ru.sergio.testmvc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private Boolean result;

    private String message;

    public ResponseDto(Boolean result) {
        this.result = result;
    }

    public ResponseDto(String message) {
        this.message = message;
    }

    public ResponseDto() {
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
