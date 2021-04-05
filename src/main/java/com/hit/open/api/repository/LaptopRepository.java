package com.hit.open.api.repository;

import com.hit.open.api.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>, JpaSpecificationExecutor<Laptop> {

//

}
