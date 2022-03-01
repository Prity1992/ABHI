package GroupPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;

public class UpdateExcel {
	String path = "";

	public UpdateExcel(String path) {
		super();
		this.path = path;
	}

	public void updateValueInExcelSheet(String ColumnName, String value) throws IOException {
		FileInputStream fis = new FileInputStream(new File(path));
		@SuppressWarnings("resource")
		HSSFWorkbook work = new HSSFWorkbook(fis);
		HSSFSheet sheet = work.getSheet("Policy");
		DataFormatter formatter = new DataFormatter();
		Row dataRow = sheet.getRow(0);

		System.out.println(ColumnName + "==" + value);
		int cellNumber = 0;

		for (int i = 0; i < dataRow.getLastCellNum(); i++) {

			if (formatter.formatCellValue(dataRow.getCell(i)).trim().equalsIgnoreCase(ColumnName.trim())) {
				cellNumber = i;
				break;
			}
		}
		HSSFCell cell = sheet.getRow(1).getCell(cellNumber);
		cell.setCellValue(value);

		fis.close();
		FileOutputStream fos = new FileOutputStream(new File(path));
		work.write(fos);
		fos.close();

	}

}
