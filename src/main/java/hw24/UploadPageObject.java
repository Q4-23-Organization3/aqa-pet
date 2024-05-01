package hw24;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class UploadPageObject {
    public void open() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
    }

    public SelenideElement upload(String path) {
        File file = new File(path);
        SelenideElement input = $x("//input[@id='file-upload']");
        input.uploadFile(file);
        $x("//input[@id='file-submit']").click();
        return $x("//div[@id='uploaded-files']");
    }
}
