package ru.netology.webCards.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement head = $("[data-test-id=dashboard]");
    private static SelenideElement cardIdFirst = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button");
    private static SelenideElement cardIdSecond = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button");

    private ElementsCollection cardsF = $$("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private final String balanceStartNF = " баланс: ";
    private final String balanceFinishNF = " р.";

    private ElementsCollection cardsS = $$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private final String balanceStartNS = " баланс: ";
    private final String balanceFinishNS = " р.";

    public DashboardPage() {
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
        val textF = cardsF.first().text();
        return benefitBalanceF(textF);
    }

    public int getCardBalanceSecond() {
        val textS = cardsS.first().text();
        return benefitBalanceS(textS);
    }

    private int benefitBalanceF(String text) {
        val startF = text.indexOf(balanceStartNF);
        val finishF = text.indexOf(balanceFinishNF);
        val valueF = text.substring(startF + balanceStartNF.length(), finishF);
        return Integer.parseInt(valueF);
    }
    private int benefitBalanceS(String text) {
        val startS = text.indexOf(balanceStartNS);
        val finishS = text.indexOf(balanceFinishNS);
        val valueS = text.substring(startS + balanceStartNS.length(), finishS);
        return Integer.parseInt(valueS);
    }

}

