# 前言

## 应用环境

### 版本管理

[Gitee - WithChat 简约聊天室](https://gitee.com/LinexWolf/WithChat)

#### 分支

- master 主分支：某功能开发完毕且测试无误后合并到主分支
- develop 开发分支：按流程进度开发时均变基该分支进行
- feature 特性分支：在主分支基础上做新尝试时签出到该分支进行

#### Angular 提交规范

提交时遵循 Angular 规范，每次提交可以包括页眉、正文、页脚，每次提交**必须包括页眉内容**，每次提交不超过 100 个字符。

页眉格式指定为提交类型、作用域（可选）和主题。提交类型指定为以下其中一个：

1. `build`：对构建系统或者外部依赖项进行了修改
2. `ci`：对CI配置文件或脚本进行了修改
3. `docs`：对文档进行了修改
4. `feat`：增加新的特征
5. `fix`：修复`bug`
6. `pref`：提高性能的代码更改
7. `refactor`：既不是修复`bug`也不是添加特征的代码重构
8. `style`：不影响代码含义的修改，比如空格、格式化、缺失的分号等
9. `test`：增加确实的测试或者矫正已存在的测试

### 系统

- macOS 15.0 Beta 24A5279h
- 

### 硬件环境

- M3 Max 36GB / 4TB
- 

### 软件环境

#### 后端

- Java 开发工具 JDK 17
- Spring Framework 6.0.4
- Spring Boot 3.0.2
- 数据库 MySQL 8.1
- 构建工具 Maven 3.9.7
- Http 服务器 Nginx 1.27.0
- 容器 Docker For Mac 4.25.1

#### 前端

- 

## 目的

一个基于 Web 平台的聊天室项目。

可以用于点对点聊天、群组聊天、文件传送、群组文件共享、个人博客空间等。

后续扩展更多功能。

## 缩写说明

本文中若无特殊说明，将遵循以下缩写规定，格式为 [缩写名：全称]。

- 聊天室：WithChat 聊天室平台
- 

## 术语定义

本文中若无特殊说明，将遵循以下定义规定，格式为 [术语: 术语定义]

- 单体消息：指单个用户对单个用户之间的消息收发
- 

## 环境搭建

### 容器

#### 网络环境

网络名称为 withchat-net。

```SQL
docker network create withchat-net
docker network inspect withchat-net
```

#### MySQL

##### 启动参数

注：如非 ARM 平台，需删除 --platform 一行

```Plain
docker run -d \
  --name mysql \
  --platform=linux/amd64 \
  -p 3306:3306 \
  -e TZ=Asia/Shanghai \
  -e MYSQL_ROOT_PASSWORD=chatdev \
  -v /Volumes/Documents/ShareToContainer/withchat/mysql/data:/var/lib/mysql \
  -v /Volumes/Documents/ShareToContainer/withchat/mysql/init:/docker-entrypoint-initdb.d \
  -v /Volumes/Documents/ShareToContainer/withchat/mysql/config:/etc/mysql/conf.d \
  --restart always \
  mysql
```

##### 映射配置文件

```SQL
[client]
default_character_set=utf8mb4
[mysql]
default_character_set=utf8mb4
[mysqld]
character_set_server=utf8mb4
collation_server=utf8mb4_unicode_ci
init_connect='SET NAMES utf8mb4'
```

#### Nginx

# 需求分析

## 角色

- 高级管理员：对聊天室管理员进行管理
  - 管理员基本信息管理
  - 管理员任务管理
- 管理员：对聊天室用户、群进行管理
  - 用户管理
  - 群管理
- 用户：聊天室使用者，可以进行好友聊天、群组聊天、文件传送、群组文件共享等
  - 用户管理
  - 好友管理
  - 群管理
  - 博客空间管理

## 身份

- 高级管理员：可以管理聊天室管理员
- 管理员：可以管理聊天室用户、群组
- 用户：聊天室的使用者
- 群主：针对群组，群组的创建者
- 群管理员：针对群组，群主分配的管理员，可以管理群
- 群成员：针对群组，群组内的成员
- 博主：博客文章的发布者
- 博客合作者：博主所指定的博客文章的协作者

## 功能

### 基本功能

- 用户/高级管理员/管理员 登陆
- 用户注册
- 消息收发

### 管理员基本信息管理

对管理员的基本信息进行管理，包括：

- 新增/启用/停用/删除管理员
- 修改基本信息（头像、昵称、密码等）

### 管理员任务管理

对管理员的任务分配进行修改，包括：

- 全体管理员管理用户数量分配
- 指定管理员管理指定用户数量
- 指定管理员管理指定用户

### 用户管理

对用户进行管理，包括

- 新增/启用/停用/注销 用户
- 修改在线状态
- 修改基本信息（头像、昵称、密码等）

### 群管理

对群组进行管理，包括

- 新增/启用/停用/删除 群
- 修改基本信息（头像、昵称、公告等）
- 群组成员管理
  - 群主/群管理员身份修改
  - 新增/删除 群管理员身份
  - 新增/删除 群成员
  - 修改群成员昵称
- 新增/删除 群文件
- 群组消息管理
  - 新增消息
  - 撤回/删除 历史消息

### 好友管理

- 新增/删除 好友
- 设置上线提醒
- 修改好友备注
- 好友消息管理
  - 新增消息
  - 撤回/删除 历史消息

### 博客空间管理

- 待定

# 数据库设计

## 用户表

| 字段名   | 字段类型     | 主键约束 | 非空约束 | 唯一约束 | 默认值 | 备注                         |
| :------- | :----------- | :------- | :------- | :------- | :----- | :--------------------------- |
| uid      | int          | 1        | 1        | 1        |        | 用户 ID，自增，从 10000 开始 |
| nickname | varchar(50)  |          | 1        |          |        | 用户昵称                     |
| u_sig    | varchar(255) |          |          |          |        | 用户个性签名                 |
| u_avatar | varchar(255) |          |          |          |        | 用户头像（地址）             |
| u_pwd    | varchar(255) |          | 1        |          |        | 用户密码（非对称加密）       |
| disable  | char(1)      |          | 1        |          | 1      | 是否启用：0-启用，1-停用     |

## 管理员表

| 字段名     | 字段类型     | 主键约束 | 非空约束 | 唯一约束 | 默认值 | 备注                         |
| :--------- | :----------- | :------- | :------- | :------- | :----- | :--------------------------- |
| aid        | int          | 1        | 1        | 1        |        | 管理员 ID，自增，从 100 开始 |
| admin_name | varchar(50)  |          | 1        |          |        | 管理员名称                   |
| a_pwd      | varchar(255) |          | 1        |          |        | 管理员密码（非对称加密）     |
| disable    | char(1)      |          | 1        |          | 1      | 是否启用：0-启用，1-停用     |

# 功能分析

## 管理员基本信息管理

## 管理员任务管理

## 用户管理

## 群管理

## 好友管理

## 博客空间管理

# 开发周期

## 第一阶段  8.15 - 8.25

https://applink.feishu.cn/client/todo/task_list?guid=edcd3518-4f21-4039-9d6e-dbef04f735b3