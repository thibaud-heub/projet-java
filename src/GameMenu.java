    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import characters.*;
    import weapons.*;


    public class GameMenu extends JFrame {
        // utilisation de CardLayout pour basculer entre différents panels (écrans)
        private CardLayout cardLayout = new CardLayout();
        private JPanel mainPanel = new JPanel(cardLayout);
        private JPanel menuPanel = new JPanel(null);
        private JPanel characterSelectPanel = new JPanel(null);
        private JPanel warriorWeaponPanel = new JPanel(null);
        private JPanel rogueWeaponPanel = new JPanel(null); 
        private JPanel wizardWeaponPanel = new JPanel(null);
        private character selectedCharacter;
        private weapon selectedWeapon;


        public GameMenu() {
            setTitle("DnD Game Menu"); // Titre de la fenêtre
            setSize(800, 600); // Taille de la fenêtre
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportement à la fermeture
            setLocationRelativeTo(null); // Centrer la fenêtre
            //menuPanel = new BackgroundPanel("../ressources/background/background_minecraft.jpg");


            createMenuPanel();
            createCharacterSelectPanel();
            createWarriorWeaponPanel();
            createRogueWeaponPanel();
            createWizardWeaponPanel();

            mainPanel.add(menuPanel, "Menu");
            mainPanel.add(characterSelectPanel, "CharacterSelect");
            mainPanel.add(warriorWeaponPanel, "WarriorWeapon");
            mainPanel.add(rogueWeaponPanel, "RogueWeapon");
            mainPanel.add(wizardWeaponPanel, "WizardWeapon");

            add(mainPanel);
        }
            
        private void createMenuPanel() {
            JLabel playLabel = new JLabel("Jouer", SwingConstants.CENTER);
            JLabel quitLabel = new JLabel("Quitter", SwingConstants.CENTER);

            playLabel.setBounds(150, 200, 500, 50);
            playLabel.setBackground(Color.BLUE);
            playLabel.setOpaque(true);
            playLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardLayout.show(mainPanel, "CharacterSelect");
                }
            });

            quitLabel.setBounds(150, 350, 500, 50);
            quitLabel.setBackground(Color.RED);
            quitLabel.setOpaque(true);
            quitLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });

        menuPanel.add(playLabel);
        menuPanel.add(quitLabel);
    }

    private void createCharacterSelectPanel() {
        JLabel warriorLabel = new JLabel("Guerrier", SwingConstants.CENTER);
        JLabel rogueLabel = new JLabel("Chasseur", SwingConstants.CENTER);
        JLabel wizardLabel = new JLabel("Sorcier", SwingConstants.CENTER);

        //label pour la sélection de personnages
        warriorLabel.setBounds(100, 250, 180, 50);
        warriorLabel.setBackground(Color.GRAY);
        warriorLabel.setOpaque(true);

        rogueLabel.setBounds(300, 250, 180, 50);
        rogueLabel.setBackground(Color.GRAY);
        rogueLabel.setOpaque(true);

        wizardLabel.setBounds(500, 250, 180, 50);
        wizardLabel.setBackground(Color.GRAY);
        wizardLabel.setOpaque(true);

        // Ajouter des écouteurs de souris pour chaque label
        warriorLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Guerrier");
                cardLayout.show(mainPanel, "WarriorWeapon");
            }
        });

        rogueLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Chasseur");
                cardLayout.show(mainPanel, "RogueWeapon");
            }
        });

        wizardLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Sorcier");
                cardLayout.show(mainPanel, "WizardWeapon");
            }
        });

        characterSelectPanel.add(warriorLabel);
        characterSelectPanel.add(rogueLabel);
        characterSelectPanel.add(wizardLabel);
    }


    private void createWarriorWeaponPanel() {
        JLabel shieldAndSwordLabel = new JLabel("Epée et Bouclier", SwingConstants.CENTER);
        JLabel bigSwordLabel = new JLabel("Grande épée", SwingConstants.CENTER);

        // label pour la sélection d'armes
        shieldAndSwordLabel.setBounds(150, 250, 240, 50);
        shieldAndSwordLabel.setBackground(Color.GRAY);
        shieldAndSwordLabel.setOpaque(true);

        bigSwordLabel.setBounds(400, 250, 240, 50);
        bigSwordLabel.setBackground(Color.GRAY);
        bigSwordLabel.setOpaque(true);


        // Ajouter des écouteurs de souris pour chaque label
        shieldAndSwordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Epée et Bouclier");
                selectWarriorWeapon(new sword());
            }
        });

        bigSwordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Grande épée");
                selectWarriorWeapon(new bigSword());
            }
        });

        warriorWeaponPanel.add(shieldAndSwordLabel);
        warriorWeaponPanel.add(bigSwordLabel);
    }

    private void selectWarriorWeapon(weapon weapon) {
        selectedWeapon = weapon;
        selectedCharacter = new warrior(selectedWeapon);
        launchGame();
    }

    private void createRogueWeaponPanel() {
        JLabel spikeLabel = new JLabel("Dague", SwingConstants.CENTER);
        JLabel hoeLabel = new JLabel("Katana", SwingConstants.CENTER);

        // label pour la sélection d'armes
        spikeLabel.setBounds(150, 250, 240, 50);
        spikeLabel.setBackground(Color.GRAY);
        spikeLabel.setOpaque(true);
        
        hoeLabel.setBounds(400, 250, 240, 50);
        hoeLabel.setBackground(Color.GRAY);
        hoeLabel.setOpaque(true);

        // Ajouter des écouteurs de souris pour chaque label
        spikeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Dague");
                selectRogueWeapon(new spike());

            }
        });

        hoeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Katana");
                selectRogueWeapon(new katana());

            }
        });

        rogueWeaponPanel.add(spikeLabel);
        rogueWeaponPanel.add(hoeLabel);
    }

    private void selectRogueWeapon(weapon weapon) {
        selectedWeapon = weapon;
        selectedCharacter = new hunter(selectedWeapon);
        launchGame();
    }

    private void createWizardWeaponPanel() {
        JLabel wandLabel = new JLabel("Bâton", SwingConstants.CENTER);
        JLabel bigWandLabel = new JLabel("Grand bâton", SwingConstants.CENTER);

        // label pour la sélection d'armes
        wandLabel.setBounds(150, 250, 240, 50);
        wandLabel.setBackground(Color.GRAY);
        wandLabel.setOpaque(true);

        bigWandLabel.setBounds(400, 250, 240, 50);
        bigWandLabel.setBackground(Color.GRAY);
        bigWandLabel.setOpaque(true);

        // Ajouter des écouteurs de souris pour chaque label
        wandLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Bâton");
                selectWizardWeapon(new magicWand());
            }
        });

        bigWandLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Grand bâton");
                selectWizardWeapon(new bigMagicWand());

            }
        });

        wizardWeaponPanel.add(wandLabel);
        wizardWeaponPanel.add(bigWandLabel);
    }

    private void selectWizardWeapon(weapon weapon) {
        selectedWeapon = weapon;
        selectedCharacter = new witcher(selectedWeapon);
        launchGame();
    }

    private void launchGame() {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game(selectedCharacter);
            game.setVisible(true);
            GameMenu.this.dispose(); 
        });
    }


        public static void main(String[] args) {
            // Lance l'interface du menu dans le thread de gestion des événements Swing
            SwingUtilities.invokeLater(() -> {
                new GameMenu().setVisible(true);
            });
        }

    }