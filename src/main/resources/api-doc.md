# 接口文档

## 目录
- [用户管理接口](#用户管理接口)
- [菜品分类管理接口](#菜品分类管理接口)
- [菜品管理接口](#菜品管理接口)
- [购物车管理接口](#购物车管理接口)
- [订单管理接口](#订单管理接口)
- [评价管理接口](#评价管理接口)
- [计数器接口](#计数器接口)

## 通用说明

### 通用响应格式
所有接口的响应都遵循以下格式：
```json
{
  "code": 200,      // 响应状态码
  "message": "xxx", // 响应消息
  "data": {}        // 响应数据，根据接口不同而不同
}
```

## 菜品分类管理接口

### 获取可用分类列表
- **接口**：`GET /api/categories/available`
- **描述**：获取所有可用的分类列表
- **入参**：无
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "categoryId": 1,          // 分类ID，整数类型
        "categoryName": "xxx",    // 分类名称，字符串类型
        "sortOrder": 0,          // 排序号，整数类型
        "isAvailable": true,     // 是否可用，布尔类型
        "createdAt": "xxx",      // 创建时间，日期时间类型
        "updatedAt": "xxx"       // 更新时间，日期时间类型
      }
    ]
  }
  ```

### 获取分类详情
- **接口**：`GET /api/categories/{id}`
- **描述**：根据ID获取分类信息
- **入参**：
  - 路径参数：
    - `id`：分类ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "categoryId": 1,          // 分类ID，整数类型
      "categoryName": "xxx",    // 分类名称，字符串类型
      "sortOrder": 0,          // 排序号，整数类型
      "isAvailable": true,     // 是否可用，布尔类型
      "createdAt": "xxx",      // 创建时间，日期时间类型
      "updatedAt": "xxx"       // 更新时间，日期时间类型
    }
  }
  ```

### 创建分类
- **接口**：`POST /api/categories`
- **描述**：创建新分类
- **入参**：
  - 请求体：
    ```json
    {
      "categoryName": "xxx",    // 分类名称，字符串类型，必填
      "sortOrder": 0,          // 排序号，整数类型，可选
      "isAvailable": true      // 是否可用，布尔类型，可选，默认true
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true              // 创建成功返回true，失败返回false
  }
  ```

### 更新分类信息
- **接口**：`PUT /api/categories/{id}`
- **描述**：更新分类信息
- **入参**：
  - 路径参数：
    - `id`：分类ID，整数类型，必填
  - 请求体：
    ```json
    {
      "categoryName": "xxx",    // 分类名称，字符串类型，可选
      "sortOrder": 0,          // 排序号，整数类型，可选
      "isAvailable": true      // 是否可用，布尔类型，可选
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true              // 更新成功返回true，失败返回false
  }
  ```

### 更新分类状态
- **接口**：`PUT /api/categories/{id}/status`
- **描述**：更新分类上下架状态
- **入参**：
  - 路径参数：
    - `id`：分类ID，整数类型，必填
  - 查询参数：
    - `isAvailable`：是否可用，布尔类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true              // 更新成功返回true，失败返回false
  }
  ```

### 更新分类排序
- **接口**：`PUT /api/categories/{id}/sort`
- **描述**：更新分类排序号
- **入参**：
  - 路径参数：
    - `id`：分类ID，整数类型，必填
  - 查询参数：
    - `sortOrder`：排序号，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true              // 更新成功返回true，失败返回false
  }
  ```

### 删除分类
- **接口**：`DELETE /api/categories/{id}`
- **描述**：删除分类
- **入参**：
  - 路径参数：
    - `id`：分类ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true              // 删除成功返回true，失败返回false
  }
  ```

### 获取所有分类列表
- **接口**：`GET /api/categories`
- **描述**：获取所有分类（包含不可用）
- **入参**：无
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "categoryId": 1,          // 分类ID，整数类型
        "categoryName": "xxx",    // 分类名称，字符串类型
        "sortOrder": 0,          // 排序号，整数类型
        "isAvailable": true,     // 是否可用，布尔类型
        "createdAt": "xxx",      // 创建时间，日期时间类型
        "updatedAt": "xxx"       // 更新时间，日期时间类型
      }
    ]
  }
  ```

## 用户管理接口

### 获取用户信息
- **接口**：`GET /api/users/openid/{openid}`
- **描述**：根据微信OpenID获取用户信息
- **入参**：
  - 路径参数：
    - `openid`：微信OpenID，字符串类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "userId": 1,          // 用户ID，整数类型
      "wxOpenid": "xxx",    // 微信OpenID，字符串类型
      "nickname": "xxx",    // 用户昵称，字符串类型
      "avatarUrl": "xxx",   // 头像URL，字符串类型
      "phone": "xxx",       // 手机号，字符串类型
      "createTime": "xxx",  // 创建时间，日期时间类型
      "updateTime": "xxx"   // 更新时间，日期时间类型
    }
  }
  ```

### 创建用户
- **接口**：`POST /api/users`
- **描述**：创建新用户
- **入参**：
  - 请求体：
    ```json
    {
      "wxOpenid": "xxx",    // 微信OpenID，字符串类型，必填
      "nickname": "xxx",    // 用户昵称，字符串类型，必填
      "avatarUrl": "xxx",   // 头像URL，字符串类型，可选
      "phone": "xxx"        // 手机号，字符串类型，可选
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true           // 创建成功返回true，失败返回false
  }
  ```

### 更新用户信息
- **接口**：`PUT /api/users/{id}`
- **描述**：更新用户信息
- **入参**：
  - 路径参数：
    - `id`：用户ID，整数类型，必填
  - 请求体：
    ```json
    {
      "nickname": "xxx",    // 用户昵称，字符串类型，可选
      "avatarUrl": "xxx",   // 头像URL，字符串类型，可选
      "phone": "xxx"        // 手机号，字符串类型，可选
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true           // 更新成功返回true，失败返回false
  }
  ```

## 菜品管理接口

### 获取可用菜品列表
- **接口**：`GET /api/dishes/available`
- **描述**：获取所有可用的菜品列表
- **入参**：无
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "dishId": 1,           // 菜品ID，整数类型
        "categoryId": 1,       // 分类ID，整数类型
        "dishName": "xxx",     // 菜品名称，字符串类型
        "price": 10.00,        // 价格，浮点数类型
        "description": "xxx",   // 描述，字符串类型
        "dishImageUrl": "xxx",  // 图片URL，字符串类型
        "isAvailable": true,    // 是否可用，布尔类型
        "sortOrder": 0,        // 排序号，整数类型
        "createdAt": "xxx",    // 创建时间，日期时间类型
        "updatedAt": "xxx"     // 更新时间，日期时间类型
      }
    ]
  }
  ```

