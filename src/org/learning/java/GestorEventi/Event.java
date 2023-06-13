package org.learning.java.GestorEventi;
import java.time.LocalDate;

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
  private String title;
  private LocalDate date;
  private final int postiTotali;
  private int postiPrenotati;
  
  public Event(String title, LocalDate date, int postiTotali, int postiPrenotati) {
    this.title = title;
    this.date = date;
    this.postiTotali = postiTotali;
    this.postiPrenotati = 0;
  }
  
  public String getTitle() {
    return title;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public int getPostiTotali() {
    return postiTotali;
  }
  
  public int getPostiPrenotati() {
    return postiPrenotati;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setDate(LocalDate date) {
    this.date = date;
  }
}


