package ru.sstu.rosatom.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.repository.RequestRepo;

import javax.persistence.Entity;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepo requestRepo;

    public List<Request> requestList(){
        return requestRepo.findAll();
    }

    public Request save(EntityRequestBody entityRequestBody){

        Request request = Request.builder()
                .name(entityRequestBody.getName())
                .code(entityRequestBody.getCode())
                .count(entityRequestBody.getCount())
                .sum(entityRequestBody.getSum())
                .paymentMethod(entityRequestBody.getPaymentMethod())
                .units(entityRequestBody.getUnits())
                .build();

         return requestRepo.save(request);
    }
}
