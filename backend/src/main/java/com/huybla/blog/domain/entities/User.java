package com.huybla.blog.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(passWord, user.passWord) && Objects.equals(name, user.name) && Objects.equals(createAt, user.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, passWord, name, createAt);
    }

//    before save the entity down to database, run this function and assign current time to createAt
    @PrePersist
    protected void onCreate(){
        this.createAt = LocalDateTime.now();
    }


}
