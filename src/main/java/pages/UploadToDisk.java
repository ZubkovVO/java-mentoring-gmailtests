package pages;

import org.openqa.selenium.By;

public class UploadToDisk extends AbstractPage {

   // @FindBy(css="input[class='upload-button__attach']") private WebElement upload;
    private static final By UPLOAD= By.cssSelector("input.upload-button__attach");
    private static final By CLOSE = By.cssSelector("a[data-click-action='dialog.close']");
    private static String path = "D:\\1.txt";


     public UploadToDisk uploadFile() {
        browser.upload(UPLOAD, path);
        browser.click(CLOSE);
        return this;
    }
}
