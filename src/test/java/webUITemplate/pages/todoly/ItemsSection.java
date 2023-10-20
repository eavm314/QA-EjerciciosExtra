package webUITemplate.pages.todoly;

import org.openqa.selenium.By;
import webUITemplate.controls.Button;
import webUITemplate.controls.TextBox;

public class ItemsSection {
    public TextBox addNewItemInput = new TextBox(By.id("NewItemContentInput"));
    public Button addNewItemButton = new Button(By.id("NewItemAddButton"));
    public Button selectItemButton(String itemName){
        return new Button(By.xpath("//div[contains(@class,'ItemContentDiv') and text()='"+itemName+"']"));
    }
    public TextBox editItemInput = new TextBox(By.xpath("//div[contains(@class,'UnderEditingItem')]/div/textarea"));
    public Button saveItemButton = new Button(By.xpath("//div[contains(@class,'UnderEditingItem')]/div/img[@id='ItemEditSubmit']"));
}
