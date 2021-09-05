package ru.sstu.rosatom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String ogrn;
    private String inn;
    private String region;
    private String address;
    private Long inactive;
    private String ceo_name;
    private String main_okved_id;
    private String okved_descr;
    private String reg_date;
    private String email;
    private String phone;
    private String token;
}
