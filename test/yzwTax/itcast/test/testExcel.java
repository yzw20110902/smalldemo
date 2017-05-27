package yzwTax.itcast.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.junit.Test;

public class testExcel {

	@Test
	public void test() throws IOException {
		// 新建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 新建工作表
		HSSFSheet sheet1 = workbook.createSheet("工作表1");

		// 设置要合并的单元格范围，合并第二行的第二列到第五列为一个单元格

		CellRangeAddress rangeAddress = new CellRangeAddress(1, 1, 1, 4);
		sheet1.addMergedRegion(rangeAddress);

		// 创建行，行号作为参数传给CreatRow方法，第一行从0开始
		HSSFRow row = sheet1.createRow(1);
		HSSFCell cell = row.createCell(1);

		// 设置单元格（第一行第三列 及c1）的值
		cell.setCellValue("我是合并后的单元格");

		FileOutputStream outputStream = new FileOutputStream(
				"C:\\Users\\50188\\Desktop\\excel\\工作簿.xls");

		workbook.write(outputStream);

		outputStream.close();

	}
}
