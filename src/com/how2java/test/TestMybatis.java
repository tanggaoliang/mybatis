package com.how2java.test;

import com.github.pagehelper.PageInfo;
import com.how2java.mapper.CategoryMapper;
import com.how2java.mapper.OrderMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper mapper=session.getMapper(CategoryMapper.class);
        int count=mapper.count();
        System.out.println(count);
        session.close();
        //        List<Category>categoryList=session.selectList("listCategory");
//        for(Category category:categoryList){
//            System.out.println(category.getName());
//        }
        //        List<Category>categoryList=session.selectList("listCategory");
//        for(Category category:categoryList){
//            System.out.println(category.getName());
//        }
//
//        Category c1 = session1.selectOne("getCategory", 1);
//        System.out.println(c1);
//        Category c2 = session1.selectOne("getCategory", 1);
//        System.out.println(c2);
//
//        session1.commit();
//        session1.close();
//
//        SqlSession session2 = sqlSessionFactory.openSession();
//        Category c3 = session2.selectOne("getCategory", 1);
//        System.out.println(c3);
//        session2.commit();
//        session2.close();
        //        PageHelper.offsetPage(0, 5);
        //                xmlWay(session);
//        annotationWay(session);
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            session.delete("deleteCategory", c);
//        }
//        for (int i = 0; i < 100; i++) {
//            Category c = new Category();
//            c.setName("category name " + i);
//            session.insert("addCategory", c);
//        }
//        List<Category> cs2 = session.selectList("listCategory");
//        for (Category c : cs2) {
//            System.out.println(c.getName());
//        }

//        Category category1 = new Category();
//        category1.setName("short name");
//        mapper.add(category1);
//        category1.setName("long long ");
//        mapper.add(category1);
//        add(mapper);
//        get(mapper);
//        update(mapper);
//        delete(mapper);
//        delete(mapper);
//        List<Product> products = mapper.list();
//        for (Product product : products) {
//            System.out.println(product + "    " + product.getCategory());
//        }
//        listOrder(session);
//        listByCategory(mapper);


    }
    //        List<Product> products = sqlSession.selectList("listProduct");
//        for (Product product : products) {
//            System.out.println(product + "de category is" + product.getCategory());
//        }

//        List<Category> cs = sqlSession.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c);
//            List<Product> products = c.getProducts();
//            System.out.println(products);
//        }

    //        Map<String, Object> params = new HashMap<>();
//        params.put("id", 3);
//        params.put("name", "cat");
//        List<Category> categoryList = sqlSession.selectList("listCategoryByIdAndName", params);
//        System.out.println(categoryList);
//
//        System.out.println();

//        List<Category> categoryList = sqlSession.selectList("listCategoryByName", "kl");
//        System.out.println(categoryList);
//        Category category1 = sqlSession.selectOne("getCategory", 1);
////        category1.setName("new11");
//        sqlSession.update("updateCategory", category1);
//        System.out.println(category1.getName());
//        listCategory(sqlSession);


    //    private static void listCategory(SqlSession sqlSession) {
//        List<Category> categoryList = sqlSession.selectList("listCategory");
//        for (Category category : categoryList) {
//            System.out.println(category.getName());
//        }
//    }
    //        Map<String, String> params = new HashMap<>();
//        params.put("name", "x");
//        List<Product> products = session.selectList("listProduct", params);
//        for (Product product : products) {
//            System.out.println(product);
//        }
//        List<Integer> params = new ArrayList();
//        params.add(1);
//        params.add(3);
//        params.add(5);


//        listProduct(session);
//        Product product=new Product();
//        product.setId(6);;
//        product.setName("product za");
//        product.setPrice(99.98f);
//        session.update("updateProduct",product);

//
//        System.out.println("多条件查询");
//        Map<String,Object> params = new HashMap<>();
////        params.put("name","a");
//        params.put("price","10");
//        List<Product> ps2 = session.selectList("listProduct",params);
//        for (Product p : ps2) {
//            System.out.println(p);
//        }

