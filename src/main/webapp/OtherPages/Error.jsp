<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="error-container">
        <div class="error-content">
            <div class="error-icon">
                <i class="fas fa-exclamation-circle"></i>
            </div>
            <h1>Something Went Wrong!</h1>
            <p>We encountered an issue processing your request. Please try again later.</p>
            <p>If the problem persists, contact our support team.</p>
            <form method="get" action="HomeServlet">
            <button type="Submit" class="btn">Return to Home</button>
            </form>
        </div>
    </div>
</body>
</html>