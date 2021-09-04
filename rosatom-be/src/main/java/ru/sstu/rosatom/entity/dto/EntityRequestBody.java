package ru.sstu.rosatom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sstu.rosatom.entity.enums.PaidType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityRequestBody {

    String name;
    String code;
    Long sum;
    Long count;
    String units;
    PaidType paymentMethod;
    String region;

}
