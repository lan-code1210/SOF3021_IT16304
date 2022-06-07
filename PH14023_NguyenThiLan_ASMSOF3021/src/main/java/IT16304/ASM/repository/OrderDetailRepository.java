package IT16304.ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16304.ASM.entity.Order_detail;

public interface OrderDetailRepository extends JpaRepository<Order_detail, Integer> {

}
