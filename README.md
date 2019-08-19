# demo-jwt

## 登录
URL

```
localhost:8080/jwtdemo/login
```
参数：  
 * username  
 * password

用户列表（懒得建表了）：

```
userIdMap.put("1", new User("1", "damao", "123456"));
userIdMap.put("2", new User("2", "ermao", "234567"));
userIdMap.put("3", new User("3", "sanmao", "345678"));
userIdMap.put("4", new User("4", "simao", "456789"));
userIdMap.put("5", new User("5", "wumao", "567891"));
userIdMap.put("6", new User("6", "liumao", "678912"));
userIdMap.put("7", new User("7", "qimao", "789123"));
userIdMap.put("8", new User("8", "bamao", "891234"));
userIdMap.put("9", new User("9", "jiumao", "912345"));
```

返回结果:

```
{
    "message": "登录成功！",
    "status": 200,
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.qfd0G-elhE1aGr15LrnYlIZ_3UToaOM5HeMcXrmDGBM"
}
```

## 访问不拦截资源
URL

```
localhost:8080/jwtdemo/business/goods
```

返回结果:

```
{
    "message": "商品服务调用成功！",
    "status": 200
}
```

## 访问拦截的资源
URL

```
localhost:8080/jwtdemo/business/order
```

没登录时返回结果:

```
{"message":"无token","status":300}
```

登录时返回结果（此时header需要设置登录时返回的token key为“token”）:

```
{
    "message": "订单服务调用成功！",
    "status": 200
}
```
