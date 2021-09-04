package ru.sstu.rosatom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sstu.rosatom.entity.Region;

public interface RegionRepo extends JpaRepository<Region, Integer> {
    Region findTitleByCode(String code);
}