### 根据分类获取可用菜品列表
- **接口**：`GET /api/dishes/category/{categoryId}/available`
- **描述**：根据分类ID获取可用的菜品列表
- **入参**：
  - 路径参数：
    - `categoryId`：分类ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "dishId": 1,           // 菜品ID，整数类型
        "categoryId": 1,       // 分类ID，整数类型
        "dishName": "xxx",     // 菜品名称，字符串类型
        "price": 10.00,        // 价格，浮点数类型
        "description": "xxx",   // 描述，字符串类型
        "dishImageUrl": "xxx",  // 图片URL，字符串类型
        "isAvailable": true,    // 是否可用，布尔类型
        "sortOrder": 0,        // 排序号，整数类型
        "createdAt": "xxx",    // 创建时间，日期时间类型
        "updatedAt": "xxx"     // 更新时间，日期时间类型
      }
    ]
  }
  ```

### 根据分类获取所有菜品列表
- **接口**：`GET /api/dishes/category/{categoryId}`
- **描述**：根据分类ID获取所有菜品列表（包含不可用）
- **入参**：
  - 路径参数：
    - `categoryId`：分类ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "dishId": 1,           // 菜品ID，整数类型
        "categoryId": 1,       // 分类ID，整数类型
        "dishName": "xxx",     // 菜品名称，字符串类型
        "price": 10.00,        // 价格，浮点数类型
        "description": "xxx",   // 描述，字符串类型
        "dishImageUrl": "xxx",  // 图片URL，字符串类型
        "isAvailable": true,    // 是否可用，布尔类型
        "sortOrder": 0,        // 排序号，整数类型
        "createdAt": "xxx",    // 创建时间，日期时间类型
        "updatedAt": "xxx"     // 更新时间，日期时间类型
      }
    ]
  }
  ```

