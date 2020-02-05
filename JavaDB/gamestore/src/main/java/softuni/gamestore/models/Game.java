package softuni.gamestore.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
public class Game extends BaseEntity {
    private String title;
    private String trailer;
    private String image;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;
    private Set<User> users = new HashSet<>();
    private User user;
    @Column(name = "title",nullable = false,unique = true)
    @Size(min = 3,max = 100,message = "Title have length between 3 and 100 symbols")
    @Pattern(regexp = "^[A-Z].+$",message = "Title – has to begin with an uppercase letter")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    @Column(name = "trailer")
    @Size(min=11,max = 11,message = "Trailer – only videos from YouTube are allowed. Only their ID, which is a string of exactly 11 characters")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "image")
    @Pattern(regexp = "^http[s]?:\\/\\/.+$",message = "Thumbnail URL – it should be a plain text starting with http://, https:// or null")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
            this.image = image;
    }

    @Column(nullable = false)
    @Digits(integer = 19, fraction = 1, message = "Size must be with precision up to 1 digit after the floating point.")
    @Min(value = 0,message = "Size must be a positive number.")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Column(nullable = false,precision = 19,scale = 2)
    @Min(value = 0,message = "Price must be a positive number.")
    @Digits(integer = 19, fraction = 2, message = "Price must be with precision up to 2 digit after the floating point.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Size(min = 20,message = "Description – must be at least 20 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(mappedBy = "games")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    @ManyToOne(targetEntity = User.class)//, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
