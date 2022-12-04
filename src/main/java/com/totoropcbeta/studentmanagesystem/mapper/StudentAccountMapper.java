package com.totoropcbeta.studentmanagesystem.mapper;

import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.entity.example.StudentAccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentAccountMapper {
    long countByExample(StudentAccountExample example);

    int deleteByExample(StudentAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    List<StudentAccount> selectByExample(StudentAccountExample example);

    StudentAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByExample(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);
}