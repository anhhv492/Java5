package com.example.demo.controller.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Towel;
import com.example.demo.entity.User;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.CartService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.TowelService;
import com.example.demo.service.UserService;
import com.example.demo.ultis.CartCookies;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	UserService userService;
	@Autowired
	CategoryService cateService;
	@Autowired
	TowelService towelService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;
	@Autowired
	HttpServletRequest request;
	static int idCart;
	// shop ( danh muc )
	@GetMapping("shop")
	public String shopByCateId(Model model,@RequestParam("id") Integer id) {
		Optional<Category> cate = cateService.selectById(id);
		List<Towel> listTowel = towelService.selectByCateId(cate);
		for(int i=0;i<listTowel.size();i++) {
			if(listTowel.get(i).getCount()==0) {
				listTowel.remove(i);
			}
		}
		model.addAttribute("listTowel",listTowel);
		model.addAttribute("view","/WEB-INF/views/index/shop.jsp");
		return "layout";
	}
	@GetMapping("detail")
	public String detailsTowel(Model model,@RequestParam("id") Integer id) {
		Optional<Towel> detail = towelService.selectById(id);
		idCart=id;
		model.addAttribute("detail",detail.get());
		model.addAttribute("view","/WEB-INF/views/index/detail.jsp");
		return "layout";
	}

	
	@GetMapping("addCart")
	public String cart(Model model,HttpServletResponse response,HttpServletRequest request) {
		List<Cart> listCart = cartService.getAll();
		
		CartCookies cartCookies = new CartCookies();
		cartCookies.setCartCookie(idCart,response);

		Optional<Towel> towel = towelService.selectById(idCart);
		boolean check=true;
		Cart cart=null;
		System.out.println("buoc 1");
		for(int i=0;i<listCart.size();i++) {
			if(listCart.get(i).getTowelId()==towel.get()) {
				if(listCart.get(i).getTowelId().getId()==towel.get().getId()) {
					if(listCart.get(i).getQuantity()+1>towel.get().getCount()) {
						request.getSession().setAttribute("countFalse", "Sản phẩm không đủ số lượng");
						System.out.println("buoc 2");
						return "forward:/cart/show-cart";
					}
				}
				check=false;
				cart= new Cart();
				int quantity=listCart.get(i).getQuantity();
				System.out.println("so luong: "+quantity+" ......");
				BigDecimal price =BigDecimal.valueOf(towel.get().getPrice()*(quantity+1));
				cart.setId(listCart.get(i).getId());
				cart.setQuantity(quantity+1);
				cart.setPrice(price);
				cart.setTowelId(towel.get());
				cartService.insert(cart);
			}
		}
		if(check==true) {
			cart= new Cart();
			BigDecimal price =BigDecimal.valueOf(towel.get().getPrice());
			cart.setQuantity(1);
			cart.setPrice(price);
			cart.setTowelId(towel.get());
			cartService.insert(cart);
		}
//		listCart.add(cart);
//		request.getSession().setAttribute("listCart", listCart);
//		model.addAttribute("view","/WEB-INF/views/index/cart.jsp");
//		return "layout";
		return "forward:/cart/show-cart";
	}	
	int ids =0;
	@GetMapping("show-cart")
	public String showCart(Model model, HttpServletRequest request,@ModelAttribute("cartModel") Cart cart) {
		List<Cart> listCart = cartService.getAll();
		BigDecimal total=new BigDecimal(0);
		
		for(int i=0;i<listCart.size();i++) {
			total=total.add(listCart.get(i).getPrice());
			
		}
		model.addAttribute("donGia", total);
		model.addAttribute("listCart", listCart);
		model.addAttribute("view","/WEB-INF/views/index/cart.jsp");
		return "layout";
	}
	
	@PostMapping("update-quantity/{id}")
	public String updateQuantity(Model model,@PathVariable("id") int id,@ModelAttribute("cartModel") Cart cartModel, HttpServletRequest request) {
		ids=id;
		Optional<Cart> cart= cartService.findById(id);
		Optional<Towel> towel = towelService.selectById(cart.get().getTowelId().getId());
		if(cartModel.getQuantity()<=0||cartModel.getQuantity()>towel.get().getCount()) {
			request.getSession().setAttribute("countFalse", "Sản phẩm: "+towel.get().getName()+" phải lớn hơn 0 và không quá "+towel.get().getCount());

			return "redirect:/cart/show-cart";
		}else {

			BigDecimal total=new BigDecimal(towel.get().getPrice());
			BigDecimal qtt=BigDecimal.valueOf(cartModel.getQuantity());
			cart.get().setPrice(total.multiply(qtt));
			cart.get().setQuantity(cartModel.getQuantity());
			cartService.insert(cart.get());
			return "redirect:/cart/show-cart";
		}
	}

	@GetMapping("delete-cart/{id}")
	public String deleteCart(Model model,@PathVariable("id") Integer id) {
		cartService.delete(id);
		return "redirect:/cart/show-cart";
	}
	
	@GetMapping("buy")
	public String cartBuy(Model model,HttpServletResponse response) {
		User acc = (User) request.getSession().getAttribute("account");
		List<Cart> listCart = cartService.getAll();

//		orderService.deleteAllCartCookie(request, response);
		Date now = new Date();
		Order order = new Order();
		order.setUserId(acc);
		order.setCreateDate(now);
		order.setStatus(0);
		order.setAddress(acc.getLocation());
		orderService.insert(order);
		for(int i=0;i<listCart.size();i++) {
			OrderDetail orderDetail = new OrderDetail();
			Optional<Towel> towel = towelService.selectById(listCart.get(i).getTowelId().getId());
			orderDetail.setOrderId(orderService.selectNew());
			orderDetail.setPrice(listCart.get(i).getPrice());
			orderDetail.setQuantity(listCart.get(i).getQuantity());
			orderDetail.setTowelId(towel.get());
			orderDetailService.insert(orderDetail);
			towel.get().setCount(towel.get().getCount()-listCart.get(i).getQuantity());
			towelService.insert(towel.get());
			cartService.deleteAll();
			
		}
		request.getSession().setAttribute("createSuccess", "Thanh toán thành công!");
		model.addAttribute("view","/WEB-INF/views/home.jsp");
		return "layout";
	}
	
}
