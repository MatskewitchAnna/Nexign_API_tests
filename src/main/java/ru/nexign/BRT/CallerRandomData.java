package ru.nexign.BRT;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.util.Random;

public class CallerRandomData {

    public static Callers randomCaller(){
        final String msisdn = "7900" + RandomStringUtils.randomNumeric(7);
        //выбираем между существующими тарифами с uuid 11 "Классика" и 12 "Помесячный"
        final String tariffUuid = String.valueOf(11 + (int)(Math.random() * 2));
        final String surname = RandomStringUtils.randomAlphabetic(5);
        final String name = RandomStringUtils.randomAlphabetic(5);
        final String patronymic = RandomStringUtils.randomAlphabetic(5);
        final int minutes = (int)(Math.random() * 401) + 100;//выбираем рандомно минуты от 100 до 500
        final int balance = (int)(Math.random() * 401) + 100; //выбираем рандомно баланс от 100 до 500
        final String nextPayDate = String.valueOf(LocalDate.now().minusMonths(1).plusDays(new Random().nextInt(31)));
        return new Callers(msisdn, tariffUuid, surname, name, patronymic, minutes, balance, nextPayDate);
    }
}
