package com.huybla.blog.domain.enties;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class user {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private LocalDateTime createAt;

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password, name, createAt);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof user))
      return false;
    user other = (user) obj;
    return Objects.equals(id, other.id) && Objects.equals(email, other.email)
        && Objects.equals(password, other.password) && Objects.equals(name, other.name)
        && Objects.equals(createAt, other.createAt);
  }

  protected void onCreate() {
    this.createAt = LocalDateTime.now();
  }
}
