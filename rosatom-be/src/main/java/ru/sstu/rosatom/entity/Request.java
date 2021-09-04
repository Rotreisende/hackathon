package ru.sstu.rosatom.entity;

import lombok.*;
import ru.sstu.rosatom.entity.enums.PaidType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;
    private Long sum;
    private Long count;
    private String units;

    @Enumerated(EnumType.ORDINAL)
    private PaidType paymentMethod;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Producer> producers;
}
