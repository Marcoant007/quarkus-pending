package br.quarkusspending.com.dto;

import br.quarkusspending.com.enums.ProfileEnum;

public class ResponseLoginDTO {

    private String email;
    private String token;
    private int expiresIn;
    private ProfileEnum profile;

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
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
    public ProfileEnum getProfile() {
        return profile;
    }
    public void setProfile(ProfileEnum profileEnum) {
        this.profile = profileEnum;
    }
    
}
