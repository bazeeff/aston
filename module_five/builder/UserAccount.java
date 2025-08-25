package ru.module_five.builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public final class UserAccount {
    private final UUID id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String phone;
    private final boolean newsletter;
    private final List<String> roles;

    public UserAccount(UUID id, String email, String firstName, String lastName,
                       LocalDate birthDate, String phone, boolean newsletter, List<String> roles) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.newsletter = newsletter;
        this.roles = List.copyOf(roles);
    }

    @Override public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", newsletter=" + newsletter +
                ", roles=" + roles +
                '}';
    }
}
