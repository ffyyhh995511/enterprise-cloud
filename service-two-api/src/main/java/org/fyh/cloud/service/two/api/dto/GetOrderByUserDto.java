package org.fyh.cloud.service.two.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetOrderByUserDto {
    String port;

    String applicationName;

    String date;

    String id;
}
