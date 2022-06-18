package com.example.demo.ultis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TowelService;
@Controller
public class ReadExcel{
	@Autowired
	CategoryService categoryService;
	@Autowired
	TowelService towelService;
	public void readExcel(){
		String name=null;
		int price=0,count=0;
		String img="";
		String size=null;
		String color=null;
		String matter=null;
		String brand=null;
		try {
			FileInputStream file = new FileInputStream("D:/AnhHVPH14045/Java5/Assignment/ListTowel.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(0);
//			FormulaEvaluator fomula =wb.getCreationHelper().createFormulaEvaluator();
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				while (cellIterator.hasNext()) {
					Cell cc = cellIterator.next();
					if (cc.getRowIndex() > 0) {
						Towel towel =new Towel();
						if (cc.getColumnIndex() == 0 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							towel.setName(cc.getStringCellValue());
						}
						if (cc.getColumnIndex() == 1 && cc.getCellType() == CellType.NUMERIC) {
							System.out.println(cc.getNumericCellValue() + ", ");
							towel.setPrice((int) cc.getNumericCellValue());
						}
						if (cc.getColumnIndex() == 2 && cc.getCellType() == CellType.NUMERIC) {
							System.out.println(cc.getNumericCellValue() + ", ");
							towel.setCount((int) cc.getNumericCellValue());
						}
						
						if (cc.getColumnIndex() == 3 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							towel.setColor(cc.getStringCellValue());
						}
						if (cc.getColumnIndex() == 4 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							towel.setSize(cc.getStringCellValue());
						}
						if (cc.getColumnIndex() == 5 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							towel.setMatter(cc.getStringCellValue());
						}
						if (cc.getColumnIndex() == 6 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							towel.setBrand(cc.getStringCellValue());
						}
						
						if (cc.getColumnIndex() == 7 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							String type = cc.getStringCellValue();
							Category category= new Category();category= categoryService.selectByName(type);
							towel.setCategory(category);
							System.out.println(category.getId()+"id");
//							Date now = new Date();
//							Towel towel = new Towel();
//							towel.setName(name);
//							towel.setPrice(price);
//							towel.setSize(size);
//							towel.setColor(color);
//							towel.setCount(count);
//							towel.setCreatedDate(now);
//							towel.setMatter(matter);
//							towel.setBrand(brand);
//							towel.setImg(img);
//							towel.setCategory(category);
//							towelService.insert(towel);
						}
						
					}
				}

			}

//			for(Row row:sheet) {
//				if(row.getCell(0)!=null) {
//					System.out.println("ko null"+ row.getCell(0));
//					
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}