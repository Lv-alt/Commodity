package com.za.user.convert;

import com.za.user.db.dataobject.OnlineUserDO;
import com.za.user.request.OnlineUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lvweichen
 * @date 2022/8/17 5:43 下午
 */
@Mapper(componentModel = "spring")
public interface OnlineUserConvert {

    OnlineUserConvert CONVERT = Mappers.getMapper(OnlineUserConvert.class);

    /**
     * request -> DO
     * @param userRequest request
     * @return do
     */
    OnlineUserDO requestConvertDO(OnlineUserRequest userRequest);

}
