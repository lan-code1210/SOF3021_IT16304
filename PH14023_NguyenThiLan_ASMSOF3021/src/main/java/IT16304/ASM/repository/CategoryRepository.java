package IT16304.ASM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IT16304.ASM.entity.Category;

@Repository
public interface CategoryRepository  extends 
JpaRepository<Category, Long>{
	
}
