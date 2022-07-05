package Init.com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Init {

	public static WebDriver driver;
	public static FileInputStream fileinput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFSheet sheetset;
	public static FileOutputStream fileout;
	public static FileOutputStream result;
	public static XSSFCell actualResult;
	public static String Write = " ";
	public static String condition = "Yes";

	@BeforeTest
	public void Open_Browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://dynamics-dev.toastmasters.org/login");
	}

	@AfterTest
	public void Close_Browser() throws Exception {

		Thread.sleep(3000);
		driver.quit();
	}

	public void take_screenshot(String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static void main() throws IOException {

		int j = 0;
		int i = 0;

		getdata(condition, i, j);
		setValue(condition, j, i, Write);

	}

	public static String getdata(String sheet1, int rowNum, int colNum) throws IOException {

		fileinput = new FileInputStream("cucumberjava.xlsx");

		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheet1);
		String celldata = String.valueOf(sheet.getRow(rowNum).getCell(colNum));

		return celldata;

	}

	public static void setValue(String sheet2, int rowNum, int colNum, String value) throws IOException {

		fileinput = new FileInputStream("cucumberjava.xlsx");

		workbook = new XSSFWorkbook(fileinput);
		sheetset = workbook.getSheet(sheet2);

		sheetset.getRow(rowNum).getCell(colNum).setCellValue(value);

		fileout = new FileOutputStream("cucumberjava.xlsx");
		workbook.write(fileout);
		fileout.close();
	}

}
