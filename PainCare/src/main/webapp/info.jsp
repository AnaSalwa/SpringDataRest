<%@ page import="com.JAVA.Bean.UserBean" %>
<% UserBean user = (UserBean) request.getSession().getAttribute("User"); %>


<!DOCTYPE html>



<html lang="en" class="light-style layout-navbar-fixed layout-menu-fixed layout-compact " dir="ltr" data-theme="theme-semi-dark" data-assets-path="../../assets/" data-template="vertical-menu-template">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

    <title>Pain Care</title>

    
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
    <link rel="icon" type="image/x-icon" href="assets/img/favicon/favicon.ico" />

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
    <script src="js/helpers.js"></script>
    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Template customizer: To hide customizer set displayCustomizer value false in config.js.  -->
    <script src="js/template-customizer.js"></script>
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="frontend/assets/js/config.js"></script>
    
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
           <!--   <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link">
                <i class="menu-icon tf-icons bx bx-cube-alt"></i>
                <div data-i18n="Misc">Calendrier</div>
              </a>
            
            </li>-->
            
              </li>
             <li class="menu-item">
              <a href="calendar.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-cube-alt"></i>
                <div data-i18n="Misc">Calendrier</div>
              </a>
            
            </li>
            <!-- Components -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">Communauté</span></li>
            <!-- Cards -->
            <li class="menu-item">
              <a href="publication.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Publications</div>
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
                <i class="menu-icon tf-icons bx bx-detail"></i>
                <div data-i18n="Form Elements">Test de diagnostic</div>
              </a>
            
            
            </li>
            <li class="menu-item">
              <a href="Graphes.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-detail"></i>
                <div data-i18n="Form Layouts">Graphes</div>
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
              <a href="first.jsp" class="menu-link">
                <i class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">Se déconnecter</div>
              </a>
            </li>
       
            
            
            
            <!-- Misc -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">Support</span></li>
            <li class="menu-item">
              <a
                href="ContactezNous.jsp"
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


<nav class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme" id="layout-navbar">
  

  

  

      
      

      
      
      <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0   d-xl-none ">
        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
          <i class="bx bx-menu bx-sm"></i>
        </a>
      </div>
      

      <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">

        

        
        <!-- Search -->
        <div class="navbar-nav align-items-center">
          <div class="nav-item navbar-search-wrapper mb-0">
            <a class="nav-item nav-link search-toggler px-0" href="javascript:void(0);">
              <i class="bx bx-search bx-sm"></i>
              <span class="d-none d-md-inline-block text-muted">Search </span>
            </a>
          </div>
        </div>
        <!-- /Search -->
        


        

        <ul class="navbar-nav flex-row align-items-center ms-auto">
          

          

        

         
          
        
          

          

        </ul>
      </div>

      
      <!-- Search Small Screens -->
      <div class="navbar-search-wrapper search-input-wrapper  d-none">
        <input type="text" class="form-control search-input container-xxl border-0" placeholder="Search..." aria-label="Search...">
        <i class="bx bx-x bx-sm search-toggler cursor-pointer"></i>
      </div>
      
      
  </nav>
  

  
<!-- / Navbar -->

      

      <!-- Content wrapper -->
      <div class="content-wrapper">

        <!-- Content -->
        
          <div class="container-xxl flex-grow-1 container-p-y">
            
            
<h4 class="py-3 mb-4"><span class="text-muted fw-light"> Informations /</span> Comprendre l'Endometriose : Une Maladie Complexe</h4>


