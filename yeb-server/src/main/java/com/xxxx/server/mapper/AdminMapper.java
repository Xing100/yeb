package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xingzhishan
 * @since 2022-03-17
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id,@Param("keywords") String keywords);
}
