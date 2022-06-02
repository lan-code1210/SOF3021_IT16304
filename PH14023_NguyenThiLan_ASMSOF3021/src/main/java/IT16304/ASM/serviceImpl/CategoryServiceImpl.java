package IT16304.ASM.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import IT16304.ASM.entity.Category;
import IT16304.ASM.repository.CategoryRepository;
import IT16304.ASM.servicce.CategoryService;

public class CategoryServiceImpl implements CategoryService{
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	public CategoryServiceImpl(CategoryRepository categoryRepository) {
//		this.categoryRepository = categoryRepository;
//	}
//
//	@Override
//	public <S extends Category> S save(S entity) {
//		
//		return categoryRepository.save(entity);
//	}
//
//	public List<Category> findAll() {
//		return categoryRepository.findAll();
//	}
//
//	@Override
//	public Page<Category> findAll(Pageable pageable) {
//		return categoryRepository.findAll(pageable);
//	}
//
//	@Override
//	public List<Category> findAll(Sort sort) {
//		return categoryRepository.findAll(sort);
//	}
//
//	public List<Category> findAllById(Iterable<Integer> ids) {
//		return categoryRepository.findAllById(ids);
//	}
//
//	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
//		return categoryRepository.saveAll(entities);
//	}
//
//	public void flush() {
//		categoryRepository.flush();
//	}
//
//	public boolean existsById(Integer id) {
//		return categoryRepository.existsById(id);
//	}
//
//	public <S extends Category> S saveAndFlush(S entity) {
//		return categoryRepository.saveAndFlush(entity);
//	}
//
//	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
//		return categoryRepository.saveAllAndFlush(entities);
//	}
//
//	public long count() {
//		return categoryRepository.count();
//	}
//
//	public <S extends Category> boolean exists(Example<S> example) {
//		return categoryRepository.exists(example);
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		categoryRepository.deleteById(id);
//	}
//
//	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//		categoryRepository.deleteAllByIdInBatch(ids);
//	}
//
//	@Override
//	public void delete(Category entity) {
//		categoryRepository.delete(entity);
//	}
//
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		categoryRepository.deleteAllById(ids);
//	}
//
//	public void deleteAll(Iterable<? extends Category> entities) {
//		categoryRepository.deleteAll(entities);
//	}
//
//	public void deleteAll() {
//		categoryRepository.deleteAll();
//	}
//
//	@Override
//	public Category getById(Integer id) {
//		return categoryRepository.getById(id);
//	}
//	
	
	
}
