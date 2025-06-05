package Src.Entities;

import Src.Enums.EventType;

import java.math.BigDecimal;

public class Event {
    public int id;
    public String name;
    public int durationDays;
    public BigDecimal dayPrice;
    public EventType eventType;
    private BigDecimal total;
    public int vacancies;
    public int vacanciesVip;
    public Event(int id, String name, int durationDays, BigDecimal dayPrice, EventType eventType, int vacancies) {
        this.id = id;
        this.name = name;
        this.durationDays = durationDays;
        this.dayPrice = dayPrice;
        this.eventType = eventType;
        this.vacancies = vacancies;
        if(eventType == EventType.SHOW) {
            this.vacanciesVip = (int) (vacancies * 0.1);
        } else {
            this.vacanciesVip = 0;
        }
        this.calculateTotal();

    }
    private void calculateTotal() {
        this.total = this.dayPrice.multiply(new BigDecimal(this.durationDays));
    }
    public BigDecimal getTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Tipo: " + this.eventType + "\n" +
                "Duração: " + this.durationDays + "\n" +
                "Preço por dia: " + this.dayPrice + "\n" +
                "Total: " + this.total + "\n" +
                "Vagas: " + this.vacancies + "\n" +
                "Vagas VIP: " + this.vacanciesVip + "\n";
    }
}
