package ru.sstu.rosatom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sstu.rosatom.entity.Producer;

public interface ProducerRepo extends JpaRepository<Producer,Integer> {
}
