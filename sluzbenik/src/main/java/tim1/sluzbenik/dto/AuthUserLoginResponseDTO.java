package tim1.sluzbenik.dto;

public class AuthUserLoginResponseDTO {
    
    private String accessToken;
    private Long expiresIn;

    public AuthUserLoginResponseDTO() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public AuthUserLoginResponseDTO(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
