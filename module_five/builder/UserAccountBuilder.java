package ru.module_five.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserAccountBuilder {
    private UUID id;
    private String email;
    private String firstName = "";
    private String lastName = "";
    private LocalDate birthDate;
    private String phone = "";
    private boolean newsletter = false;
    private final List<String> roles = new ArrayList<>();

    public UserAccountBuilder id(UUID id) { this.id = id; return this; }
    public UserAccountBuilder email(String email) { this.email = email; return this; }
    public UserAccountBuilder firstName(String firstName) { this.firstName = firstName; return this; }
    public UserAccountBuilder lastName(String lastName) { this.lastName = lastName; return this; }
    public UserAccountBuilder birthDate(LocalDate birthDate) { this.birthDate = birthDate; return this; }
    public UserAccountBuilder phone(String phone) { this.phone = phone; return this; }
    public UserAccountBuilder newsletter(boolean newsletter) { this.newsletter = newsletter; return this; }
    public UserAccountBuilder addRole(String role) { this.roles.add(role); return this; }

    public UserAccount build() {
        if (id == null) throw new IllegalStateException("id обязателен");
        if (email == null || !email.contains("@")) throw new IllegalStateException("корректный email обязателен");
        return new UserAccount(id, email, firstName, lastName, birthDate, phone, newsletter, roles);
    }
}
