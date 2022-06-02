package IT16304.ASM.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IT16304.ASM.entity.Category;
import IT16304.ASM.entity.Product;
import IT16304.ASM.model.ProductModel;
import IT16304.ASM.repository.CategoryRepository;
import IT16304.ASM.repository.ProductRepository;

@Controller
@RequestMapping("admin/products")
public class ProductController {
	@Autowired
	private ProductRepository productService;
	
	@Autowired
	private CategoryRepository categoryService;
	
	@GetMapping("create")
	public String create(@ModelAttribute("product") ProductModel productModel) {
		
		return "admin/products/create";
	}
	
	@PostMapping("store")
	public String store(Model model, ProductModel productModel) {
		Product entity = new Product();
		BeanUtils.copyProperties(productModel, entity);
		productModel.setCreateDate(new Date());
		productModel.setAvaliable(0);
		
		this.productService.save(entity);
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("edit/{productId}")
	public String edit(@PathVariable("productId") Integer productid, Model model) {
		Optional<Product>opt= this.productService.findById(productid);
		
		ProductModel productModel = new ProductModel();
		if(opt.isPresent()) {
			Product entity = opt.get();
			
			BeanUtils.copyProperties(entity, productModel);
			model.addAttribute("product", productModel);
		}else {
			model.addAttribute("product", new Category());
		}
		return "admin/products/create";
	}
	
	@ModelAttribute("ctg")
	public List<Category> categories(){
		return categoryService.findAll();
	}
	
	@GetMapping("delete/{productId}")
	public String delete(@PathVariable("productId") Integer productId) {
		this.productService.deleteById(productId);
		
		return "admin/products/index";
	}
	
	
	@GetMapping("index")
	public String index(
			Model model ,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {
		
		Sort sort= Sort.by(Direction.DESC, field.orElse("name"));
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Product> data = this.productService.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/products/index";
	}
}
