<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Success</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
    body {
    margin: 0;
    padding: 0;
    font-family: 'Arial', sans-serif;
    background-color: #f8f8f8;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.success-container {
    background-color: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 500px;
    width: 100%;
}

.success-content {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.success-icon {
    font-size: 100px;
    color: #28a745;
    margin-bottom: 20px;
}

h1 {
    font-size: 28px;
    margin-bottom: 10px;
    color: #333;
}

p {
    font-size: 16px;
    color: #666;
    margin: 5px 0;
}

p strong {
    color: #333;
}

.btn {
    display: inline-block;
    margin-top: 20px;
    padding: 12px 25px;
    background-color: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #218838;
}
    
    </style>
</head>
<body>
    <div class="success-container">
        <div class="success-content">
            <div class="success-icon">
                <i class="fas fa-check-circle"></i>
            </div>
            <h1>Order Placed Successfully!</h1>
            <p>Thank you for your purchase.</p>
            <p>You will receive an email confirmation shortly with your order details.</p>
            <form action="/RevShopRevature/HomeServlet" method="get">
            <button type="submit" class="btn">Continue Shopping</button>
            </form>
        </div>
    </div>
</body>
</html>