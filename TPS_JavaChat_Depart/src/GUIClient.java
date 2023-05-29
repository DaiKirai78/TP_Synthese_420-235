import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class GUIClient extends ChatClient {
    JFrame frame;
    JTextArea chatBox;
    JTextField sendBox;
    GUIClient.ConnexionDialog connexion;

    public static void main(String[] args) {
        String nom = args.length > 0 ? args[0] : "guest";
        GUIClient client = new GUIClient(nom);
        client.connecter();
    }

    /**
     * Construit un client de clavardage graphique.
     *
     * @param userName Le nom d'utilisateur souhaité.
     */
    public GUIClient(String userName) {
        super(userName);

        frame = new JFrame("JavaChat");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setJMenuBar(creerMenu());
        sendBox = new JTextField();
        sendBox.setText("Entrez votre message");

        chatBox = new JTextArea();
        chatBox.setLineWrap(true);
        chatBox.setEditable(false);
        chatBox.append("Vous devez d'abord vous connecter!");
        JScrollPane chatPane = new JScrollPane(chatBox);
        frame.add(chatPane, BorderLayout.CENTER);

        // Placeholder créé à l'aide de :
        // https://1bestcsharp.blogspot.com/2018/02/java-placeholder.html
        sendBox = new JTextField();
        sendBox.setText("Entrez votre message");
        sendBox.setForeground(Color.GRAY);
        sendBox.addFocusListener(new FocusListener() {
            // Lorsque sendBox gagne le focus
            @Override
            public void focusGained(FocusEvent e) {
                if (sendBox.getText().equals("Entrez votre message")) {
                    sendBox.setText("");
                    sendBox.setForeground(Color.BLACK);
                }
            }

            // Lorsque sendBox perd le focus
            @Override
            public void focusLost(FocusEvent e) {
                if (sendBox.getText().isEmpty()) {
                    sendBox.setText("Entrez votre message");
                    sendBox.setForeground(Color.GRAY);
                }
            }
        });

        JButton envoyerBouton = new JButton("Envoyer");
        envoyerBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = sendBox.getText();
                send(message);
                chatBox.append("Moi: " + message + "\n");
                sendBox.setText("");
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(sendBox, BorderLayout.CENTER);
        bottomPanel.add(envoyerBouton, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        // L'item Fichier dans la barre de menu
        JMenu fichierMenu = new JMenu("Fichier");
        // Lorsqu'on appuie sur « Fichier », les options « Se Connecter » et « Quitter » apparaissent.
        JMenuItem seConnecterItem = new JMenuItem("Se connecter");
        seConnecterItem.addActionListener(e -> connecter()); // Event listener lorsqu'on appuie sur l'option de connexion
        JMenuItem quitterItem = new JMenuItem("Quitter");
        quitterItem.addActionListener(e -> System.exit(0)); // Event listener lorsqu'on appuie sur l'option pour quitter
        fichierMenu.add(seConnecterItem);
        fichierMenu.add(quitterItem);

        // L'item Historique dans la barre de menu
        JMenu historiqueMenu = new JMenu("Historique");
        // Lorsqu'on appuie sur « Fichier », les options « Se Connecter » et « Quitter » apparaissent.
        JMenuItem importerItem = new JMenuItem("Importer");
        importerItem.addActionListener(e -> chargerHistorique()); // Event listener lorsqu'on appuie sur l'option d'importation
        JMenuItem exporterItem = new JMenuItem("Exporter");
        exporterItem.addActionListener(e -> sauvegarderHistorique()); // Event listener lorsqu'on appuie sur l'option d'exportation
        historiqueMenu.add(importerItem);
        historiqueMenu.add(exporterItem);

        menuBar.add(fichierMenu);
        menuBar.add(historiqueMenu);

        return menuBar;
    }

    @Override
    public String sauvegarderHistorique() {
        String cheminFichier = super.sauvegarderHistorique();
        JOptionPane.showMessageDialog(frame, "Historique sauvegardé dans " + cheminFichier);
        return cheminFichier;
    }

    public void connecter() {
        if (connexion == null)
            connexion = new ConnexionDialog(frame);
        connexion.setVisible(true);
        chatBox.setText("");
        sendBox.setEnabled(true);
    }

    private class ConnexionDialog extends JDialog {
        private JTextField champsUsername;
        private JTextField champsServeur;
        private JTextField champsPort;

        public ConnexionDialog(JFrame parent) {
            super(parent, "Connexion", ModalityType.DOCUMENT_MODAL);
            this.setSize(300, 200);

            // Composants pour demander l'information
            JLabel userLabel = new JLabel("Nom d'utilisateur:");
            champsUsername = new JTextField();
            JLabel hostAddrLabel = new JLabel("Adresse du serveur:");
            champsServeur = new JTextField();
            JLabel hostPortLabel = new JLabel("Port de l'application:");
            champsPort = new JTextField();

            // Ajouter les panneaux
            JPanel panel = new JPanel(new GridLayout(3, 2));
            panel.add(userLabel);
            panel.add(champsUsername);
            panel.add(hostAddrLabel);
            panel.add(champsServeur);
            panel.add(hostPortLabel);
            panel.add(champsPort);
            this.add(panel, BorderLayout.CENTER);

            JButton connectButton = new JButton("Rejoindre");
            connectButton.addActionListener(e -> {
                this.setVisible(false);
                connecter(champsServeur.getText(), Integer.parseInt(champsPort.getText()));
            });
            this.add(connectButton, BorderLayout.SOUTH);
            this.getRootPane().setDefaultButton(connectButton);
        }
    }

    @Override
    protected void display(String str) {
        chatBox.append(str + "\n");
        chatBox.setCaretPosition(chatBox.getDocument().getLength());
    }
}




