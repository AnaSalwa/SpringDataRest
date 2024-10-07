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
        // Code JavaScript pour r�cup�rer les donn�es et cr�er le graphe
        // Utilisez AJAX pour r�cup�rer les donn�es JSON depuis votre servlet

        fetch('votre_servlet_url?action=graph')
            .then(response => response.json())
            .then(data => {
                // Cr�ez un tableau pour stocker les dates et les degr�s
                const dates = data.map(entry => entry.date);
                const degres = data.map(entry => entry.degre);

                // Cr�ez un objet de configuration pour le graphe
                const config = {
                    type: 'line',
                    data: {
                        labels: dates,
                        datasets: [{
                            label: 'Degr� de douleur',
                            data: degres,
                            fill: false,
                            borderColor: 'rgb(75, 192, 192)',
                            tension: 0.1
                        }]
                    }
                };

                // Obtenez le contexte du canvas
                const ctx = document.getElementById('myChart').getContext('2d');

                // Cr�ez le graphe avec Chart.js
                const myChart = new Chart(ctx, config);
            })
            .catch(error => console.error('Erreur lors de la r�cup�ration des donn�es:', error));
    </script>
</body>
</html>
