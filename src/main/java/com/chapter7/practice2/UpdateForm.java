package com.chapter7.practice2;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UpdateForm {

    @NotBlank(message = "名前が空欄です")
    @Length(max = 20, message = "名前は最大20文字です")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
