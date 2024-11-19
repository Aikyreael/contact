package school.exercice.contact.ui;

import org.springframework.stereotype.Component;
import school.exercice.contact.entities.Contact;
import school.exercice.contact.services.ContactService;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    private final ContactService contactService;

    public ConsoleUI(ContactService contactService) {
        this.contactService = contactService;
    }

    public void displayMenu() {
        System.out.println("""
                
                Entre une options:
                1. Ajouter un contact
                2. Afficher les contacts
                3. Trouve le premier contact avec une condition
                4. Supprimer un contact
                5. Modifier un contact
                6. Filter les contacts par condition
                7. Afficher le nombres de contacts
                8. Vérifie si le contact possède 'a' ou 'A'
                9. Quitter
                """);
    }

    public int getUserInput() {
        System.out.print("Fait un choix: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entre un nombre valide: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public Contact addContact() {
        System.out.print("\nAjout d'un contact ");
        System.out.print("\nEntre le nom du contact à ajouter: ");
        return new Contact(scanner.next());
    }

    public void displayContacts() {
        if (contactService.getContacts().isEmpty()) {
            System.out.println("Pas de contact trouver.");
        } else {
            int index = 1;

            System.out.println();
            for (Contact contact: contactService.getContacts()) {
                System.out.println(index++ + ". " + contact.getName());
            }
        }
    }

    public int selectContact() {
        System.out.print("\nChoisir le contact: ");
        int choice;
        do {
            choice = scanner.nextInt();
        } while (!isContactChoiceValid(choice));
        System.out.println("idsnqf");
        return choice;
    }

    public void displayContainLetter(boolean bool) {
        System.out.println(bool ? "true" : "false");
    }

    public void displayNumbersOfContacts(int number) {
        System.out.println("\nNombres de contacts: " + number);
    }

    private boolean isContactChoiceValid(int choice) {
//        System.out.println(choice + " " + contactService.getContacts().size());
        System.out.println(choice < 1);
        System.out.println(choice > contactService.getContacts().size());
        return choice < 1 || choice > contactService.getContacts().size();

    }
}

