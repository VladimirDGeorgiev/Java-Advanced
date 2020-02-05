package softuni.gamestore.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    private String email;
    private String password;
    private String fullName;
    private Set<Game> games = new HashSet<>();
    private Set<Game> shoppingCard = new HashSet<>();
    private Role role;

    @Column(name = "email",nullable = false,unique = true)
    @Pattern(regexp = "^[^@]+@[^\\.]+\\..+$",message = "Incorect email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
//        if (!email.contains("@") || !email.contains(".")) {
//            throw new IllegalArgumentException("Incorect email.");
//        }
        this.email = email;
    }

    @Column(name = "password",nullable = false)
    @Length(min = 6,message = "Password – length must be at least 6 symbols.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",message = "Password must contain at least 1 uppercase, 1 lowercase letter and 1 digit.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//        if (password.length() < 6 || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
//            throw new IllegalArgumentException("Incorect password!\n" +
//                    "Password – length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit.");
//        }
        this.password = password;
    }

    @Column(name = "full_name",nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToMany //(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Set<Game> getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(Set<Game> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }
}
