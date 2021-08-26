package com.zxk.service;

import com.zxk.domain.Student;
import com.zxk.mapper.StudentMapper;
import com.zxk.utils.MapperUtils;

import java.util.List;

/**
 * @program: StudentManagerMyBatis
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-13 11:47
 **/
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> selectAll() {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            List<Student> studentList = mapper.selectAll();
            MapperUtils.commit();
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.delete(id);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }

    @Override
    public Student selectByID(Integer id) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Student student = mapper.selectByID(id);
            MapperUtils.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return null;
    }

    @Override
    public Integer update(Student student) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.update(student);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }

    @Override
    public Integer insert(Student student) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.insert(student);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }

    @Override
    public List<Student> selectConditions(String name, String score) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            List<Student> studentList=mapper.selectConditions(name,score);
            MapperUtils.commit();
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return null;
    }

}
