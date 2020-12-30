package com.iotmars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: xsh
 * @date: 2020/12/28 9:52
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FlDTO implements Serializable {
    private static final long serialVersionUID = -7545076783767269740L;

    private String name;

    private String weight;

}
