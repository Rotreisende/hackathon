package ru.sstu.rosatom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sstu.rosatom.entity.Producer;
import ru.sstu.rosatom.entity.dto.EntityRequestBody;
import ru.sstu.rosatom.entity.dto.rusprofile.RusProfileEntity;
import ru.sstu.rosatom.repository.ProducerRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepo producerRepo;

    public static Producer convert(RusProfileEntity rusProfileEntity){
        return Producer.builder()
                .name(rusProfileEntity.getName())
                .ceo_name(rusProfileEntity.getCeo_name())
                .address(rusProfileEntity.getAddress())
                .ceo_type(rusProfileEntity.getCeo_type())
                .authorized_capital(rusProfileEntity.getAuthorized_capital())
                .inn(rusProfileEntity.getInn())
                .link(rusProfileEntity.getLink())
                .ogrn(rusProfileEntity.getOgrn())
                .okpo(rusProfileEntity.getOkpo())
                .okved_descr(rusProfileEntity.getOkved_descr())
                .region(rusProfileEntity.getRegion())
                .reg_date(rusProfileEntity.getReg_date())
                .svprekrul_date(rusProfileEntity.getSvprekrul_date())
                .snippet_string(rusProfileEntity.getSnippet_string())
                .status_extended(rusProfileEntity.getStatus_extended())
                .main_okved_id(rusProfileEntity.getMain_okved_id())
                .build();

    }

    public static List<Producer> convert(List<RusProfileEntity> rusProfileEntities){
        return rusProfileEntities.stream().map(ProducerService::convert).collect(Collectors.toList());

    }
}
