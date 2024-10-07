<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <title>Douleur Graph</title>
</head>
<body>
    <canvas id="myChart" width="400" height="400"></canvas>
    <script>
        // Assuming jsonData contains your JSON data
        var jsonData = <%= request.getAttribute("jsonData") %>;

        // Extracting dates and degrees from the JSON data
        var dates = jsonData.map(douleur => douleur.date);
        var degrees = jsonData.map(douleur => douleur.degre);

        // Creating a line chart
        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: dates,
                datasets: [{
                    label: 'Degrees of Douleur',
                    data: degrees,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    x: [{
                        type: 'time',
                        time: {
                            unit: 'day' // Adjust the time unit as needed
                        },
                        title: {
                            display: true,
                            text: 'Date'
                        }
                    }],
                    y: {
                        title: {
                            display: true,
                            text: 'Degrees'
                        }
                    }
                }
            }
        });
    </script>
</body>
</html>