### 获取菜品详情
- **接口**：`GET /api/dishes/{id}`
- **描述**：根据ID获取菜品信息
- **入参**：
  - 路径参数：
    - `id`：菜品ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "dishId": 1,           // 菜品ID，整数类型
      "categoryId": 1,       // 分类ID，整数类型
      "dishName": "xxx",     // 菜品名称，字符串类型
      "price": 10.00,        // 价格，浮点数类型
      "description": "xxx",   // 描述，字符串类型
      "dishImageUrl": "xxx",  // 图片URL，字符串类型
      "isAvailable": true,    // 是否可用，布尔类型
      "sortOrder": 0,        // 排序号，整数类型
      "createdAt": "xxx",    // 创建时间，日期时间类型
      "updatedAt": "xxx"     // 更新时间，日期时间类型
    }
  }
  ```

### 创建菜品
- **接口**：`POST /api/dishes`
- **描述**：创建新菜品
- **入参**：
  - 请求体：
    ```json
    {
      "categoryId": 1,        // 分类ID，整数类型，必填
      "dishName": "xxx",      // 菜品名称，字符串类型，必填
      "price": 10.00,         // 价格，浮点数类型，必填
      "description": "xxx",    // 描述，字符串类型，可选
      "dishImageUrl": "xxx",   // 图片URL，字符串类型，可选
      "isAvailable": true,     // 是否可用，布尔类型，可选，默认true
      "sortOrder": 0          // 排序号，整数类型，可选
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 创建成功返回true，失败返回false
  }
  ```

### 更新菜品信息
- **接口**：`PUT /api/dishes/{id}`
- **描述**：更新菜品信息
- **入参**：
  - 路径参数：
    - `id`：菜品ID，整数类型，必填
  - 请求体：
    ```json
    {
      "categoryId": 1,        // 分类ID，整数类型，可选
      "dishName": "xxx",      // 菜品名称，字符串类型，可选
      "price": 10.00,         // 价格，浮点数类型，可选
      "description": "xxx",    // 描述，字符串类型，可选
      "dishImageUrl": "xxx",   // 图片URL，字符串类型，可选
      "sortOrder": 0          // 排序号，整数类型，可选
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 更新成功返回true，失败返回false
  }
  ```

### 更新菜品状态
- **接口**：`PUT /api/dishes/{id}/status`
- **描述**：更新菜品上下架状态
- **入参**：
  - 路径参数：
    - `id`：菜品ID，整数类型，必填
  - 查询参数：
    - `isAvailable`：是否可用，布尔类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 更新成功返回true，失败返回false
  }
  ```

### 更新菜品排序
- **接口**：`PUT /api/dishes/{id}/sort`
- **描述**：更新菜品排序号
- **入参**：
  - 路径参数：
    - `id`：菜品ID，整数类型，必填
  - 查询参数：
    - `sortOrder`：排序号，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 更新成功返回true，失败返回false
  }
  ```

### 删除菜品
- **接口**：`DELETE /api/dishes/{id}`
- **描述**：删除菜品
- **入参**：
  - 路径参数：
    - `id`：菜品ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 删除成功返回true，失败返回false
  }
  ```

### 获取所有菜品列表
- **接口**：`GET /api/dishes`
- **描述**：获取所有菜品（包含不可用）
- **入参**：无
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "dishId": 1,           // 菜品ID，整数类型
        "categoryId": 1,       // 分类ID，整数类型
        "dishName": "xxx",     // 菜品名称，字符串类型
        "price": 10.00,        // 价格，浮点数类型
        "description": "xxx",   // 描述，字符串类型
        "dishImageUrl": "xxx",  // 图片URL，字符串类型
        "isAvailable": true,    // 是否可用，布尔类型
        "sortOrder": 0,        // 排序号，整数类型
        "createdAt": "xxx",    // 创建时间，日期时间类型
        "updatedAt": "xxx"     // 更新时间，日期时间类型
      }
    ]
  }
  ```

## 购物车管理接口

### 获取用户购物车
- **接口**：`GET /api/cart/user/{userId}`
- **描述**：获取用户的购物车列表
- **入参**：
  - 路径参数：
    - `userId`：用户ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "cartId": 1,          // 购物车项ID，整数类型
        "userId": 1,          // 用户ID，整数类型
        "dishId": 1,          // 菜品ID，整数类型
        "quantity": 2,        // 数量，整数类型
        "createTime": "xxx",  // 创建时间，日期时间类型
        "updateTime": "xxx",  // 更新时间，日期时间类型
        "dish": {            // 菜品信息，对象类型
          "dishId": 1,
          "name": "xxx",
          "price": 10.00
        }
      }
    ]
  }
  ```

### 添加购物车项
- **接口**：`POST /api/cart`
- **描述**：添加商品到购物车
- **入参**：
  - 请求体：
    ```json
    {
      "userId": 1,    // 用户ID，整数类型，必填
      "dishId": 1,    // 菜品ID，整数类型，必填
      "quantity": 2   // 数量，整数类型，必填，必须大于0
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true      // 添加成功返回true，失败返回false
  }
  ```

