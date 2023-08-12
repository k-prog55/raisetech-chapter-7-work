package com.chapter7.practice2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateForm {

    @NotBlank(message = "名前が空欄です")
    @Size(max = 20, message = "名前は最大20文字までです")
    private String name;
    
    private LocalDate birthdate;

    @NotBlank
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
