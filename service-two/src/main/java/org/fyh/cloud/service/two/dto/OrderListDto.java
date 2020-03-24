package org.fyh.cloud.service.two.dto;

import lombok.Data;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2020/3/24 17:07
 */
@Data
public class OrderListDto {
    Long orderId;

    String orderName;

    String orderStatus;
}