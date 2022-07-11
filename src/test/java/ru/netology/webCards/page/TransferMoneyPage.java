package ru.netology.webCards.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.webCards.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class TransferMoneyPage {

    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement whence = $("[data-test-id=from] input");
    private SelenideElement transfer = $("[data-test-id=action-transfer]");

    public void moneyTransfer(int invoiceAmount, DataHelper.CardInfo from) {
        amount.setValue(valueOf(invoiceAmount));
        whence.setValue(String.valueOf(from));
        transfer.click();
        new DashboardPage();
    }

    public void errorLimit() {
        $(".notification__content").should(Condition.exactText("Ошибка"));
    }

    public void invalidCard() {
        $(".notification__content").should(Condition.text("Ошибка! Произошла ошибка"));
    }
}
