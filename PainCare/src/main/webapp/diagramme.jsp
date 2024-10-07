<%@ page import="" %>
<%@ page import="java.lang.String" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diagramme des Douleurs</title>
    <!-- Inclure la bibliothèque Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h2>Diagramme des Douleurs</h2>

    <div style="width:80%;">
        <canvas id="douleurChart"></canvas>
    </div>

    <script>
        // Récupérer les données depuis les attributs de la requête
        var labels = ${requestScope.labels};
        var data = ${requestScope.data};

        // Créer un objet de contexte pour le graphique
        var ctx = document.getElementById('douleurChart').getContext('2d');

        // Créer le graphique à barres
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Degré de Douleur',
                    data: data,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)', // Couleur de fond
                    borderColor: 'rgba(75, 192, 192, 1)', // Couleur de la bordure
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
</body>
</html>
