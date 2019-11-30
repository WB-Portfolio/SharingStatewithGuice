package Steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;


public class Validation_Recherche {
        private final WebDriver driver;

        @Inject
        public Validation_Recherche(final WebDriver driver) {
                this.driver = driver;
        }

        @Given("^Je suis sur la page \"([^\"]*)\"$")
        public void Je_suis_sur_la_page(String arg1) {
                driver.manage().window().maximize();
                driver.get(arg1);
                String actualTitle1 = driver.getTitle();
                String expectedTitle1 = "Google";
                Assert.assertEquals("Condition true", actualTitle1, expectedTitle1);

        }


        @And("^Naviguer a la page \"([^\"]*)\"$")
        public void naviguer_a_la_page(String arg2) {
                driver.get(arg2);
        }

        @Then("^Valider l'affichage de la page d'acceuil LDLC")
        public void Valider_l_affichage_de_la_page_d_acceuil_LDLC() {


                String actualTitle2 = driver.getTitle();
                String expectedTitle2 = "LDLC.com - High-Tech Expérience";
                Assert.assertEquals("Condition true", expectedTitle2, actualTitle2);

        }

        @And("^Effectuer une recherche de \"([^\"]*)\"$")
        public void Effectuer_une_recherche_de(String arg3) {


                driver.findElement(By.xpath("//*[@id=\"search_search_text\"]")).sendKeys(arg3);
                driver.findElement(By.className("submit")).click();

        }

        @Then("^Valider la recherche$")
        public void validerLaRecherche() {

                Assert.assertTrue(driver.getPageSource().contains("Les résultats pour tv"));

                File localScreenshots = new File(new File("target"), "screenshots");
                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        try {
                                FileUtils.copyFile(src, new File(localScreenshots.getPath().concat("/test1.png")));
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
        }
}
