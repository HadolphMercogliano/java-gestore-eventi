package org.learning.java.GestorEventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//MILESTONE 1
//  La consegna è di creare una classe Evento che abbia le seguenti proprietà:
  //  ● titolo
  //  ● data
  //  ● numero di posti in totale
  //  ● numero di posti prenotati
//  Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore,
//  tranne posti prenotati che va inizializzato a 0.
//  Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo.
//  In caso contrario sollevare opportune eccezioni.
//  Aggiungere metodi getter e setter in modo che:
  //  ● titolo sia in lettura e in scrittura
  //  ● data sia in lettura e scrittura
  //  ● numero di posti totale sia solo in lettura
  //  ● numero di posti prenotati sia solo in lettura
//  Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
  //  1. prenota : aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve sollevare un’eccezione.
  //  2. disdici : riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni deve sollevare un’eccezione.
  //  3. l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
//  Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
public class Event {
  
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  
  private String title;
  private LocalDate date;
  private int totalSeats;
  private int bookedSeats;
  
  public Event(String title, LocalDate date, int totalSeats ) throws Exception {
    if (date.isBefore(LocalDate.now())) {
      throw new Exception("La data dell'evento non può essere passata.");
    }
    
    if (totalSeats <= 0) {
      throw new Exception("Il numero di posti totali deve essere maggiore di 0");
    }
    this.title = title;
    this.date = date;
    this.totalSeats = totalSeats;
    this.bookedSeats = 0;
  }
  
  public String getTitle() {
    return title;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public int getTotalSeats() {
    return totalSeats;
  }
  
  public int getBookedSeats() {
    return bookedSeats;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setDate(LocalDate date) throws Exception {
    if (date.isBefore(LocalDate.now())) {
      throw new Exception("La data dell'evento non può essere passata.");
    }
    else this.date = date;
  }
  public void bookASeat()throws Exception {
    if (bookedSeats >= totalSeats){
      throw new Exception("Posti esauriti");
    }
    else if (date.isBefore(LocalDate.now())) {
      throw new Exception("L' evento è scaduto");
    }
    else bookedSeats++;
  }
  public void cancelBooking() throws Exception{
    if (bookedSeats == 0) {
      throw new Exception("Non ci sono prenotazioni");
    }
    else if (date.isBefore(LocalDate.now())) {
      throw new Exception("L' evento è già passato");
    }
    else bookedSeats--;
  }
  
  @Override
  public String toString() {
    return date.format(formatter) + " - " + title;
  }
}


