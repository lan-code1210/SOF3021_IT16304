package IT16304.ASM.controller;

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
import IT16304.ASM.model.CategoryModel;
import IT16304.ASM.repository.CategoryRepository;
import IT16304.ASM.servicce.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryService;
	
	@GetMapping("/create")
	public String create(@ModelAttribute("category") CategoryModel categoryModel) {
		
		return "/admin/categories/create";
	}
	
	@PostMapping("store")
	public String store(Model model, CategoryModel categoryModel) {
		Category entity = new Category();
		BeanUtils.copyProperties(categoryModel, entity);
		categoryService.save(entity);
		return "redirect:/admin/categories/create";
	}
	
	@GetMapping("edit/{categoryId}")
	public String edit(@PathVariable("categoryId") Long categoryid, Model model) {
		Optional<Category>opt= categoryService.findById(categoryid);
		
		CategoryModel categoryModel = new CategoryModel();
		if(opt.isPresent()) {
			Category entity = opt.get();
			model.addAttribute("category", entity);
			BeanUtils.copyProperties(entity, categoryModel);
			categoryModel.setIsEdit(true);
		}else {
			model.addAttribute("category", new Category());
		}
		return "admin/categories/create";
	}
	
	
	
	@GetMapping("delete/{categoryId}")
	public String delete(@PathVariable("categoryId") Long categoryid) {
		categoryService.deleteById(categoryid);
		
		return "redirect:admin/categories/index";
	}
	
	public String saveOrUpdate() {
		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("index")
	public String index(
			Model model ,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "5") Integer size,
			@RequestParam(name = "field") Optional<String> field) {
		
		Sort sort= Sort.by(Direction.DESC, field.orElse("name"));
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Category> data = this.categoryService.findAll(pageable);
		model.addAttribute("data", data);
		return "admin/categories/index";
	}
	
}
