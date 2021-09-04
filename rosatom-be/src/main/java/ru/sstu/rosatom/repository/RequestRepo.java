package ru.sstu.rosatom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;

import javax.swing.text.html.parser.Entity;

public interface RequestRepo extends JpaRepository<Request,Integer> {
}