### 更新购物车项数量
- **接口**：`PUT /api/cart/{id}/quantity`
- **描述**：更新购物车中商品的数量
- **入参**：
  - 路径参数：
    - `id`：购物车项ID，整数类型，必填
  - 查询参数：
    - `quantity`：更新的数量，整数类型，必填，必须大于0
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true      // 更新成功返回true，失败返回false
  }
  ```

### 清空用户购物车
- **接口**：`DELETE /api/cart/user/{userId}`
- **描述**：清空用户的购物车
- **入参**：
  - 路径参数：
    - `userId`：用户ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true      // 清空成功返回true，失败返回false
  }
  ```

### 删除购物车项
- **接口**：`DELETE /api/cart/{id}`
- **描述**：从购物车中删除指定项
- **入参**：
  - 路径参数：
    - `id`：购物车项ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true      // 删除成功返回true，失败返回false
  }
  ```

## 订单管理接口

### 创建订单
- **接口**：`POST /api/orders/user/{userId}`
- **描述**：为指定用户创建新订单
- **入参**：
  - 路径参数：
    - `userId`：用户ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "orderId": 1,           // 订单ID，整数类型
      "userId": 1,            // 用户ID，整数类型
      "status": "CREATED",    // 订单状态，字符串类型，可选值：CREATED/PAID/COMPLETED/CANCELLED
      "totalAmount": 100.00,  // 订单总金额，浮点数类型
      "createTime": "xxx",    // 创建时间，日期时间类型
      "updateTime": "xxx",    // 更新时间，日期时间类型
      "orderDetails": [      // 订单详情列表，数组类型
        {
          "orderDetailId": 1, // 订单详情ID，整数类型
          "orderId": 1,       // 订单ID，整数类型
          "dishId": 1,        // 菜品ID，整数类型
          "quantity": 2,      // 数量，整数类型
          "price": 50.00      // 单价，浮点数类型
        }
      ]
    }
  }
  ```

### 获取用户订单列表
- **接口**：`GET /api/orders/user/{userId}`
- **描述**：获取用户的所有订单
- **入参**：
  - 路径参数：
    - `userId`：用户ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "orderId": 1,           // 订单ID，整数类型
        "userId": 1,            // 用户ID，整数类型
        "status": "CREATED",    // 订单状态，字符串类型
        "totalAmount": 100.00,  // 订单总金额，浮点数类型
        "createTime": "xxx",    // 创建时间，日期时间类型
        "updateTime": "xxx",    // 更新时间，日期时间类型
        "orderDetails": [      // 订单详情列表，数组类型
          {
            "orderDetailId": 1,
            "orderId": 1,
            "dishId": 1,
            "quantity": 2,
            "price": 50.00
          }
        ]
      }
    ]
  }
  ```

### 获取订单详情
- **接口**：`GET /api/orders/{id}`
- **描述**：根据ID获取订单信息
- **入参**：
  - 路径参数：
    - `id`：订单ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "orderId": 1,           // 订单ID，整数类型
      "userId": 1,            // 用户ID，整数类型
      "status": "CREATED",    // 订单状态，字符串类型
      "totalAmount": 100.00,  // 订单总金额，浮点数类型
      "createTime": "xxx",    // 创建时间，日期时间类型
      "updateTime": "xxx",    // 更新时间，日期时间类型
      "orderDetails": [      // 订单详情列表，数组类型
        {
          "orderDetailId": 1,
          "orderId": 1,
          "dishId": 1,
          "quantity": 2,
          "price": 50.00,
          "dish": {          // 菜品信息，对象类型
            "dishId": 1,
            "name": "xxx",
            "price": 50.00
          }
        }
      ]
    }
  }
  ```

### 更新订单状态
- **接口**：`PUT /api/orders/{id}/status`
- **描述**：更新订单状态
- **入参**：
  - 路径参数：
    - `id`：订单ID，整数类型，必填
  - 查询参数：
    - `status`：新的订单状态，字符串类型，必填，可选值：CREATED/PAID/COMPLETED/CANCELLED
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true             // 更新成功返回true，失败返回false
  }
  ```

## 评价管理接口

### 获取订单评价列表
- **接口**：`GET /api/reviews/order-detail/{orderDetailId}`
- **描述**：获取订单详情的所有评价
- **入参**：
  - 路径参数：
    - `orderDetailId`：订单详情ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "reviewId": 1,          // 评价ID，整数类型
        "orderDetailId": 1,      // 订单详情ID，整数类型
        "userId": 1,            // 用户ID，整数类型
        "content": "xxx",       // 评价内容，字符串类型
        "rating": 5,           // 评分，整数类型，1-5
        "createTime": "xxx",    // 创建时间，日期时间类型
        "updateTime": "xxx",    // 更新时间，日期时间类型
        "user": {              // 用户信息，对象类型
          "userId": 1,
          "nickname": "xxx",
          "avatarUrl": "xxx"
        }
      }
    ]
  }
  ```

