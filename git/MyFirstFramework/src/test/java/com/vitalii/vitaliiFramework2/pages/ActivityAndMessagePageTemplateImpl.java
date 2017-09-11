package com.vitalii.vitaliiFramework2.pages;

import java.util.ArrayList;
import com.vitalii.vitaliiFramework2.elements.Button;

public class ActivityAndMessagePageTemplateImpl extends BasePage implements ActivityAndMessagePageTemplate {
    //abstract?!?!
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ActivityAndMessagePageTemplateImpl> void cloneForm(String formName) {
        Class<? extends ActivityAndMessagePageTemplateImpl> clas = this.getClass();
        T page = null;
        try {
            page = (T) clas.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ActivityAndMessagePageTemplateImpl.CloningModalWindowPage clone = page.new CloningModalWindowPage();
        //TODO: remove this sleep
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        getWaiters().fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException("//*[@id='" + getFormIdByName(formName) + "']//span[@class='table-list-icon icon']");
        //new Button("//*[@id='" + getFormIdByName(formName) + "']//span[@class='table-list-icon icon']").click("//*[@id='" + getFormIdByName(formName) + "']//span[@class='table-list-icon icon']");
        //new Button("//*[@id='" + getFormIdByName(formName) + "']//span[@class='table-list-icon icon']").click();
        Button bt = new Button("//*[@id='" + getFormIdByName(formName) + "']//span[@class='table-list-icon icon']");
        bt.click();
        clone.clickOkInCloningModalWindow();
        //return page;
    }

    class CloningModalWindowPage extends BasePage {

        //Locators
        private final Button confirmCloningButton = new Button("OK button in Clone modal window", "//*[@class='appModal small']//*[@class='small button primary']");

        ArrayList<Class<? extends ActivityAndMessagePageTemplateImpl>> pagesWithClonnableEntities = new ArrayList<>();

        public <T extends ActivityAndMessagePageTemplateImpl> T clickOkInCloningModalWindow() {
            //TODO: add other pages when create them
            pagesWithClonnableEntities.add(SignUpFormsPage.class);
            getWaiters().fluentWaitIgnoringNoSuchElementExceptionAndElementNotVisibleException(confirmCloningButton.getLocator());
            //confirmCloningButton.click(confirmCloningButton.getLocator());
            confirmCloningButton.click();
            Class currentClass = this.getClass();

            for (Class pageClass : pagesWithClonnableEntities) {
                if (currentClass.equals(pageClass))
                    try {
                        return (T) currentClass.newInstance();
                    } catch (InstantiationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            } return null;
        }
    }
}
