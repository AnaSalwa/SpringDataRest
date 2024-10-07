<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.JAVA.Bean.UserBean" %>
<% UserBean user = (UserBean) request.getSession().getAttribute("User"); %>

<!DOCTYPE html>

<html lang="en" class="light-style layout-navbar-fixed layout-menu-fixed layout-compact " dir="ltr" data-theme="theme-semi-dark" data-assets-path="frontend/assets/" data-template="vertical-menu-template">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

    <title>Cards basic   - UI elements | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    
    <meta name="description" content="Most Powerful &amp; Comprehensive Bootstrap 5 HTML Admin Dashboard Template built for developers!" />
    <meta name="keywords" content="dashboard, bootstrap 5 dashboard, bootstrap 5 design, bootstrap 5">
    <!-- Canonical SEO -->
    <link rel="canonical" href="https://themeselection.com/item/sneat-bootstrap-html-admin-template/">
    
    
    <!-- ? PROD Only: Google Tag Manager (Default ThemeSelection: GTM-5DDHKGP, PixInvent: GTM-5J3LMKC) -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
      new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
      j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
      'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
      })(window,document,'script','dataLayer','GTM-5DDHKGP');</script>
    <!-- End Google Tag Manager -->
    
    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="images/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <!-- Icons -->
    <link rel="stylesheet" href="css/boxicons.css" />
    <link rel="stylesheet" href="css/fontawesome.css" />
    <link rel="stylesheet" href="css/flag-icons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="css/theme-semi-dark.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="css/demo.css" />
    
    <!-- Vendors CSS -->
    <link rel="stylesheet" href="css/perfect-scrollbar.css" />
    <link rel="stylesheet" href="css/typeahead.css" /> 
    

    <!-- Page CSS -->
    

    <!-- Helpers -->
    <script src="frontend/assets/vendor/js/helpers.js"></script>
    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Template customizer: To hide customizer set displayCustomizer value false in config.js.  -->
    <script src="js/template-customizer.js"></script>
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="js/config.js"></script>
        <link rel="icon" type="image/x-icon" href="frontend/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="frontend/assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="frontend/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="frontend/assets/vendor/css/theme-semi-dark.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="frontend/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="frontend/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <link rel="stylesheet" href="frontend/assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="frontend/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="frontend/assets/js/config.js"></script>