### 获取用户评价列表
- **接口**：`GET /api/reviews/user/{userId}`
- **描述**：获取用户的所有评价
- **入参**：
  - 路径参数：
    - `userId`：用户ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": [
      {
        "reviewId": 1,          // 评价ID，整数类型
        "orderDetailId": 1,      // 订单详情ID，整数类型
        "userId": 1,            // 用户ID，整数类型
        "content": "xxx",       // 评价内容，字符串类型
        "rating": 5,           // 评分，整数类型，1-5
        "createTime": "xxx",    // 创建时间，日期时间类型
        "updateTime": "xxx",    // 更新时间，日期时间类型
        "orderDetail": {       // 订单详情信息，对象类型
          "orderDetailId": 1,
          "dishId": 1,
          "dish": {
            "dishId": 1,
            "name": "xxx"
          }
        }
      }
    ]
  }
  ```

### 创建评价
- **接口**：`POST /api/reviews`
- **描述**：创建新的评价
- **入参**：
  - 请求体：
    ```json
    {
      "orderDetailId": 1,   // 订单详情ID，整数类型，必填
      "userId": 1,         // 用户ID，整数类型，必填
      "content": "xxx",    // 评价内容，字符串类型，必填
      "rating": 5         // 评分，整数类型，必填，范围1-5
    }
    ```
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": true          // 创建成功返回true，失败返回false
  }
  ```

### 获取评价详情
- **接口**：`GET /api/reviews/{id}`
- **描述**：根据ID获取评价信息
- **入参**：
  - 路径参数：
    - `id`：评价ID，整数类型，必填
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": {
      "reviewId": 1,          // 评价ID，整数类型
      "orderDetailId": 1,      // 订单详情ID，整数类型
      "userId": 1,            // 用户ID，整数类型
      "content": "xxx",       // 评价内容，字符串类型
      "rating": 5,           // 评分，整数类型，1-5
      "createTime": "xxx",    // 创建时间，日期时间类型
      "updateTime": "xxx",    // 更新时间，日期时间类型
      "user": {              // 用户信息，对象类型
        "userId": 1,
        "nickname": "xxx",
        "avatarUrl": "xxx"
      },
      "orderDetail": {       // 订单详情信息，对象类型
        "orderDetailId": 1,
        "dishId": 1,
        "dish": {
          "dishId": 1,
          "name": "xxx"
        }
      }
    }
  }
  ```

## 计数器接口

### 获取计数
- **接口**：`GET /api/count`
- **描述**：获取当前计数值，如果计数器不存在则返回0
- **入参**：无
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": 42              // 当前计数值，整数类型
  }
  ```

### 更新计数
- **接口**：`POST /api/count`
- **描述**：更新计数器的值
- **入参**：
  - 请求体：
    ```json
    {
      "action": "inc"      // 操作类型，字符串类型，必填，可选值：inc/clear
    }
    ```
- **说明**：
  - `action` 为 `"inc"` 时，计数值加1
  - `action` 为 `"clear"` 时，计数值清零
- **出参**：
  ```json
  {
    "code": 200,
    "message": "操作成功",
    "data": 43             // 更新后的计数值，整数类型
  }
  ```

## 错误码说明

| 错误码 | 说明 | 处理建议 |
|--------|------|----------|
| 200 | 操作成功 | 正常处理响应数据 |
| 400 | 请求参数错误 | 检查请求参数是否符合要求 |
| 401 | 未授权 | 检查用户是否登录 |
| 403 | 无权限访问 | 检查用户权限 |
| 404 | 资源不存在 | 检查请求的资源ID是否正确 |
| 500 | 服务器内部错误 | 联系管理员 |
| 1000 | 用户不存在 | 检查用户ID是否正确 |
| 1001 | 用户已存在 | 更换用户标识 |
| 2000 | 菜品不存在 | 检查菜品ID是否正确 |
| 2001 | 菜品已下架 | 选择其他可用菜品 |
| 3000 | 购物车为空 | 添加商品到购物车 |
| 3001 | 购物车商品不存在 | 检查购物车项ID是否正确 |
| 4000 | 订单不存在 | 检查订单ID是否正确 |
| 4001 | 订单状态错误 | 检查订单当前状态是否允许操作 |
| 5000 | 评价不存在 | 检查评价ID是否正确 |
| 5001 | 该订单已评价 | 不能重复评价 | 