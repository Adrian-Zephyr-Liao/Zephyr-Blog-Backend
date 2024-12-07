``` markdown
|_annotation：放置项目自定义注解
|_aspect：放置切面代码
|_config：放置配置类
|_constant：放置常量、枚举等定义
|__consist：存放常量定义
|__enums：存放枚举定义
|_controller：放置控制器代码
|_filter：放置一些过滤、拦截相关的代码
|_mapper：放置数据访问层代码接口
|_model：放置数据模型代码
|__entity：放置数据库实体对象定义
|__dto：存放数据传输对象定义
|__vo：存放显示层对象定义
|_service：放置具体的业务逻辑代码（接口和实现分离）
|__intf：存放业务逻辑接口定义
|__impl：存放业务逻辑实际实现
|_utils：放置工具类和辅助代码
```

DO（Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。

DTO（Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。

BO（Business Object）：业务对象。由Service层输出的封装业务逻辑的对象。

AO（Application Object）：应用对象。在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高。

VO（View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。

Query：数据查询对象，各层接收上层的查询请求。注意超过2个参数的查询封装，禁止使用Map类来传输。