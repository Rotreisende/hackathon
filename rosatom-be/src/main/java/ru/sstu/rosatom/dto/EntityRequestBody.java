package ru.sstu.rosatom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
