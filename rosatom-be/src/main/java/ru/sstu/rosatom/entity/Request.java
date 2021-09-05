package ru.sstu.rosatom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.sstu.rosatom.entity.enums.PaidType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
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
            cascade = CascadeType.ALL
    )
    private List<Producer> producers;

    private LocalDate date;

    private Integer producersCount;
}
