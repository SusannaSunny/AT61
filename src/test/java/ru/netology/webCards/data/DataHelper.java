package ru.netology.webCards.data;

import lombok.Value;

public class DataHelper {

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        String cardNumber;
    }

    public static CardInfo getCardNumberFirst() {

        return new CardInfo("5559 0000 0000 0001");
    }

    public static CardInfo getCardNumberSecond() {

        return new CardInfo("5559 0000 0000 0002");
    }

}