</head>
  <body>
    <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- Menu -->
			
			      <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
			
			 <div class="app-brand demo">
			  <a href="index.html" class="app-brand-link">
			    <span class="app-brand-logo demo">
			      <img src="frontend/assets/img/paincare.jpeg" alt="Logo Pain Care" width="40" height="40">
			    </span>
				<span class="app-brand-text demo menu-text fw-bolder ms-2" style="text-transform: uppercase;">Pain Care</span>
			  </a>
			</div>
			
			
			
			
			          <div class="menu-inner-shadow"></div>
			
			          <ul class="menu-inner py-1">
			            <!-- Dashboard -->
			            <li class="menu-item active">
			              <a href="dashboard.jsp" class="menu-link">
			                <i class="menu-icon tf-icons bx bx-home-circle"></i>
			                <div data-i18n="Analytics">Dashboard</div>
			              </a>
			            </li>

    

            <li class="menu-header small text-uppercase">
              <span class="menu-header-text">Profil</span>
            </li>
            <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class="menu-icon tf-icons bx bx-dock-top"></i>
                <div data-i18n="Account Settings">Paramètres</div>
              </a>
                <ul class="menu-sub">
                <li class="menu-item">
                  <a href="MonCompte.jsp" class="menu-link">
                    <div data-i18n="Account">Mon compte </div>
                  </a>
                </li>
	         <li class="menu-item">
			    <a href="deleteUser.jsp?nom=<%= user.getNom() %>" class="menu-link">
			        <div data-i18n="Notifications">Supprimer mon compte</div>
			    </a>
			</li>

                 <!-- <li class="menu-item">
                  <a href="pages-account-settings-connections.html" class="menu-link">
                    <div data-i18n="Connections">Connections</div>
                  </a>
                </li>-->
              </ul>
            </li>
         <!--    <li class="menu-item">
              <a href="alarmes.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-lock-open-alt"></i>
                <div data-i18n="Authentications">Alarmes</div>
              </a> -->
              
            </li>
             <li class="menu-item">
              <a href="calendar.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-detail"></i>
                
                <div data-i18n="Misc">Calendrier</div>
              </a>
            
            </li>
            <!-- Components -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">Communauté</span></li>
            <!-- Cards -->
            <li class="menu-item">
              <a href="PubServlet?action=getAllPublicationsWithUserNames" class="menu-link">
                <i class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Publications</div>
              </a>
            </li>
               <li class="menu-item">
              <a href="PubServlet?action=getMine&id_user=<%= user.getId() %>" class="menu-link">
                <i class="menu-icon tf-icons bx bx-detail"></i>
                <div data-i18n="Basic">Mes publications</div>
              </a> 
            </li>
       

            <!-- Extended components -->
            <li class="menu-item">
              <a href="blog.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-copy"></i>
                <div data-i18n="Extended UI">Blogs</div>
              </a>
           
            </li>

        

            <!-- Forms & Tables -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">Suivre mon état</span></li>
            <!-- Forms -->
            <li class="menu-item">
              <a href="Diagnostic.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-cube-alt"></i>
                <div data-i18n="Form Elements">Test de diagnostic</div>
              </a>
            
            
            </li>
            <li class="menu-item">
              <a href="DouleurServlet?action=getMyD&id_user=<%= user.getId() %>" class="menu-link">
                <i class="menu-icon tf-icons bx bx-detail"></i>
                <div data-i18n="Form Layouts">Graphes de douleurs</div>
              </a>
              
            </li>
            <!-- Tables -->
            <li class="menu-item">
              <a href="info.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-table"></i>
                <div data-i18n="Tables">Informations sur l'endométriose</div>
              </a>
            </li>
            
            
            
            <!-- Deconnexion -->
            
               <li class="menu-header small text-uppercase"><span class="menu-header-text">Déconnexion</span></li>
            <!-- Cards -->
            <li class="menu-item">
              <a href="index.html" class="menu-link">
                <i class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Se déconnecter</div>
              </a>
            </li>
       
            
            
            
            <!-- Misc -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">Support</span></li>
            <li class="menu-item">
              <a
                href="Contactez-nous.jsp"
                target="_blank"
                class="menu-link"
              >
                <i class="menu-icon tf-icons bx bx-support"></i>
                <div data-i18n="Support">Contactez-nous</div>
              </a>
            </li>
           
          </ul>
        </aside>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
          <!-- Navbar -->

          <nav
            class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
            id="layout-navbar"
          >
            <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
              <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                <i class="bx bx-menu bx-sm"></i>
              </a>
            </div>

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
              <!-- Search -->
              <div class="navbar-nav align-items-center">
                <div class="nav-item d-flex align-items-center">
                  <i class="bx bx-search fs-4 lh-0"></i>
                  <input
                    type="text"
                    class="form-control border-0 shadow-none"
                    placeholder="Search..."
                    aria-label="Search..."
                  />
                </div>
              </div>
              <!-- /Search -->

             <!--  <ul class="navbar-nav flex-row align-items-center ms-auto">
                <!-- Place this tag where you want the button to render. -->
              <!--   <li class="nav-item lh-1 me-3">
                  <a
                    class="github-button"
                    href="https://github.com/themeselection/sneat-html-admin-template-free"
                    data-icon="octicon-star"
                    data-size="large"
                    data-show-count="true"
                    aria-label="Star themeselection/sneat-html-admin-template-free on GitHub"
                    >Star</a
                  >
                </li>--> 

                <!-- User -->
             <!--   <li class="nav-item navbar-dropdown dropdown-user dropdown">
                  <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                      <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                  </a>
            <!--       <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                      <a class="dropdown-item" href="#">
                        <div class="d-flex">
                          <div class="flex-shrink-0 me-3">
                            <div class="avatar avatar-online">
                              <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                            </div>
                          </div>
                          <div class="flex-grow-1">
                            <span class="fw-semibold d-block">John Doe</span>
                            <small class="text-muted">Admin</small>
                          </div>
                        </div>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <i class="bx bx-user me-2"></i>
                        <span class="align-middle">My Profile</span>
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <i class="bx bx-cog me-2"></i>
                        <span class="align-middle">Settings</span>
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <span class="d-flex align-items-center align-middle">
                          <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                          <span class="flex-grow-1 align-middle">Billing</span>
                          <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="auth-login-basic.html">
                        <i class="bx bx-power-off me-2"></i>
                        <span class="align-middle">Log Out</span>
                      </a>
                    </li>
                  </ul> -->
                </li>
                <!--/ User -->
              </ul>
            </div>
          </nav>

          <!-- / Navbar -->

      

      <!-- Content wrapper -->
      <div class="content-wrapper">

        <!-- Content -->
        
          <div class="container-xxl flex-grow-1 container-p-y">
            
            
