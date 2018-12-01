package com.how2java.mapper;

import java.util.List;

import com.how2java.sql.CategoryDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import com.how2java.pojo.Category;

public interface CategoryMapper {
    //    @Insert(" insert into category_ (name) values (#{name}) ")
    @InsertProvider(type = CategoryDynaSqlProvider.class, method = "add")
    public int add(Category category);

    //    @Delete(" delete from category_ where id = #{id} ")
    @DeleteProvider(type = CategoryDynaSqlProvider.class, method = "delete")
    public void delete(int id);

    //    @Select(" select * from category_ where id = #{id} ")
    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "get")
    public Category get(int id);

    //    @Update(" update category_ set name = #{name} where id = #{id} ")
    @UpdateProvider(type = CategoryDynaSqlProvider.class, method = "update")
    public int update(Category category);


    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "list")
    public List<Category> list();

    @Select(" select * from category_ limit  #{start} ,#{count}")
    public List<Category> listByPage(@Param("start") int start, @Param("count") int count);

    @Select(" select * from category_ ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "com.how2java.mapper.ProductMapper.listByCategory"))
    })
    public List<Category> listByCategory();

    @Select("select count(*) from category_")
    public int count();
}
