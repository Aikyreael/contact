package school.exercice.contact.services;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.stereotype.Service;
import school.exercice.contact.entities.Contact;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(@Valid Contact contact) {
        if (contact == null )
            return;

        contacts.add(contact);
    }

    public void showContacts() {

    }

    public void showContactWithName() {

    }

    public void deleteContact(int index) {
        contacts.remove(index-1);
    }

    public void modifyContact() {

    }

    public int numbersOfContacts() {
        return contacts.size();
    }

    public void contactContain() {

    }

    public void closeContactList() {

    }

    public boolean contactContainLetter(int index) {
        return contacts.get(index-1).getName().equals("A") || contacts.get(index-1).getName().equals("a");
    }

    public void resetContacts() {
        contacts.clear();
    }
}
