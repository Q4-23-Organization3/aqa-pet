package hw24;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

public class DowloadPageObject {

    public void open() {
        Selenide.open("https://the-internet.herokuapp.com/download");
    }

    public File download(String fileName) {
        File file = null;
        SelenideElement link = $x("//a[@href='download/"+fileName+"']");
        try {
            file = link.download();
        } catch (IOException exception) {
            System.out.println("Can't download file");
        }
        return file;
    }
}
