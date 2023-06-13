package org.learning.java.GestorEventi;

//MILESTONE 2
//  1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
//  2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo eventuali eccezioni.
//  3. Stampare a video il numero di posti prenotati e quelli disponibili
//  4. Chiedere all’utente se e quanti posti vuole disdire
//  5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo eventuali eccezioni
//  6. Stampare a video il numero di posti prenotati e quelli disponibili


import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
  public static void main(String[] args) {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner scanner = new Scanner(System.in);
    
    Event evento = null;
    boolean incorrectEvent = true;
    
    System.out.println("Crea un evento:");
    int choiceEventType;
    
    do {
    System.out.println("vuoi creare un evento generico o un concerto?");
    System.out.println("Digita 1 per un evento generico, 2 per un concerto");
      
      choiceEventType = Integer.parseInt(scanner.nextLine());
    
    } while (choiceEventType<1 || choiceEventType>2);
    
    do {
      try {
        System.out.println("Nome evento: ");
        String title = scanner.nextLine();
        System.out.println("Data evento (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Capacità posti: ");
        int totalSeats = Integer.parseInt(scanner.nextLine());
        
        if (choiceEventType == 1) {
          evento = new Event(title, date, totalSeats);
//        incorrectEvent = true;
        }
        else {
          System.out.println("Inserisci l'orario del concerto (HH:mm)");
          LocalTime concertTime = LocalTime.parse(scanner.nextLine());
          
          System.out.println("Inserisci il prezzo del biglietto");
          BigDecimal concertPrice = new BigDecimal(scanner.nextLine());
          evento = new Concert(title, date, totalSeats, concertTime, concertPrice);
//          incorrectEvent = true;
        }
        System.out.println("Evento creato correttamente: " + evento);
        
      } catch (Exception e) {
        incorrectEvent = false;
        System.out.println("Errore: " + e.getMessage());
        System.out.println("Inserire nuovamente i dati dell'evento.");
      }
    } while (!incorrectEvent);
    
    
    System.out.println("Vuoi prenotare dei posti?");
    System.out.println("se si inserisci il numero di posti prenotati, altrimenti digita '0'");
    int choicebooking = Integer.parseInt(scanner.nextLine());
    
    if (choicebooking > 0) {
      for (int i = 0; i < choicebooking; i++) {
        try{
        evento.bookASeat();
        }
        catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
      System.out.println("Grazie per la prenotazione!");
      System.out.println("hai prenotato " + evento.getBookedSeats() + " posti.");
      
      boolean correctCancelling = false;
      do {
      
      System.out.println("Vuoi disdire una prenotazione?");
      System.out.println("se si inserisci il numero delle prenotazioni che vuoi disdire, altrimenti digita '0'");
      
      int choiceCancelling = Integer.parseInt(scanner.nextLine());
      
      if (choiceCancelling > 0) {
          try {
            for (int i = 0; i < choiceCancelling; i++) {
              evento.cancelBooking(choiceCancelling);
            }
            correctCancelling = true;
          }
          catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
      
      }
      while (!correctCancelling);
    }
    else System.out.println("Evento creato correttamente: " + evento);
    
    
    System.out.println("posti prenotati: " + evento.getBookedSeats());
    System.out.println("posti totali: " + (evento.getTotalSeats() - evento.getBookedSeats()));
  }
}
