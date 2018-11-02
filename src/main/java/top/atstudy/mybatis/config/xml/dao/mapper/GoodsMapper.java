package top.atstudy.mybatis.config.xml.dao.mapper;

import top.atstudy.mybatis.config.xml.dao.dto.GoodsDTO;

public interface GoodsMapper {

    GoodsDTO getById(Long goodsId);

}
