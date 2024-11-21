package org.example.bfhlapplication.model;

import java.util.List;

public class FileNotFoundResponse extends Response{
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> numbers;
    private List<String> alphabets;
    private String highest_lowercase_alphabet;
    private boolean is_prime_found;
    private boolean file_valid;

    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public String getHighest_lowercase_alphabet() {
        return highest_lowercase_alphabet;
    }

    public void setHighest_lowercase_alphabet(String highest_lowercase_alphabet) {
        this.highest_lowercase_alphabet = highest_lowercase_alphabet;
    }

    public boolean isIs_prime_found() {
        return is_prime_found;
    }

    public void setIs_prime_found(boolean is_prime_found) {
        this.is_prime_found = is_prime_found;
    }

    public boolean isFile_valid() {
        return file_valid;
    }

    public void setFile_valid(boolean file_valid) {
        this.file_valid = file_valid;
    }
}
