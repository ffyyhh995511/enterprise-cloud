package org.fyh.cloud.service.two.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2021/1/26 15:04
 */
@Data
@Accessors(chain = true)
public class GetGoodsByUserDto {

    private String desc;

    private String name;

    private String time;
}