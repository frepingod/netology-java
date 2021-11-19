select c.*, o.product_name
from CUSTOMERS c
    left join ORDERS o on c.id = o.customer_id
where c.name = 'alexey';