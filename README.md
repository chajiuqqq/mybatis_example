# mybatis_example
单纯使用maybatis访问数据库。
实验了多表查询。
# 表结构
- user
- role
- user_role
- product
- category

# 表关系
product-category : 多对一
category-product : 一对多
user-role        : 多对多 中间表：user_role
