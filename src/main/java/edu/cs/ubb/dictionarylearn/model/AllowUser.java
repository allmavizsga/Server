package edu.cs.ubb.dictionarylearn.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class AllowUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allowUserId;

    @NotNull
    @Column(length = 100)
    private String allowUserEmail;

    @NotNull
    @Column(length = 100)
    private String allowUserpassword;

    @NotNull
    @Column(length = 100)
    private String allowUserAddress;

    @NotNull
    @Column(length = 100)
    private String allowUserTown;

    @NotNull
    @Column(length = 100)
    private String allowUserState;

    @Column()
    private Boolean allowUserAdmin;

    public Long getAllowUserId() {
        return allowUserId;
    }

    public void setAllowUserId(Long allowUserId) {
        this.allowUserId = allowUserId;
    }

    public String getEmail() {
        return allowUserEmail;
    }

    public void setEmail(String email) {
        this.allowUserEmail = email;
    }

    public String getPassword() {
        return allowUserpassword;
    }

    public void setPassword(String password) {
        this.allowUserpassword = password;
    }

    public String getAddress() {
        return allowUserAddress;
    }

    public void setAddress(String address) {
        this.allowUserAddress = address;
    }

    public String getTown() {
        return allowUserTown;
    }

    public void setTown(String town) {
        this.allowUserTown = town;
    }

    public String getState() {
        return allowUserState;
    }

    public void setState(String state) {
        this.allowUserState = state;
    }

    public Boolean getAdmin() {return allowUserAdmin;}

    public void setAdmin(Boolean admin) { this.allowUserAdmin = admin;}
}
