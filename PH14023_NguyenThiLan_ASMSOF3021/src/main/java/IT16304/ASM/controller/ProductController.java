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
import IT16304.ASM.model.CategoryModel;
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
	public String create(Model model, @ModelAttribute("product") ProductModel productModel) {
		List<Category> lisctg = this.categoryService.findAll();
		model.addAttribute("ctg", lisctg);
		return "admin/products/create";
	}

	@PostMapping("store")
	public String store(Model model, ProductModel productModel) {
		Product entity = new Product();
		BeanUtils.copyProperties(productModel, entity);
		entity.setCreateDate(new Date());
		productModel.setAvaliable(0);

		this.productService.save(entity);
		return "redirect:admin/products/index";
	}

	@GetMapping("edit/{productId}")
	public String edit(Model model,
			@PathVariable("productId") Product product, 
			@ModelAttribute("product") ProductModel productModel) {
		List<Category> lisctg = this.categoryService.findAll();
		model.addAttribute("ctg", lisctg);
		productModel.setId(product.getId());
		productModel.setName(product.getName());
		productModel.setPrice(product.getPrice());
		productModel.setImage(product.getImage());
		productModel.setCategory_id(product.getCategory_id());
		return "admin/products/edit";
	}
	
	@PostMapping("update/{productId}")
	public String update(@PathVariable("productId") Product product, 
			@ModelAttribute("product") ProductModel productModel) {
		product.setName(productModel.getName());
		product.setPrice(productModel.getPrice());
		product.setImage(productModel.getImage());
		product.setCategory_id(productModel.getCategory_id());
		this.productService.save(product);
		return "redirect:/admin/products/index";
	}
	

	@GetMapping("delete/{productId}")
	public String delete(@PathVariable("productId") Product productId) {
		this.productService.delete(productId);
		return "redirect:/admin/products/index";
	}

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {
		List<Category> category = this.categoryService.findAll();
		model.addAttribute("category", category);
		
		Sort sort = Sort.by(Direction.DESC, field.orElse("name"));
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Product> data = this.productService.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/products/index";
	}
}
