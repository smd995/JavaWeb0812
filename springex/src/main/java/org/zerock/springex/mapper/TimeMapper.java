package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    // @Select("SELECT SQL 작성")
    @Select("SELECT now()")
    String getTime();
}
