package com.linex.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linex.domain.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author linexsong
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
