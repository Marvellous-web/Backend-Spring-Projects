package org.example.model2;

public class Author {
    private String auth_name,auth_city;

    public Author() {
    }

    public Author(String auth_name, String auth_city) {
        this.auth_name = auth_name;
        this.auth_city = auth_city;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getAuth_city() {
        return auth_city;
    }

    public void setAuth_city(String auth_city) {
        this.auth_city = auth_city;
    }

    @Override
    public String toString() {
        return "Author{" +
                "auth_name='" + auth_name + '\'' +
                ", auth_city='" + auth_city + '\'' +
                '}';
    }
}
