# Text to SQL Chatbot

一个基于Spring AI的自然语言转SQL查询系统，能够将用户的自然语言问题转换为可执行的SQL查询语句。

## 功能特点

- 🤖 基于大语言模型的自然语言理解
- 🔄 自然语言到SQL查询的自动转换
- 🛡️ 安全的SQL执行环境
- 📊 支持复杂查询（JOIN、LIMIT等）
- 🚫 仅支持SELECT查询，防止数据修改

## 技术栈

- Spring Boot 6.2.x
- Spring AI
- MySQL数据库
- Hibernate/JPA
- HikariCP连接池

## 系统架构

```mermaid
graph LR
    A[用户输入] --> B[ChatClient]
    B --> C[LLM模型]
    C --> D[SQL生成]
    D --> E[SqlExecutor]
    E --> F[数据库执行]
    F --> G[结果返回]
```

## 使用指南

### 基本查询

- "显示所有用户信息"
- "查找来自北京的客户"

### 带数量限制的查询

- "显示前5个产品" → `SELECT * FROM products LIMIT 5`
- "给我一个员工信息" → `SELECT * FROM employees LIMIT 1`

### 复杂查询

- "显示属于斯莱特林学院的巫师姓名和血统" → 包含JOIN操作的查询

## 安全特性

- 仅允许SELECT查询执行
- 自动检测并阻止潜在的SQL注入攻击
- 输入验证和错误处理

## 配置说明

系统通过 [system-prompt.st](file:///Users/bob/practice/text-to-sql/src/main/resources/system-prompt.st) 文件定义了详细的SQL生成规则：

- 只生成SELECT查询语句
- 正确处理LIMIT子句
- 自动识别单数/复数请求并添加相应限制
- 防止在SQL语句中间添加分号
- JOIN查询时自动添加表前缀

## 部署要求

- Java 17+
- MySQL 8.0+
- 可访问的大语言模型API（如阿里云通义千问）

## 快速开始

1. 配置数据库连接
2. 设置AI模型API密钥
3. 运行应用程序
4. 通过REST API发送自然语言查询

## API端点

- `POST /query` - 发送自然语言查询
- 响应格式：JSON数组形式的查询结果

## 注意事项

- 系统仅支持读取操作，不会修改数据库内容
- 查询性能取决于底层数据库索引和结构
- 复杂查询可能需要调整AI模型的提示词模板