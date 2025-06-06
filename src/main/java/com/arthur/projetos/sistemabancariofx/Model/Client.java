package com.arthur.projetos.sistemabancariofx.Model;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;

public class Client {


    private Long id;

    private String name;

    private Integer age;

    private String cpf;

    private String password;

    private Account account;

    private Gender gender;


    public Client(Long id, String name, Integer age, String cpf, String password, Account account, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.password = password;
        this.account = account;
        this.gender = gender;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
