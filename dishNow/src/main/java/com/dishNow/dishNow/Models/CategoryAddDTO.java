package com.dishNow.dishNow.Models;

import jakarta.validation.constraints.NotBlank;

public class CategoryAddDTO {
    @NotBlank(message = "Name (EN) is required")
    private String nameEN;

    @NotBlank(message = "Name (ES) is required")
    private String nameES;

    @NotBlank(message = "Name (CN) is required")
    private String nameCA;
    
    public CategoryAddDTO(String nameEN, String nameES, String nameCA) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
    }
    public String getNameEN() {
        return nameEN;
    }
    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }
    public String getNameES() {
        return nameES;
    }
    public void setNameES(String nameES) {
        this.nameES = nameES;
    }
    public String getNameCA() {
        return nameCA;
    }
    public void setNameCA(String nameCA) {
        this.nameCA = nameCA;
    }
}