<h4 class="py-3 mb-4"><span class="text-muted fw-light"> Communauté </span> / Blogs</h4>

<!-- Examples -->

<!-- Examples -->

<!-- Content types -->
<h5 class="pb-1 mb-4">Dernieres sorties</h5>



<!--/ Content types -->


<!-- Grid Card -->
<h6 class="pb-1 mb-4 text-muted">Lisez et decouvrez</h6>
<div class="row row-cols-1 row-cols-md-3 g-4 mb-5">
 <!-- Partie de l'article visible initialement -->
<div id="article-complet" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee1.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Introduction a l'endometriose</h5>
        <p class="card-text">
          "L'endometriose est une affection gynecologique souvent meconnue mais qui affecte des millions de femmes dans le monde. Elle se caracterise par la croissance anormale de tissu semblable a la muqueuse de l'uterus en dehors de l'uterus. Decouvrez dans cet article tout ce que vous devez savoir sur cette condition debilitante. Les symptomes de l'endometriose varient d'une personne a l'autre, mais incluent souvent des douleurs pelviennes chroniques, des douleurs pendant les rapports sexuels, des saignements menstruels abondants et d'autres problemes gastro-intestinaux. Le diagnostic peut necessiter des examens cliniques approfondis, notamment des echographies, des IRM ou une laparoscopie. L'endometriose est une condition complexe et chaque cas est unique. Il est crucial de travailler en collaboration avec des professionnels de la sante pour elaborer un plan de traitement personnalise.

En conclusion, l'endometriose peut avoir un impact significatif sur la vie quotidienne, mais avec un diagnostic precoce, une gestion appropriee et un soutien adequat, il est possible de trouver des strategies pour gerer cette condition et ameliorer la qualite de vie."
        </p>
        <!-- Bouton pour "terminer" -->
        <div class="button text-center">
          <button onclick="cacherSuite();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee1.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Introduction a l'endometriose</h5>
        <p class="card-text">
          "L'endometriose est une affection gynecologique souvent meconnue mais qui affecte des millions de femmes dans le monde... 
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite() {
    document.getElementById("article-complet").style.display = "block";
    document.getElementById("article-incomplet").style.display = "none";
  }

  function cacherSuite() {
    document.getElementById("article-complet").style.display = "none";
    document.getElementById("article-incomplet").style.display = "block";
  }
