package kz.greetgo.eschool.mapper;

import kz.greetgo.eschool.model.Student;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();

    @Update("update student set name=#{name}, surname=#{surname}, grade=#{grade}, " +
            "favoriteSubject=#{favoriteSubject} where id=#{id}")
    void update(Student student);

    @Insert("insert into student (name, surname, grade, favoriteSubject) " +
            "values(#{name}, #{surname}, #{grade}, #{favoriteSubject})")
    void insert(Student student);

    @Delete("delete from student where id=#{id}")
    void delete(@PathParam("id") long id);

}
