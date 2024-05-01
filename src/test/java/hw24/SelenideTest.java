package hw24;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTest {

    @Test
    public void downloadTest() {
        String fileName = "random_data.txt";
        DowloadPageObject pageObject = new DowloadPageObject();
        pageObject.open();
        File file = pageObject.download(fileName);
        assertEquals(fileName, file.getName());
    }

    @Test
    public void uploadTest() {
        String fileName = "1714566946715.0.png";
        String path = "/Users/stetsiukalla/IdeaProjects/aqa-pet/build/reports/tests/"+fileName;
        UploadPageObject pageObject = new UploadPageObject();
        pageObject.open();
        SelenideElement div = pageObject.upload(path);
        div.shouldBe(Condition.visible);
        assertEquals(fileName, div.text());
    }
    @Test
    public void dynamicLoadElementHiddenTest() {
        DynamycLoadPageObject pageObject = new DynamicLoadOnePageObject();
        pageObject.open();
        pageObject.clickStart();
        SelenideElement div = pageObject.getFinishObject();
        String actual = div.$("h4").text();
        assertEquals("Hello World!", actual);
    }

    @Test
    public void dynamicLoadElementRenderTest() {
        DynamycLoadPageObject pageObject = new DynamicLoadTwoPageObject();
        pageObject.open();
        pageObject.clickStart();
        SelenideElement div = pageObject.getFinishObject();
        String actual = div.$("h4").text();
        assertEquals("Hello World!", actual);
    }
}
