<head>
    <style>
        /* Ensure the whole document is at least 100% of the viewport height */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
        }

        /* Main content should take up all available space */
        .content {
            flex: 1;
        }

        /* Footer should always be at the bottom */
        footer {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            flex-shrink: 0; /* Prevents the footer from shrinking */
        }

        footer p {
            margin: 0;
        }

        footer a {
            color: white;
            text-decoration: none;
        }

        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="content">
        <!-- Your page content goes here -->
    </div>

    <footer>
        <p>&copy; 2024 RevShop. All rights reserved.</p>
        <p>Made with <span style="color: red;">&hearts;</span> by <a href="https://www.linkedin.com/in/sudeepj24/">Sudeep</a></p>
    </footer>
</body>
