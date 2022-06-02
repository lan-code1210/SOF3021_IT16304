package IT16304.ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16304.ASM.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
