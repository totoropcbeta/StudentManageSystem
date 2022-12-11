package com.totoropcbeta.studentmanagesystem.mapper;

import com.totoropcbeta.studentmanagesystem.entity.UserRoleLink;
import com.totoropcbeta.studentmanagesystem.entity.example.UserRoleLinkExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleLinkMapper {
    long countByExample(UserRoleLinkExample example);

    int deleteByExample(UserRoleLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleLink record);

    int insertSelective(UserRoleLink record);

    List<UserRoleLink> selectByExample(UserRoleLinkExample example);

    UserRoleLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRoleLink record, @Param("example") UserRoleLinkExample example);

    int updateByExample(@Param("record") UserRoleLink record, @Param("example") UserRoleLinkExample example);

    int updateByPrimaryKeySelective(UserRoleLink record);

    int updateByPrimaryKey(UserRoleLink record);
}