<!-- Accordion -->
<h5 class="mt-4">A savoir</h5>
<div class="row">
  <div class="col-md mb-4 mb-md-2">
    
    <div class="accordion mt-3" id="accordionExample">
      <div class="card accordion-item active">
        <h2 class="accordion-header" id="headingOne">
          <button type="button" class="accordion-button" data-bs-toggle="collapse" data-bs-target="#accordionOne" aria-expanded="true" aria-controls="accordionOne" style="color: blue;">
            C'est quoi l'endometriose?
          </button>
        </h2>

        <div id="accordionOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
          <div class="accordion-body">
            Le nom medical de la paroi interne de l'uterus est "l'endometre". Au cours des regles, la muqueuse uterine
            est eliminee par le vagin. En cas d'endometriose, des fragments d endometre se developpent ailleurs que dans
            la paroi interne de l'uterus, ou cavite uterine. Ils peuvent ainsi apparaitre sur les ovaires, ou parfois sur
            les trompes de Fallope, le vagin, le peritoine ou l'intestin.
          </div>
        </div>
      </div>
      <div class="card accordion-item">
        <h2 class="accordion-header" id="headingTwo">
          <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionTwo" aria-expanded="false" aria-controls="accordionTwo" style="color: red;">
            Symptomes 
          </button>
        </h2>
        <div id="accordionTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
          <div class="accordion-body">
          Crampes menstruelles intenses ressenties dans l'abdomen et le bas du dos, appelees dysmenorrhees 
          + Un flux menstruel anormal dans le cadre d'une variante de l'endometriose appelee adenomyose ou endometriose interne a la paroi uterine 
          + Une infertilite et la difficulte a tomber enceinte 
          + Des mictions douloureuses pendant la periode menstruelle 
          + La difficulte d aller a la selle lors du cycle menstruel 
          + Des troubles gastro-intestinaux et digestifs, tels que diarrhee, constipation et/ou nausees...
        </div>
      </div>
      </div>
      <div class="card accordion-item">
        <h2 class="accordion-header" id="headingThree">
          <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionThree" aria-expanded="false" aria-controls="accordionThree" style="color: orange;">
            Douleur entometriose
          </button>
        </h2>
        <div id="accordionThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
          <div class="accordion-body">
           Il est important de souligner que l'intensite de la douleur evoquee par une femme n'est pas
           necessairement proportionnelle a la severite de la maladie. Certaines femmes souffrant d'endometriose
           severe et de lesions d'endometriose ne ressentent aucune douleur, tandis que d'autres, pourtant
           atteintes plus legerement, peuvent souffrir de douleurs intenses ou d'autres symptomes.


          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="col-md">
    <div id="accordionIcon" class="accordion mt-3 accordion-without-arrow">
      <div class="accordion-item card">
        <h2 class="accordion-header text-body d-flex justify-content-between" id="accordionIconOne">
          <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionIcon-1"  aria-controls="accordionIcon-1" style="color: pink;">
            Diagnostic endometriose ? Test
          </button>
        </h2>

        <div id="accordionIcon-1" class="accordion-collapse collapse" data-bs-parent="#accordionIcon">
          <div class="accordion-body">
           Pour diagnostiquer l'endometriose et les troubles causant des douleurs pelviennes, divers examens sont utilises :
           l'examen clinique pour detecter des anomalies comme des kystes ou des cicatrices uterines, l'echographie pour visualiser
           les kystes associes a l'endometriose, et l'IRM pour obtenir des images precises des organes et des tissus affectes.
           Bien que ces examens fournissent des informations cruciales, un diagnostic complet combine ces donnees pour confirmer
           la presence d'endometriose ou d autres pathologies provoquant des douleurs pelviennes.
          </div>
        </div>
      </div>

      <div class="accordion-item card">
        <h2 class="accordion-header text-body d-flex justify-content-between" id="accordionIconTwo">
          <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionIcon-2" aria-controls="accordionIcon-2" style="color: green;">
            Traitement
          </button>
        </h2>
        <div id="accordionIcon-2" class="accordion-collapse collapse" data-bs-parent="#accordionIcon">
          <div class="accordion-body">
          L'approche principale pour traiter l'endometriose est d'arreter les regles (amenorrhee). Des methodes naturelles telles que
          les medecines douces, la relaxation, le yoga et l'acupuncture peuvent soulager les douleurs. En cas de symptomes handicapants,
          un traitement hormonal (pilules contraceptives, sterilet hormonal) est envisage pour supprimer la secretion d'oestrogenes.
          En dernier recours, la chirurgie est utilisee pour eliminer les lesions, mais de nouvelles approches moins invasives sont a l'etude.
          </div>
        </div>
      </div>

      <div class="accordion-item card active">
        <h2 class="accordion-header text-body d-flex justify-content-between" id="accordionIconThree">
          <button type="button" class="accordion-button" data-bs-toggle="collapse" data-bs-target="#accordionIcon-3" aria-expanded="true" aria-controls="accordionIcon-3" style="color: purple;">
            Complications
          </button>
        </h2>
        <div id="accordionIcon-3" class="accordion-collapse collapse show" data-bs-parent="#accordionIcon">
          <div class="accordion-body">
            Tout d'abord, l endometriose est souvent associee a des difficultes pour
            concevoir, car les lesions peuvent alterer la qualite des ovules ou obstruer les trompes de Fallope. Cette condition peut
            ainsi induire des problemes d infertilite chez certaines femmes. De plus, bien que rare, il existe un risque legerement
            accru de developper un cancer ovarien, appele carcinome endometrioide.
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--/ Accordion -->

<!--/ Advance Styling Options -->

          </div>
          <!-- / Content -->

          
          

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
  
  <script src="js/jquery.js"></script>
  <script src="frontend/libs/popper/popper.js"></script>
  <script src="frontend/js/bootstrap.js"></script>
  <script src="frontend/js/perfect-scrollbar.js"></script>
  <script src="frontend/js/hammer.js"></script>
  <script src="frontend/js/i18n.js"></script>
  <script src="frontend/js/typeahead.js"></script>
  <script src="frontend/js/menu.js"></script>
  
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
  
  <!-- endbuild -->

  <!-- Vendors JS -->
  
  

  <!-- Main JS -->
  <script src="frontend/js/main.js"></script>
  

  <!-- Page JS -->
  
  
  
</body>

</html>

<!-- beautify ignore:end -->

