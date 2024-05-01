package hw24;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicLoadOnePageObject extends DynamycLoadPageObject {
    @Override
    public void open() {
        Selenide.open("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Override
    SelenideElement getFinishObject() {
        SelenideElement div = $x(finishElementXPath);
        div.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return div;
    }
}
