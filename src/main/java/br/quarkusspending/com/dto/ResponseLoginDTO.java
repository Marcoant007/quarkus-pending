package br.quarkusspending.com.dto;

public class ResponseLoginDTO {

    public String email;
    public String token;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