</script>

 <div id="article-complet1" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee2.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Quelles options pour le traitement de l'endometriose?</h5>
        <p class="card-text">
       "Il existe differentes approches pour gerer l'endometriose, allant des medicaments aux interventions chirurgicales.L'endometriose offre une gamme de traitements, incluant des medicaments comme les anti-inflammatoires et les contraceptifs hormonaux pour attenuer la douleur et reguler les menstruations. Pour les cas plus graves, la chirurgie, comme la laparoscopie, peut etre necessaire pour enlever les tissus anormaux. Des approches complementaires telles que la physiotherapie, l'acupuncture et des modifications du mode de vie comme une alimentation equilibree et l'exercice peuvent egalement aider. Une collaboration avec une equipe medicale specialisee est cruciale pour elaborer un plan de traitement personnalise."  </p>
        <!-- Bouton pour "terminer" -->
        <div class="button text-center">
          <button onclick="cacherSuite1();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet1">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee2.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Quelles options pour le traitement de l'endometriose?</h5>
        <p class="card-text">
          "Il existe differentes approches pour gerer l'endometriose, allant des medicaments aux interventions... 
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite1();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite1() {
    document.getElementById("article-complet1").style.display = "block";
    document.getElementById("article-incomplet1").style.display = "none";
  }
  function cacherSuite1() {
    document.getElementById("article-complet1").style.display = "none";
    document.getElementById("article-incomplet1").style.display = "block";
  }
</script>
   <div id="article-complet2" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee3.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Endometriose et fertilite : Y'a-t-il un impact?</h5>
        <p class="card-text">
       "L'endometriose peut avoir un impact significatif sur la fertilite des femmes. Les adherences causees par la croissance anormale du tissu endometrial en dehors de l'uterus peuvent perturber les organes reproducteurs et alterer leur fonctionnement, ce qui peut compliquer la conception. Les implants endometriaux peuvent bloquer ou endommager les trompes de Fallope, entraver la liberation de l'ovule ou alterer la qualite des ovocytes et du sperme. Par ailleurs, l'inflammation chronique associee a l'endometriose peut affecter l'environnement uterin et nuire a l'implantation de l'embryon. Pour les femmes atteintes d'endometriose et cherchant a concevoir, il est crucial de consulter un specialiste de la fertilite pour explorer les options adaptees, telles que la fecondation in vitro (FIV) ou d'autres traitements de procreation assistee. De plus, une prise en charge precoce de l'endometriose, avec des traitements visant a minimiser la progression de la maladie et a reduire les adherences, peut souvent ameliorer les chances de conception. Il est essentiel de garder un suivi regulier avec son professionnel de la sante pour evaluer la fertilite, discuter des options disponibles et prendre des decisions eclairees pour realiser le desir de concevoir.""
        <div class="button text-center">
          <button onclick="cacherSuite2();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet2">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee3.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Endometriose et fertilite : Y'a-t-il un impact?</h5>
        <p class="card-text">
           "L'endometriose peut avoir un impact significatif sur la fertilite des femmes. Les adherences causees...
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite2();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite2() {
    document.getElementById("article-complet2").style.display = "block";
    document.getElementById("article-incomplet2").style.display = "none";
  }

  function cacherSuite2() {
    document.getElementById("article-complet2").style.display = "none";
    document.getElementById("article-incomplet2").style.display = "block";
  }
