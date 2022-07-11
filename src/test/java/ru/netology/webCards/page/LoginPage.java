package ru.netology.webCards.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.webCards.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");


    public VerificationPage validLogin(DataHelper.AuthInfo authInfo) {
        //$("[data-test-id=login] input").setValue(authInfo.getLogin());
        //$("[data-test-id=password] input").setValue(authInfo.getPassword());
        //$("[data-test-id=action-login] input").click();
        loginField.setValue(authInfo.getLogin());
        passwordField.setValue(authInfo.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

}
