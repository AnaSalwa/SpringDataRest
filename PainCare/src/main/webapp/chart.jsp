<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <title>Votre Page</title>
</head>
<body>
    <!-- Le reste de votre contenu HTML -->
    <canvas id="myChart" width="400" height="200"></canvas>

    <script>
        // Code JavaScript pour récupérer les données et créer le graphe
        // Utilisez AJAX pour récupérer les données JSON depuis votre servlet

        fetch('votre_servlet_url?action=graph')
            .then(response => response.json())
            .then(data => {
                // Créez un tableau pour stocker les dates et les degrés
                const dates = data.map(entry => entry.date);
                const degres = data.map(entry => entry.degre);

                // Créez un objet de configuration pour le graphe
                const config = {
                    type: 'line',
                    data: {
                        labels: dates,
                        datasets: [{
                            label: 'Degré de douleur',
                            data: degres,
                            fill: false,
                            borderColor: 'rgb(75, 192, 192)',
                            tension: 0.1
                        }]
                    }
                };

                // Obtenez le contexte du canvas
                const ctx = document.getElementById('myChart').getContext('2d');

                // Créez le graphe avec Chart.js
                const myChart = new Chart(ctx, config);
            })
            .catch(error => console.error('Erreur lors de la récupération des données:', error));
    </script>
</body>
</html>