</script>
  <div id="article-complet3" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee4.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Comment gerer de la douleur associee a l'endometriose?</h5>
        <p class="card-text">
      "La douleur est l'un des symptomes les plus debilitants de l'endometriose. Pour la gestion de la douleur, des approches multiples peuvent etre utiles. Les anti-inflammatoires non steroÃ¯diens (AINS) tels que l'ibuprofene peuvent aider a attenuer la douleur menstruelle. Les contraceptifs hormonaux, comme les pilules contraceptives, peuvent etre prescrits pour reguler les cycles et reduire la douleur. La chaleur sous forme de coussins chauffants ou de bains chauds peut egalement apporter un soulagement temporaire. La meditation, la relaxation et les techniques de respiration peuvent aider a gerer le stress associe a la douleur. Pour une approche complete, la physiotherapie peut etre benefique pour soulager les tensions musculaires et ameliorer la flexibilite. Une alimentation saine et equilibree, riche en aliments anti-inflammatoires comme les fruits, les legumes et les acides gras omega-3, peut contribuer a reduire l'inflammation et a attenuer la douleur. Il est recommande de travailler en etroite collaboration avec son medecin pour elaborer un plan de gestion de la douleur personnalise, en combinant differentes approches pour trouver celles qui apportent un soulagement optimal." <div class="button text-center">
          <button onclick="cacherSuite3();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet3">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee4.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Comment gerer de la douleur associee a l'endometriose?</h5>
        <p class="card-text">
           "La douleur est l'un des symptomes les plus debilitants de l'endometriose. Pour la gestion de la douleur...
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite3();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite3() {
    document.getElementById("article-complet3").style.display = "block";
    document.getElementById("article-incomplet3").style.display = "none";
  }

  function cacherSuite3() {
    document.getElementById("article-complet3").style.display = "none";
    document.getElementById("article-incomplet3").style.display = "block";
  }
</script>
 <div id="article-complet4" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee5.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Endometriose et sante mentale : Y'a-t-il un influence?</h5>
        <p class="card-text">
      "Outre ses impacts physiques, l'endometriose peut egalement affecter la sante mentale. Les douleurs chroniques, les symptomes invalidants et les difficultes liees a la fertilite peuvent entraÃ®ner un fardeau emotionnel considerable. Des etudes suggerent que les personnes atteintes d'endometriose ont un risque accru de troubles tels que l'anxiete, la depression et le stress. La douleur persistante peut alterer la qualite de vie, affecter le sommeil et limiter les activites quotidiennes, ce qui peut contribuer a des sentiments d'isolement et de frustration. La lutte pour le diagnostic et la gestion des symptomes peut egalement generer du stress et de l'anxiete. Il est donc essentiel pour les personnes atteintes d'endometriose de recevoir un soutien emotionnel adequat, que ce soit par le biais de groupes de soutien, de therapies individuelles ou de discussions ouvertes avec des proches. Prendre soin de sa sante mentale en cherchant un soutien professionnel et en adoptant des strategies d'adaptation peut aider a faire face aux defis emotionnels associes a cette condition."</p> <div class="button text-center">
          <button onclick="cacherSuite4();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet4">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee5.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">Endometriose et sante mentale : Y'a-t-il un influence?</h5>
        <p class="card-text">
           "Outre ses impacts physiques, l'endometriose peut egalement affecter la sante mentale...
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite4();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite4() {
    document.getElementById("article-complet4").style.display = "block";
    document.getElementById("article-incomplet4").style.display = "none";
  }

  function cacherSuite4() {
    document.getElementById("article-complet4").style.display = "none";
    document.getElementById("article-incomplet4").style.display = "block";
  }
</script>
 <div id="article-complet5" style="display: none;">
  <div class="col">
    <div class="card h-100">
      <img class="card-img-top" src="frontend/assets/img/jee6.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">L'importance du soutien communautaire</h5>
        <p class="card-text">
      "La creation d'une communaute de soutien est essentielle pour les personnes vivant avec l'endometriose.Le soutien communautaire joue un role crucial pour les personnes atteintes d'endometriose. Les groupes de soutien, les forums en ligne et les communautes dediees offrent un espace oÃ¹ les individus peuvent partager leurs experiences, se sentir entendus et soutenus par d'autres personnes confrontees aux memes defis. Ces plateformes permettent non seulement de recevoir des conseils pratiques sur la gestion de la maladie, mais egalement de trouver un soutien emotionnel precieux. Le sentiment de ne pas etre seul dans cette lutte contre l'endometriose peut avoir un impact significatif sur le bien-etre emotionnel. Les liens crees au sein de ces communautes offrent un espace d'ecoute et de partage, reduisant ainsi le sentiment d'isolement souvent associe a cette condition. De plus, ces groupes peuvent fournir des informations actualisees, des ressources et des conseils utiles, aidant ainsi les personnes affectees a mieux gerer leur sante et a faire des choix eclaires en matiere de traitement."</p> <div class="button text-center">
          <button onclick="cacherSuite5();" class="btn btn-danger btn-buy-now">Terminer</button>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Partie cachee de l'article -->
