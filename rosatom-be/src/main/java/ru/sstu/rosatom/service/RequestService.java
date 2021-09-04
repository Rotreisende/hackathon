package ru.sstu.rosatom.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Producer;
import ru.sstu.rosatom.entity.Request;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.entity.dto.nalog.NalogEntity;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.repository.RequestRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepo requestRepo;
    private final NalogService nalogService;

    public final Map<String,String> map;

    public List<Request> requestList() {
        return requestRepo.findAll();
    }

    public RusProfileService rusProfileService;

    public Request getById(Integer id){
        return requestRepo.getOne(id);
    }

    public Integer save(EntityRequestBody entityRequestBody) {

        List<RusProfileEntity> rusProfileEntities = rusProfileService.getEntitiesByOkpd2(entityRequestBody.getCode());
        List<NalogEntity> nalogEntities = nalogService.getNalogEntities(entityRequestBody.getCode(), entityRequestBody.getRegion());

       // List<Producer> producersFromRusProfile = ProducerService.convertRusProfile(rusProfileEntities);
        List<Producer> producersFromNalog = ProducerService.convertNalogEntity(nalogEntities);

        List<Producer> mergedProducers = mergeListsByInn(new ArrayList<>(), producersFromNalog);


        Integer countProducers = mergedProducers.size();


        Request request = Request.builder()
                .name(entityRequestBody.getName())
                .code(entityRequestBody.getCode())
                .count(entityRequestBody.getCount())
                .sum(entityRequestBody.getSum())
                .paymentMethod(entityRequestBody.getPaymentMethod())
                .units(entityRequestBody.getUnits())
                .producers(producersFromNalog)
                .producersCount(countProducers)
                .date(LocalDate.now())
                .producers(mergedProducers)
                .build();

        return requestRepo.save(request).getId();
    }

    private List<Producer> mergeListsByInn(List<Producer> producersFromRusProfile, List<Producer> producersFromNalog) {
        List<String> inns = producersFromRusProfile.stream().map(Producer::getInn).collect(Collectors.toList());
        producersFromNalog.removeIf(inns::contains);
        return producersFromNalog;
    }
}
