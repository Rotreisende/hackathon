package ru.sstu.rosatom.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Producer;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.repository.RequestRepo;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepo requestRepo;

    public List<Request> requestList(){
        return requestRepo.findAll();
    }

    public RusProfileService rusProfileService;

    public Request getById(Integer id){
        return requestRepo.getOne(id);
    }

    public Integer save(EntityRequestBody entityRequestBody){

        List<RusProfileEntity> rusProfileEntities = rusProfileService.getEntitiesByOkpd2(entityRequestBody.getCode());

        List<Producer> producers = ProducerService.convert(rusProfileEntities);

        Integer countProducers = producers.size();



        Request request = Request.builder()
                .name(entityRequestBody.getName())
                .code(entityRequestBody.getCode())
                .count(entityRequestBody.getCount())
                .sum(entityRequestBody.getSum())
                .paymentMethod(entityRequestBody.getPaymentMethod())
                .units(entityRequestBody.getUnits())
                .producers(producers)
                .producersCount(countProducers)
                .date(LocalDate.now())
                .build();

        return requestRepo.save(request).getId();
    }
}
