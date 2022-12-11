package com.totoropcbeta.studentmanagesystem.mapper;

import com.totoropcbeta.studentmanagesystem.entity.MatriculateStudent;
import com.totoropcbeta.studentmanagesystem.entity.example.MatriculateStudentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MatriculateStudentMapper {
    long countByExample(MatriculateStudentExample example);

    int deleteByExample(MatriculateStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MatriculateStudent record);

    int insertSelective(MatriculateStudent record);

    int batchInsertSelective(List<MatriculateStudent> record);

    List<MatriculateStudent> selectByExample(MatriculateStudentExample example);

    MatriculateStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MatriculateStudent record, @Param("example") MatriculateStudentExample example);

    int updateByExample(@Param("record") MatriculateStudent record, @Param("example") MatriculateStudentExample example);

    int updateByPrimaryKeySelective(MatriculateStudent record);

    int updateByPrimaryKey(MatriculateStudent record);
}
