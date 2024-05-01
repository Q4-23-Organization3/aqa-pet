package hw24;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

abstract class DynamycLoadPageObject {
    private final SelenideElement startButton = $x("//button[text()='Start']");
    protected String finishElementXPath = "//div[@id='finish']";

    abstract void open();

    abstract SelenideElement getFinishObject();

    public void clickStart() {
        startButton.click();
    }
}
