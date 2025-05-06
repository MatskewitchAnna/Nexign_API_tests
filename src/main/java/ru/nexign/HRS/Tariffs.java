package ru.nexign.HRS;

public class Tariffs {
    private String outcomingCallerId;
    private String tariffUuid;
    private String operatorName;
    private String startCallTime;
    private String finishCallTime;
    private int balance;
    private int minutes;


    public Tariffs() {
    }

    public Tariffs(String outcomingCallerId, String tariffUuid, String operatorName, String startCallTime, String finishCallTime, int balance, int minutes) {
        this.outcomingCallerId = outcomingCallerId;
        this.tariffUuid = tariffUuid;
        this.operatorName = operatorName;
        this.startCallTime = startCallTime;
        this.finishCallTime = finishCallTime;
        this.balance = balance;
        this.minutes = minutes;
    }

    public String getOutcomingCallerId() {
        return outcomingCallerId;
    }

    public void setOutcomingCallerId(String outcomingCallerId) {
        this.outcomingCallerId = outcomingCallerId;
    }

    public String getTariffUuid() {
        return tariffUuid;
    }

    public void setTariffUuid(String tariffUuid) {
        this.tariffUuid = tariffUuid;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStartCallTime() {
        return startCallTime;
    }

    public void setStartCallTime(String startCallTime) {
        this.startCallTime = startCallTime;
    }

    public String getFinishCallTime() {
        return finishCallTime;
    }

    public void setFinishCallTime(String finishCallTime) {
        this.finishCallTime = finishCallTime;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