//        listProductByName(sqlSession);
    //        sqlSession.delete("deleteOrder", 2);
//        deleteOrderItem(sqlSession);
//        listOrder(sqlSession);

    private static void listProduct(SqlSession session) {
        List<Product> products = session.selectList("listProduct");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addOrderItem(SqlSession sqlSession) {
        Order order = sqlSession.selectOne("getOrder", 1);
        Product product = sqlSession.selectOne("getProduct", 6);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setNumber(10);
        sqlSession.insert("addOrderItem", orderItem);
    }

    private static void deleteOrderItem(SqlSession sqlSession) {
        Order order = sqlSession.selectOne("getOrder", 1);
        Product product = sqlSession.selectOne("getProduct", 6);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        sqlSession.delete("deleteOrderItem", orderItem);
    }

    private static void listProductByName(SqlSession session) {
        System.out.println(" mo hu cha xun");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "a");
        List<Product> products = session.selectList("listProductByName", params);
        for (Product product : products) {
            System.out.println(product);
        }
    }

//    private static void listOrder(SqlSession sqlSession) {
//        List<Order> orders = sqlSession.selectList("listOrder");
//        for (Order order : orders) {
//            System.out.println(order.getCode());
//            List<OrderItem> orderItems = order.getOrderItems();
//            for (OrderItem orderItem : orderItems) {
//                System.out.format("\t%s\t%f\t%d\t%s%n", orderItem.getProduct().getName(), orderItem.getProduct().getPrice(), orderItem.getNumber(), orderItem.getProduct().getCategory().getName());
//            }
//        }
//    }

//    private static void update(CategoryMapper categoryMapper) {
//        Category c = categoryMapper.get(2);
//        c.setName("new category1");
//        categoryMapper.update(c);
//        listCategory(categoryMapper);
//
//    }

//    private static void get(CategoryMapper mapper) {
//        Category c = mapper.get(2);
//        System.out.println(c);
//    }

//    private static void delete(CategoryMapper mapper) {
//        mapper.delete(1);
//        listCategory(mapper);
//    }
//
//    private static void add(CategoryMapper mapper) {
//        Category category = new Category();
//        category.setName("category3");
//        mapper.add(category);
//        listCategory(mapper);
//    }


    private static void listCategory(CategoryMapper mapper) {
        List<Category> categoryList = mapper.list();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    private static void listByCategory(CategoryMapper categoryMapper) {
        List<Category> categoryList = categoryMapper.listByCategory();
        for (Category c : categoryList) {
            System.out.println(c.getName());
            List<Product> products = c.getProducts();
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public static void listOrder(SqlSession session) {
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orders = mapper.list();
        for (Order order : orders) {
            System.out.println(order.getId() + "  " + order.getCode());
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem item : orderItems) {
                System.out.println(item.getProduct());
            }
        }
    }

    private static void get(CategoryMapper mapper) {
        Category category = mapper.get(1);
        System.out.println(category);

    }

    private static void update(CategoryMapper mapper) {
        Category c = mapper.get(1);
        c.setName("update new");
        mapper.update(c);
        listCategory(mapper);

    }

    private static void add(CategoryMapper mapper) {
        Category category = new Category();
        category.setName("added category");
        mapper.add(category);
        listCategory(mapper);
    }

    private static void delete(CategoryMapper mapper) {
        mapper.delete(1);
        listCategory(mapper);
    }

    private static void xmlWay(SqlSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", 0);
        params.put("count", 5);
        List<Category> categoryList = session.selectList("listCategory", params);
        for (Category c : categoryList) {
            System.out.println(c);
        }
        PageInfo pageInfo = new PageInfo<>(categoryList);
        System.out.println("total is " + pageInfo.getTotal());
        System.out.println(pageInfo);
    }

    private static void annotationWay(SqlSession session) {
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
        List<Category> categoryList = mapper.listByPage(0, 5);
        for (Category c : mapper.list()) {
            System.out.println(c);
        }
    }
}
