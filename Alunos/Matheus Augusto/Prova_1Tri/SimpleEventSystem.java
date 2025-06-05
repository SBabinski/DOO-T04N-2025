package Prova_1tri;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleEventSystem {
    private static EventManager manager = new EventManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSampleEvents();
        
        System.out.println("=== Sistema de Eventos ===");
        
        boolean running = true;
        while (running) {
            System.out.println("1. Listar Todos Eventos");
            System.out.println("2. Comprar Ticket");
            System.out.println("3. Usar Ticket");
            System.out.println("4. Sair");
            
            int choice = getIntInput("Insira sua escolha: ");
            
            switch (choice) {
                case 1:
                    listEvents();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    useTicket();
                    break;
                case 4:
                    running = false;
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Escolha invalida.");
            }
        }
        scanner.close();
    }

    private static void initializeSampleEvents() {
        // Sample events
        List<String> concertDates = Arrays.asList("2025-12-25", "2025-12-26");
        manager.createEvent(new Show("E001", "Show Avenged Sevenfold", "Show de Metal", 
                                   concertDates, 50.0, 100, 20.0));
        
        List<String> conferenceDates = Arrays.asList("2024-01-10");
        manager.createEvent(new Congress("E002", "Conferência Tech", "Conferência Tech Anual", 
                                      conferenceDates, 100.0, 50));
    }

    private static void listEvents() {
        System.out.println("\n--- Eventos Disponíveis ---");
        for (Event event : manager.getAllEvents()) {
            System.out.println(event);
            System.out.println("Espaços Disponíveis: " + event.getAvailableSpots());
            if (event instanceof Show) {
                Show show = (Show) event;
                System.out.println("Espaços VIP Disponíveis: " + show.getAvailableVipSpots());
            }
            System.out.println("----------------------");
        }
    }

    private static void buyTicket() {
        System.out.println("\n--- Comprar Ticket ---");
        listEvents();
        
        String eventId = getStringInput("Insira ID do evento: ");
        Event event = manager.getEvent(eventId);
        
        if (event == null) {
            System.out.println("Evento não encontrado!");
            return;
        }
    
        if (event.getAvailableSpots() <= 0) {
            System.out.println("Ingressos esgotados para este evento!");
            return;
        }
    
        String clientName = getStringInput("Insira seu Nome: ");
        String clientId = "C-" + clientName.replaceAll("\\s+", "").toUpperCase();
        
        int days = getIntInput("Quantos dias irá participar? (1-" + event.getDates().size() + "): ");
        days = Math.max(1, Math.min(days, event.getDates().size()));
    
        boolean isVip = false;
        
        if (event instanceof Show) {
            Show show = (Show) event;
            if (show.getAvailableVipSpots() > 0) {
                String vipChoice = getStringInput("Gostaria de tickets VIP? (s/n): ").toLowerCase();
                isVip = vipChoice.equals("s");
                
                if (isVip) {
                    if (show.getAvailableVipSpots() <= 0) {
                        System.out.println("VIP esgotado, comprando ingresso normal.");
                        isVip = false;
                    }
                }
            }
        }
        
        Ticket ticket = manager.buyTicket(eventId, clientId, days, isVip);
        
        if (ticket == null) {
            System.out.println("Não foi possível comprar o ingresso. Pode ter esgotado.");
            return;
        }
    
        System.out.println("\n✅ Ingresso comprado com sucesso!");
        System.out.println("ID do Ingresso: " + ticket.getId());
        System.out.println("Evento: " + event.getName());
        System.out.println("Dias: " + days);
        System.out.printf("Valor Total: R$%.2f%n", ticket.getPrice());
        if (isVip) {
            System.out.println("(Ticket VIP)");
        }
    }

    private static void useTicket() {
        System.out.println("\n--- Usar Ticket ---");
        String ticketId = getStringInput("Insira o ID do seu Ticket: ");
        
        boolean used = manager.useTicket(ticketId);
        if (used) {
            System.out.println("Ticket usado com sucesso. Aproveite o evento!");
        } else {
            System.out.println("Ticket invalido ou ja foi utilizado.");
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Use um numero valido.");
            scanner.next();
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
