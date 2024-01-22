package com.y.back.models.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Person entity.
 */
@Entity
@Table(name = "persons")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "age")
  private Integer age;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @Column(name = "created_time")
  private LocalTime createdTime;

  @Column(name = "role")
  private String role;

  /**
   * Constructor.
   * Id @param id
   * Username @param username
   * Password @param password
   * Email @param email
   * Age @param age
   * Account Creation Date @param createdDate
   * Account Creation Time @param createdTime
   * Role @param role
   */
  public Person(Integer id, String username, String password, String email, Integer age, 
      LocalDate createdDate, LocalTime createdTime, String role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.age = age;
    this.createdDate = createdDate;
    this.createdTime = createdTime;
    this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public LocalTime getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(LocalTime createdTime) {
    this.createdTime = createdTime;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
