package messages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Historique {
    private ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        String fichierLecture = args.length > 0 ? args[0] : "historique.test.in";
        String fichierEcriture = args.length > 1 ? args[1] : "historique.test.out";

        System.out.println("\n=> TEST Écrire le contenu de l'historique dans le fichier " + fichierEcriture);
        Historique historique = new Historique();
        historique.ajouter(new MessageEntrant("Admin: Bienvenue sur le serveur"));
        historique.ajouter(new MessageSortant("Allo tout le monde!"));
        historique.ajouter(new MessageEntrant("Alice: Salut Bob!"));
        historique.ajouter(new MessageEntrantPrive("@Bob Charlie: Yo, tu as fini le TP?"));
        historique.ajouter(new MessageSortantPrive("@Charlie Pas encore mais presque, toi?"));
        historique.ecrire(fichierEcriture);

        System.out.println("\n=> TEST Lire le contenu de l'historique depuis le fichier " + fichierLecture);
        historique.vider();
        historique.lire(fichierLecture);
        for (Message m : historique.getMessages())
            System.out.println(m);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void ajouter(Message m) {
        messages.add(m);
    }

    public void vider() {
        messages.clear();
    }

    public int lire(String cheminFichier) {
        int nbMessagesLus = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Message message = creationMessage(line);
                messages.add(message);
                nbMessagesLus++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Lecture de l'historique depuis %s (%d lignes)\n", cheminFichier, nbMessagesLus);
        return nbMessagesLus;
    }

    // Méthode qui permet de créer un objet Message à partir d'une ligne dans un fichier texte.
    public Message creationMessage(String line) {
        if (line.startsWith("Admin:"))
            return new MessageEntrant(line);
        else if (line.startsWith("@"))
            return new MessageEntrantPrive(line);
        else
            return new MessageSortant(line);
    }

    public int ecrire(String cheminFichier) {
        int nbMessagesEcrits = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            for (Message message : messages) {
                writer.write(message.toString());
                writer.newLine();
                nbMessagesEcrits++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Écriture de l'historique terminée dans %s (%d lignes)\n", cheminFichier, nbMessagesEcrits);
        return nbMessagesEcrits;
    }
}