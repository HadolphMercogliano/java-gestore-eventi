package org.learning.java.GestorEventi;

//MILESTONE 2
//  1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
//  2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo eventuali eccezioni.
//  3. Stampare a video il numero di posti prenotati e quelli disponibili
//  4. Chiedere all’utente se e quanti posti vuole disdire
//  5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo eventuali eccezioni
//  6. Stampare a video il numero di posti prenotati e quelli disponibili


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
  public static void main(String[] args) {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner scanner = new Scanner(System.in);
  
    System.out.println("Benvenuti in biglietteria");
    System.out.println("**************************");
    
    Event evento1 = null;
    boolean correctEvent = false;
    
    do {
      try {
        System.out.println("Crea un evento:");
        System.out.println("Nome evento: ");
        String title = scanner.nextLine();
        System.out.println("Data evento (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Capacità posti: ");
        int totalSeats = Integer.parseInt(scanner.nextLine());
        
        evento1 = new Event(title, date, totalSeats);
        correctEvent = true;
      } catch (Exception e) {
        System.out.println("Errore: " + e.getMessage());
        System.out.println("Inserire nuovamente i dati dell'evento.");
      }
    } while (!correctEvent);
    
    
    System.out.println("Vuoi prenotare dei posti?");
    System.out.println("se si inserisci il numero di posti prenotati, altrimenti digita '0'");
    int choicebooking = Integer.parseInt(scanner.nextLine());
    
    if (choicebooking > 0) {
      for (int i = 0; i < choicebooking; i++) {
        try{
        evento1.bookASeat();
        }
        catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      System.out.println("Grazie per la prenotazione!");
      System.out.println("hai prenotato " + evento1.getBookedSeats() + " posti.");
      
      
      System.out.println("Vuoi disdire una prenotazione?");
      System.out.println("se si inserisci il numero delle prenotazioni che vuoi disdire, altrimenti digita '0'");
      
      int choicecancelling = Integer.parseInt(scanner.nextLine());
      
      if (choicecancelling > 0) {
        for (int i = 0; i < choicecancelling; i++) {
          try{
            evento1.cancelBooking();
          }
          catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
    else {
      System.out.println("Evento creato correttamente: " + evento1);
    }
    
    System.out.println("posti prenotati: " + evento1.getBookedSeats());
    System.out.println("posti totali: " + (evento1.getTotalSeats() - evento1.getBookedSeats()));
  }
}
