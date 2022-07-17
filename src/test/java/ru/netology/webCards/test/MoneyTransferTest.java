package ru.netology.webCards.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.webCards.data.DataHelper;
import ru.netology.webCards.page.DashboardPage;
import ru.netology.webCards.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.webCards.data.DataHelper.getCardNumberFirst;
import static ru.netology.webCards.data.DataHelper.getCardNumberSecond;
import static ru.netology.webCards.page.DashboardPage.pushCardIdSecond;
import static ru.netology.webCards.page.DashboardPage.pushCardIdFirst;

public class MoneyTransferTest {

    @BeforeEach
    void set() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val cardBalancePage = verificationPage.validVerify(verificationCode);
    }


    @Test
    void shouldTransferMoneyOnSecondFirstCard() {
        val dashboardPage = new DashboardPage();
        int invoiceAmount = 5000;
        int expectedBalanceFirstCard = dashboardPage.getCardBalanceFirst();
        int expectedBalanceSecondCard = dashboardPage.getCardBalanceSecond();
        val transferMoneyPage = pushCardIdFirst();
        transferMoneyPage.moneyTransfer(invoiceAmount, getCardNumberSecond());
        assertEquals(expectedBalanceFirstCard + invoiceAmount, dashboardPage.getCardBalanceFirst());
        assertEquals(expectedBalanceSecondCard - invoiceAmount, dashboardPage.getCardBalanceSecond());
        val transferMoneyPageAway = pushCardIdSecond();
        transferMoneyPageAway.moneyTransferClick(getCardNumberFirst());
        assertEquals(expectedBalanceFirstCard, dashboardPage.getCardBalanceFirst());
        assertEquals(expectedBalanceSecondCard, dashboardPage.getCardBalanceSecond());
    }


    @Test
    void shouldTransferZeroMoneyOnFirstCard() {
        //val dashboardPage = new DashboardPage();
        int invoiceAmount = 0;
        val transferMoneyPage = pushCardIdFirst();
        transferMoneyPage.moneyTransfer(invoiceAmount, getCardNumberSecond());
        transferMoneyPage.errorLimit();
    }

    @Test
    void shouldTransferMoneyFromFirstOnFirstCard() {
        //val dashboardPage = new DashboardPage();
        int invoiceAmount = 6000;
        val transferMoneyPage = pushCardIdFirst();
        transferMoneyPage.moneyTransfer(invoiceAmount, getCardNumberFirst());
        transferMoneyPage.invalidCard();
    }
}
