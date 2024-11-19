package school.exercice.contact.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Contact {

    @NotNull
    private String name;

    public Contact(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact name: " + name;
    }
}
