package ru.sstu.rosatom.entity.dto.dadata;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DaDataFio {
    private String surname;
    private String name;
    private String patronymic;
}
