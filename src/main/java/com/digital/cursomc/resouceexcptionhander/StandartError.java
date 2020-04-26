package com.digital.cursomc.resouceexcptionhander;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
public class StandartError {
private Integer status;
private String msg;
private Long timestamp;
}
