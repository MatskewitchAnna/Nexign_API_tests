package ru.nexign.BRT;

public class Callers {
    private String msisdn;
    private String tariffUuid;
    private String surname;
    private String name;
    private String patronymic;
    private int minutes;
    private int balance;
    private String nextPayDate;
    private String callerUuid;
    private int amount;

    public Callers(String msisdn, String tariffUuid, String surname, String name, String patronymic, int minutes, int balance, String nextPayDate) {
        this.msisdn = msisdn;
        this.tariffUuid = tariffUuid;
        this.surname = surname;
        this.name = name;
        this.minutes = minutes;
        this.patronymic = patronymic;
        this.nextPayDate = nextPayDate;
        this.balance = balance;
    }

    public Callers() {
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTariffUuid() {
        return tariffUuid;
    }

    public void setTariffUuid(String tariffUuid) {
        this.tariffUuid = tariffUuid;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(String nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    public String getCallerUuid() {
        return callerUuid;
    }

    public void setCallerUuid(String callerUuid) {
        this.callerUuid = callerUuid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
