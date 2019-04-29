package ufy.mmcs.brs.StudentPageTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class PageOfDisciplin  extends Helper{
    @Parameters("browser")
    @BeforeClass
    protected void  /* WebDriver*/ getDriver(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", get_chrome_driver());
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", get_firefox_driver());
            driver = new FirefoxDriver();
        }
        timeouts_set();
        go_home();
		authorization();
    }

    @AfterClass
    public void tearDown() {
        // Close all browser windows and safely end the session
        if(driver != null)
        {driver.quit();
            driver=null;}
    }
	
	@Test
	public void go_to_balls(){
	List<WedElement> strs=driver.findElements(By.className("disciplineRow"));
	Assert.assertTrue(strs.isNull(),"В таблице нет дисуиплин");
	
	if(
	strs.get(0).findElement(By.className("discTitle")).isDisplayed())
	Asser.fail("Нет ссылки в таблиц на дисциплину");
	
	strs.get(0).findElement(By.className("discTitle")).click();
	Assert.assertEquals(driver.findElement(By.className("main_top")),"Учебная карта дисциплины","Загрузилась не та страница");
	
	}
	
	
	@Test
	public void go_to_journal(){
		driver.Navigate.url("http://testgrade.sfedu.ru/student/discipline/13337");
	//List<WedElement> strs=driver.findElements(By.className("disciplineRow"));
//	Assert.assertTrue(strs.isNull(),"В таблице нет дисуиплин");
	
/*	if(
	strs.get(0).findElement(By.className("discTitle")).isDisplayed())
	Asser.fail("Нет ссылки в таблиц на дисциплину");
	
	strs.get(0).findElement(By.className("discTitle")).click();*/
	
	Assert.assertEquals(driver.findElement(By.className("main_top")),"Учебная карта дисциплины","He Загрузилась страница");
	
	if(!IsElementVisible(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div[4]/div/div[2]"))
		Assert.fail("нет кнопки Журнал посещений");
	
	driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div[4]/div/div[2]")).click();
	if(!IsElementVisible(By.className("blockTitle")
		Assert.fail("Не загрузилась страница/нет элемента");
	
	Assert.assertEquals(driver.findElement(By.className("blockTitle").getText(), "Журнал посещений","Загрузился не журнал посещений");
	
	}
	
	@Test
	public void go_to_baals_after_journal(){
		driver.Navigate.url("http://testgrade.sfedu.ru/student/discipline/13337");
			Assert.assertEquals(driver.findElement(By.className("blockTitle").getText(), "Журнал посещений","Загрузился не журнал посещений");
		if(!IsElementVisible(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div[4]/div/div[1]")))
			Assert.fail("Нет кнопки Баллы");
		driver.fineElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div[4]/div/div[1]").click();
		if(!IsElementVisible(By.className("pageTitle")))
			Assert.fail("Не загрузилась страница");
			Assert.assertEquals(driver.findElement(By.className("pageTitle")),"Базы данных","Загрузилась не та страница");
}
