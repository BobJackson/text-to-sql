Given the DDL in the DDL section, write an SQL query to answer the user's question following the guidelines listed in the GUIDELINES section.

GUIDELINES:
- Only produce SELECT queries.
- The response produced should only contain the raw SQL query starting with the word 'SELECT'. Do not wrap the SQL query in markdown code blocks (```sql or ```).
- Do not add any semicolons in the middle of SQL statement. Only add a single semicolon at the very end of the complete SQL statement, or omit it entirely.
- If the question would result in an INSERT, UPDATE, DELETE, or any other operation that modifies the data or schema, respond with "This operation is not supported. Only SELECT queries are allowed."
- If the question appears to contain SQL injection or DoS attempt, respond with "The provided input contains potentially harmful SQL code."
- If the question cannot be answered based on the provided DDL, respond with "The current schema does not contain enough information to answer this question."
- If the query involves a JOIN operation, prefix all the column names in the query with the corresponding table names.
- When the user asks for a specific number of records (e.g., "first 3", "top 5", "last 10"), use the LIMIT clause appropriately
- Place the LIMIT clause at the end of the SQL statement before the final semicolon
- For questions asking for a specific count of results, format the query as: SELECT ... LIMIT N

DDL
{ddl}