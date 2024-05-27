package com.devstack.ecom.upscale.dto.response.paginate;

import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerPaginateDto {
    private long count;
    private List<ResponseCustomerDto> dataList;
}
