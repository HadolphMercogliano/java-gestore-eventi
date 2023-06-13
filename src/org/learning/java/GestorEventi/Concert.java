package org.learning.java.GestorEventi;
//MILESTONE 3
//  Creare una classe Concerto che estende Evento, che ha anche gli attributi :
//  ● ora: LocalTime
//  ● prezzo: BigDecimal Aggiungere questi attributi nel costruttore e implementarne getter e setter
//  Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)
//  Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
  private LocalTime concertTime;
  private BigDecimal concertPrice;
  
  public Concert(String title, LocalDate date, int totalSeats, LocalTime concertTime, BigDecimal concertPrice) throws Exception {
    super(title, date, totalSeats);
    this.concertTime = concertTime;
    
    if (concertPrice.compareTo(BigDecimal.ZERO)<=0) {
      throw new Exception("Il prezzo deve essere maggiore di 0");
    }
    else this.concertPrice = concertPrice;
  }
  
  public String getFormattedDateTime() {
    return getDate() + " - " + concertTime;
  }
  
  public String getFormattedPrice() {
    DecimalFormat decimalFormat = new DecimalFormat("###.## €");
    return decimalFormat.format(concertPrice);
  }
  
 
  public void setConcertTime(LocalTime concertTime) {
    this.concertTime = concertTime;
  }
  
  public void setConcertPrice(BigDecimal concertPrice) throws Exception {
    if (concertPrice.compareTo(BigDecimal.ZERO)<=0) {
      throw new Exception("Il prezzo deve essere maggiore di 0");
    }
    else this.concertPrice = concertPrice;
  }
  
  @Override
  public String toString() {
    
    return getFormattedDateTime() + " - " + getTitle() + " - " + getFormattedPrice();
  }
}

