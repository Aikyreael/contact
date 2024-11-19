package school.exercice.contact.controllers;

import org.springframework.stereotype.Controller;
import school.exercice.contact.services.ContactService;
import school.exercice.contact.ui.ConsoleUI;

@Controller
public class MainController {

    private final ContactService contactService;
    private final ConsoleUI consoleUI;

    public MainController(ContactService contactService, ConsoleUI consoleUI) {
        this.contactService = contactService;
        this.consoleUI = consoleUI;
    }

    public void run() {
        int choice;
        do {
            consoleUI.displayMenu();
            choice = consoleUI.getUserInput();
            this.handleChoice(choice);
        } while ( choice !=9);
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1 -> contactService.addContact(consoleUI.addContact());
            case 2 -> consoleUI.displayContacts();
//            case 3 -> ;
            case 4 -> {
                consoleUI.displayContacts();
                contactService.deleteContact(consoleUI.selectContact());
            }

//            case 6 -> ;
            case 7 -> consoleUI.displayNumbersOfContacts(contactService.numbersOfContacts());
            case 8 -> {
                consoleUI.displayContacts();
                consoleUI.displayContainLetter(
                        contactService.contactContainLetter(consoleUI.selectContact()));
            }
            case 9 -> contactService.resetContacts();
            default -> System.out.println("Choisir un nombre valide");
        }
    }
}