<div id="article-incomplet5">
  <div class="col">
    <div class="card h-100">
       <img class="card-img-top" src="frontend/assets/img/jee6.jpeg" alt="Card image cap" />
      <div class="card-body">
        <h5 class="card-title" style="color: green;">L'importance du soutien communautaire</h5>
        <p class="card-text">
           "La creation d'une communaute de soutien est essentielle pour les personnes vivant avec l'endometriose...
        </p>
        <!-- Bouton pour "lire la suite" -->
        <div class="button text-center">
          <button onclick="afficherSuite5();" class="btn btn-danger btn-buy-now">Lire la suite</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  function afficherSuite5() {
    document.getElementById("article-complet5").style.display = "block";
    document.getElementById("article-incomplet5").style.display = "none";
  }

  function cacherSuite5() {
    document.getElementById("article-complet5").style.display = "none";
    document.getElementById("article-incomplet5").style.display = "block";
  }
</script>
</div>

          
          

<!-- Footer -->
<footer class="content-footer footer bg-footer-theme">
  <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
    <div class="mb-2 mb-md-0">
    Â© <script>document.write(new Date().getFullYear()) </script>, Fz & Salwa <a href="https://themeselection.com" target="_blank" class="footer-link fw-medium"></a>
    </div>
    <div class="d-none d-lg-inline-block">
      
      <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">License</a>
      <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">More Themes</a>
      
      <a href="https://demos.themeselection.com/sneat-bootstrap-html-admin-template/documentation/" target="_blank" class="footer-link">Documentation</a>
      
      
      <a href="https://themeselection.com/support/" target="_blank" class="footer-link d-none d-sm-inline-block">Support</a>
      
    </div>
  </div>
</footer>
<!-- / Footer -->

          
          <div class="content-backdrop fade"></div>
        </div>
        <!-- Content wrapper -->
      </div>
      <!-- / Layout page -->
    </div>

    
    
    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
    
    
    <!-- Drag Target Area To SlideIn Menu On Small Screens -->
    <div class="drag-target"></div>
    
  </div>
  <!-- / Layout wrapper -->

  

  

  <!-- Core JS -->
  <!-- build:js assets/vendor/js/core.js -->
  
  <script src="frontend/assets/vendor/libs/jquery/jquery.js"></script>
  <script src="js/popper.js"></script>
  <script src="frontend/assets/vendor/js/bootstrap.js"></script>
  <script src="js/perfect-scrollbar.js"></script>
  <script src="frontend/assets/vendor/libs/hammer/hammer.js"></script>
  <script src="frontend/assets/vendor/libs/i18n/i18n.js"></script>
  <script src="frontend/assets/vendor/libs/typeahead-js/typeahead.js"></script>
  <script src="frontend/assets/vendor/js/menu.js"></script>
  
  <!-- endbuild --> <!-- build:js assets/vendor/js/core.js -->
    <script src="frontend/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="frontend/assets/vendor/libs/popper/popper.js"></script>
    <script src="frontend/assets/vendor/js/bootstrap.js"></script>
    <script src="frontend/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="frontend/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="frontend/assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="frontend/assets/js/main.js"></script>

    <!-- Page JS -->
    <script src="frontend/assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>

  <!-- Vendors JS -->
  <script src="frontend/assets/vendor/libs/masonry/masonry.js"></script>

  <!-- Main JS -->
  <script src="frontend/assets/js/main.js"></script>
  

  <!-- Page JS -->
  
  
  
</body>

</html>

<!-- beautify ignore:end -->

