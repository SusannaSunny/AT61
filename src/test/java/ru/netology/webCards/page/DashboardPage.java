package ru.netology.webCards.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement head = $("[data-test-id=dashboard]");
    private static SelenideElement cardIdFirst =  $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button");
    private static SelenideElement cardIdSecond = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button");

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage(){
    }

public static TransferMoneyPage pushCardIdFirst() {
    cardIdFirst.click();
    return new TransferMoneyPage();
}

public static TransferMoneyPage pushCardIdSecond() {
    cardIdSecond.click();
    return new TransferMoneyPage();
    }

    public int getCardBalanceFirst() {
    val text = cards.first().text();
        return benefitBalance(text);
    }

    public int getCardBalanceSecond() {
        val text = cards.first().text();
        return benefitBalance(text);
    }

    private int benefitBalance(String text) {
    val start = text.indexOf(balanceStart);
    val finish = text.indexOf(balanceFinish);
    val value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);
    }

}

