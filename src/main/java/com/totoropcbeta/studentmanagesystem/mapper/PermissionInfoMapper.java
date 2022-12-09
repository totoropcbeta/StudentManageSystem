package com.totoropcbeta.studentmanagesystem.mapper;

import com.totoropcbeta.studentmanagesystem.bo.PermissionInfoBO;
import com.totoropcbeta.studentmanagesystem.entity.PermissionInfo;
import com.totoropcbeta.studentmanagesystem.entity.example.PermissionInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionInfoMapper {
    long countByExample(PermissionInfoExample example);

    int deleteByExample(PermissionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionInfo record);

    int insertSelective(PermissionInfo record);

    List<PermissionInfo> selectByExample(PermissionInfoExample example);

    PermissionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionInfo record, @Param("example") PermissionInfoExample example);

    int updateByExample(@Param("record") PermissionInfo record, @Param("example") PermissionInfoExample example);

    int updateByPrimaryKeySelective(PermissionInfo record);

    int updateByPrimaryKey(PermissionInfo record);

    List<PermissionInfoBO> listPermissionInfoBO();
}
