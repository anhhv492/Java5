package com.example.demo.controller.admin;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Towel;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TowelService;
import com.example.demo.ultis.ReadExcel;

@Controller
@RequestMapping("/admin/towel")
public class TowelController {
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	ReadExcel readExcel = new ReadExcel();
	private static Integer idu=null;
	// pagination (start form)
	
	// form insert
	@GetMapping("/new")
	public String productNew(Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		Towel twl = new Towel();
		model.addAttribute("towelModel",twl);
		model.addAttribute("view","/WEB-INF/views/admin/towel/create.jsp");
		return "layout";
	}
	// insert
	@PostMapping("/insert")
	public String insertPro(@ModelAttribute("towelModel") Towel towel,HttpServletRequest request) {
		Date now = new Date();
		towel.setCreatedDate(now);
		towelService.insert(towel);
		request.getSession().setAttribute("towelSuccess", "Thêm thành công!");
		return "redirect:/admin/towels/get-all";
	}
	//form update
	@GetMapping("/update")
	public String productViewUpdate(@RequestParam("id") Integer ids,Model model) {
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		idu=ids;
		Optional<Towel> twl = towelService.selectById(idu);
		model.addAttribute("towelModel",twl.get());
		model.addAttribute("view","/WEB-INF/views/admin/towel/update.jsp");
		return "layout";
	}
	//update
	@RequestMapping(value = "/store",method = RequestMethod.POST)
	public String updateTowel(Model model,@ModelAttribute("towelModel")Towel towel,HttpServletRequest request) {
		Optional<Towel> towelOld = towelService.selectById(idu); 
		towel.setId(idu);
		towel.setImg(towelOld.get().getImg());
		towelService.update(towel);
		model.addAttribute("listPro",towelService.getAll());
		request.getSession().setAttribute("towelSuccess", "Cập nhật thành công!");
		return "redirect:/admin/towels/get-all";
	}
	
	// delete
	@RequestMapping("/delete")
	public String deleteTowel(Model model,@RequestParam("id") Integer id,HttpServletRequest request) {
		towelService.delete(id);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("listPro",towelService.getAll());
		request.getSession().setAttribute("towelSuccess", "Xóa thành công!");
		return "redirect:/admin/towels/get-all";
	}
	//select towel by cateId
	@RequestMapping("/select/{cateId}")
	public String selectByCateId(Model model, @PathVariable("cateId") Integer cateId,@ModelAttribute("towelSeach") Towel towel) {
		Optional<Category> cate = cateService.findById(cateId);
		List<Towel> list= towelService.selectByCateId(cate);
		model.addAttribute("listPro",list);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("view","/WEB-INF/views/admin/towel/show.jsp");
		return "layout";
	}
	@PostMapping("search")
	public String search(Model model, @ModelAttribute("towelSeach") Towel towel) {
		List<Towel> listTowel = towelService.selectByName("%"+towel.getName()+"%");
		model.addAttribute("listPro",listTowel);
		List<Category> listCate = cateService.getAll();
		model.addAttribute("listCate",listCate);
		model.addAttribute("view","/WEB-INF/views/admin/towel/show.jsp");
		return "layout";
	}
	@RequestMapping("read-excel")
	public String readExcel(HttpServletRequest request) {
		try {
			String name=null;
			int price=0,count=0;
			String img=null;
			String size=null;
			String color=null;
			String matter=null;
			String brand=null;
			String path=null;
//			  JFileChooser jfc = new JFileChooser();
//            FileNameExtensionFilter f = new FileNameExtensionFilter("File Excel", "xlsx");
//            jfc.setMultiSelectionEnabled(false);
//            jfc.setFileFilter(f);
//
//            int x = jfc.showOpenDialog(jfc);
//            if (x == JFileChooser.APPROVE_OPTION) {
//                path = jfc.getSelectedFile().getAbsolutePath();
//                System.out.println(path);
//            }
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

						if (cc.getColumnIndex() == 0 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							name = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 1 && cc.getCellType() == CellType.NUMERIC) {
							System.out.println(cc.getNumericCellValue() + ", ");
							price = (int) cc.getNumericCellValue();
						}
						if (cc.getColumnIndex() == 2 && cc.getCellType() == CellType.NUMERIC) {
							System.out.println(cc.getNumericCellValue() + ", ");
							count = (int) cc.getNumericCellValue();
						}
						
						if (cc.getColumnIndex() == 3 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							color = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 4 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							size = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 5 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							matter = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 6 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							brand = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 7 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							img = cc.getStringCellValue();
						}
						if (cc.getColumnIndex() == 8 && cc.getCellType() == CellType.STRING) {
							System.out.println(cc.getStringCellValue() + ", ");
							String type = cc.getStringCellValue();
							Category category=new Category();
							category= cateService.selectByName(type);
							System.out.println(category.getId()+"id");
							Date now = new Date();
							Towel towel = new Towel();
							towel.setName(name);
							towel.setPrice(price);
							towel.setSize(size);
							towel.setColor(color);
							towel.setCount(count);
							towel.setCreatedDate(now);
							towel.setMatter(matter);
							towel.setBrand(brand);
							towel.setImg(img);
							towel.setCategory(category);
							towelService.insert(towel);
							request.getSession().setAttribute("towelSuccess", "Thêm thành công!");
						}
						
					}
				}

			}

//				for(Row row:sheet) {
//					if(row.getCell(0)!=null) {
//						System.out.println("ko null"+ row.getCell(0));
//						
//					}
//				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/towels/get-all";
	}
	
}
