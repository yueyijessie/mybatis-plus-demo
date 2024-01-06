## Mybatis Plus

> **_使用步骤_**

1. 引入起步依赖
   - 集成mybatis和mybatis plus的所有功能, 可以直接替代mybatis的starter
   - `mybatis-plus-boot-starter`

2. 定义Mapper
   - 自定义的mapper需要继承BaseMapper接口
   - `public interface UserMapper extends BaseMapper<User>`


> **_常见注解_**
 - mp通过扫描实体类, 并基于反射获取实体类信息作为数据库表信息
   - 类名, 驼峰转下划线作为表名
   - 名为id的字段作为主键
   - 变量名, 驼峰转下划线作为表的字段名
 - 常用注解(在实体类上自定义表名\字段名\ID)
   - `@TableName`: 用来指定表名
   - `@TableId`: 用来指定表中的主键字段信息
   - `@TableField`: 用来指定表中的普通字段信息

   ```java
   @Data
   @TableName("tb_user")
   public class User {
      /**
      * 用户id
      */
      @TableId(type = IdType.AUTO) // 自增
      private Long id;
   
      /**
      * 用户名
      */
      @TableField("username")
      private String username;
   }
   ```

> **_常见配置_**
- mp继承了mybatis原生配置和一些自己特有的配置
- 一般默认值就够用, 如果需要更改可以查看官网文档

> **_条件构造器_**
- Wrapper是条件构造器, 可以构造一些复杂条件
- QueryWrapper通常用来构建select, delete, update的where部分
- UpdateWrapper通常只有在set语句比较特殊时才使用(比如, `set balance = balance - 200`)
- 详见[WrapperTest.java](src/test/java/com/itheima/mp/mapper/WrapperTest.java)


> **_自定义SQL_**
- 也可以使用wrapper构建复杂的条件, 然后自定义SQL语句的剩余部分
- 详见[SelfDefinedSQLTest.java](src/test/java/com/itheima/mp/mapper/SelfDefinedSQLTest.java)


> **_Service接口_**
- save新增, update更新, get获取一个, list获取多个, count计数, remove删除
- 第一步, 自定义Service需要继承`IService`
  ```java
   public interface IUserService extends IService<User> {
   }
   ```
- 第二步, 自定义Service的实现类也需要继承`ServiceImpl`
   ```java
    @Service
    // 需指定两个泛型, 一个是将要调用的mapper, 一个是实体
    public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {
    }
    ```
- 直接使用service即可, 详见[IUserServiceTest.java](src/test/java/com/itheima/mp/service/IUserServiceTest.java)
