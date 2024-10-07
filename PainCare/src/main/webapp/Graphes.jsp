<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.JAVA.Bean.UserBean" %>
<%@ page import="com.JAVA.Bean.DouleurBean" %>
   
   
<%@ page import="com.JAVA.Bean.UserBean" %>
<% UserBean user = (UserBean) request.getSession().getAttribute("User"); %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>


<!DOCTYPE html>

<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-semi-dark"
  data-assets-path="frontend/assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Pain Care </title>

    <meta name="description" content="" />

    <!-- Favicon -->
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
              <a href="home.jsp" class="menu-link">
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

          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Suivre mon état/</span> Graphes de douleurs </h4>

              <!-- Basic Layout & Basic with Icons -->
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                    </div>
                    <div class="card-body">
                      <!--   <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Degré de douleur</label>
                          <div class="col-sm-10">
							<div class="col-md">
		                          
		                          <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="1"
		                              id="1"
		                            />
		                            <label class="form-check-label" for="1"> 1 </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="2"
		                              id="2"
		                            />
		                            <label class="form-check-label" for="1"> 2 </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="3"
		                              id="3"
		                            />
		                            <label class="form-check-label" for="3"> 3</label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="4"
		                              id="4"
		                            />
		                            <label class="form-check-label" for="4"> 4 </label>
		                          </div>
		                          
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="5"
		                              id="5"
		                            />
		                            <label class="form-check-label" for="5"> 5 </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="6"
		                              id="6"
		                            />
		                            <label class="form-check-label" for="6"> 6 </label>
		                          </div>
		                          
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="7"
		                              id="7"
		                            />
		                            <label class="form-check-label" for="7"> 7 </label>
		                          </div>
		                          
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="8"
		                              id="8"
		                            />
		                            <label class="form-check-label" for="1"> 8 </label>
		                          </div>
		                          
		                          
		                        </div>                         
                        </div>
                        
                        
                        
                        
                        
                         <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Localisation</label>
                          <div class="col-sm-10">
							<div class="col-md">
		                          
		                          <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Abdomen"
		                              id="Abdomen"
		                            />
		                            <label class="form-check-label" for="Abdomen"> Abdomen </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Dos"
		                              id="Dos"
		                            />
		                            <label class="form-check-label" for="Dos"> Dos </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Bras"
		                              id="Bras"
		                            />
		                            <label class="form-check-label" for="Bras"> Bras</label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Épaules"
		                              id="Épaules"
		                            />
		                            <label class="form-check-label" for="Épaules"> Épaules</label>
		                          </div>
		                          
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Ventre"
		                              id="Ventre"
		                            />
		                            <label class="form-check-label" for="Ventre"> Ventre</label>
		                          </div>
		                          
		                           
		                          
		                             
		                          
		                        </div>                         
                        </div>
                        
                        
                        
                        
                        
                        
                        
                         <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Sentiments </label>
                          <div class="col-sm-10">
							<div class="col-md">
		                          
		                          <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Depression"
		                              id="Depression"
		                            />
		                            <label class="form-check-label" for="Depression"> Depression </label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Isolement"
		                              id="Isolement"
		                            />
		                            <label class="form-check-label" for="Isolement"> Isolement Social</label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Frustration"
		                              id="Frustration"
		                            />
		                            <label class="form-check-label" for="Frustration"> Frustration</label>
		                          </div>
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Colère"
		                              id="Colère"
		                            />
		                            <label class="form-check-label" for="Colère"> Colère</label>
		                          </div>
		                          
		                          
		                             <div class="form-check mt-3">
		                            <input
		                              name="default-radio-1"
		                              class="form-check-input"
		                              type="radio"
		                              value="Inquiétude et anxiété"
		                              id="Inquiétude et anxiété"
		                            />
		                            <label class="form-check-label" for="Inquiétude et anxiété"> Inquiétude et anxiété</label>
		                          </div>
		                          
		                           
		                          
		                             
		                          
		                        </div>  -->
		                        
		                        
		    <!--    <div class="card mb-4">
                <h5 class="card-header">Souffrez-vous d'une douleur ?</h5>
                <div class="card-body">
                  <div class="row gx-3 gy-2 align-items-center">
                   
                   
                    <div class="col-md-3">
                    
				<form action="DouleurServlet?action=insertD&id_user=<%= user.getId() %>" method="post">
                    
	                      <label class="form-label" for="selectTypeOpt">Degré de la douleur</label>
	                      <select name= "degre" id="degre" class="form-select color-dropdown">
	                        <option value="1" selected>1</option>
	                        <option value="2">2</option>
	                        <option value="3">3</option>
	                        <option value="4">4</option>
	                        <option value="5">5</option>
	                        <option value="6">6</option>
	                        <option value="7">7</option>
	                        <option value="8">8</option>
	                        <option value="9">9</option>
	                      </select>
	                    </div>
                    
                    
                    
	                    <div class="col-md-3">
	                      <label class="form-label" for="selectPlacement">Localisation</label>
	                      <select class="form-select placement-dropdown" id="localisation" name="localisation">
	                        <option value="abdomen" selected>Abdomen</option>
	                        <option value="dos">Dos</option>
	                        <option value="bras">Bras</option>
	                        <option value="jambes">Jambes</option>
	                        <option value="epaules">Epaules</option>
	                      </select>
	                    </div>
                    	
                    
                    
                    
	                     <div class="col-md-3">
	                      <label class="form-label" for="selectPlacement">Sentiment </label>
	                      <select class="form-select placement-dropdown" id="sentiment" name="sentiment">
	                        <option value="top-0 start-0">Dépression</option>
	                        <option value="top-0 start-50 translate-middle-x">Anxiété</option>
	                        <option value="top-0 end-0">Colère</option>
	                        <option value="top-50 start-0 translate-middle-y">Frustration</option>
	                        <option value="top-50 start-50 translate-middle">Inquiétude</option>
	                        <option value="top-50 end-0 translate-middle-y">Isolement social</option>
	                        <option value="bottom-0 start-0">Douleur physique</option>
	                      </select>
	                    </div> 
	                    
	                    
	
	                       <div class="col-md-3">
					        <label class="form-label" for="date">Date</label>
							 <input type="date" id="date" name="date" class="form-control color-dropdown">
					        
					       <!--   <input type="date" id="date" name="date" class="form-control color-dropdown" value="<%= java.time.LocalDate.now() %>">
					    </div>
					    
					    </div>
	                    
	                    
	                    
	                    <div class="col-md-3">
	                      <label class="form-label" for="showToastPlacement">&nbsp;</label>
	                      <button type="submit" id="showToastPlacement" class="btn btn-primary d-block">Ajouter la douleur</button>
	                    </div>
	                    
	                    <div class="col-md-3">
	                      <label class="form-label" for="showToastPlacement">&nbsp;</label>
	                      
	                      <a href="graphe.html" class="btn btn-primary d-block">Visualiser le graphe</a>
	                      
	                      <!--  <a href="DouleurServlet?action=afficherGraphe&id_user=<%= user.getId() %>" class="btn btn-primary d-block">Visualiser le graphe</a>
	                    </div>
                    
                    </form>
                    
                  </div>
                </div>
              </div>                       
                      
                       
                        
                        
                        
		                    
                        
                        
                 
                    </div>
                  </div>
                </div>-->
                <!-- Basic with Icons -->
		              
	
		
		
		
		
		
		
		  <!-- Bootstrap Table with Header - Light -->
              <div class="card">
              <div class="row align-items-center">
		        <div class="col">
		            <h5 class="card-header">Souffrez-vous d'une douleur ?</h5>
		        </div>
		        <div class="col text-end">
		        		            <a href="" class="btn btn-success btn-buy-now" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCenter">Ajouter une douleur</a>
		        
		            <a href="DouleurServlet?action=graph&id_user=<%= user.getId() %>" class="btn btn-primary" type="button" class="btn btn-primary">Graphe des douleurs</a>
		        </div>
		        
		        
					        
					    <!-- modal pour le bouton Ajouter une douleur -->
		<!-- Modal pour le bouton Ajouter une douleur -->
<div class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalAjouterDouleurTitle">Ajouter une douleur</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                
            </div>

            <div class="modal-body">
                <form action="DouleurServlet?action=insertD&id_user=<%= user.getId() %>" method="post">
                    <div class="row">
                        <div class="col-md-5">
                            <label class="form-label" for="degre">Degré</label>
                            <select name="degre" id="degre" class="form-select color-dropdown">
                                <option value="1" selected>1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
                        </div>

                        <div class="col-md-5">
                            <label class="form-label" for="localisation">Localisation</label>
                            <select class="form-select placement-dropdown" id="localisation" name="localisation">
                                <option value="abdomen" selected>Abdomen</option>
                                <option value="dos">Dos</option>
                                <option value="bras">Bras</option>
                                <option value="jambes">Jambes</option>
                                <option value="epaules">Epaules</option>
                            </select>
                        </div>

                        <div class="col-md-5">
                            <label class="form-label" for="sentiment">Sentiment</label>
                            <select class="form-select placement-dropdown" id="sentiment" name="sentiment">
                                <option value="Dépression">Dépression</option>
                                <option value="Anxiété">Anxiété</option>
                                <option value="Colère">Colère</option>
                                <option value="Frustration">Frustration</option>
                                <option value="Inquiétude">Inquiétude</option>
                                <option value="Isolement social">Isolement social</option>
                                <option value="Douleur physique">Douleur physique</option>
                            </select>
                        </div>

                        <div class="col-md-5">
                            <label class="form-label" for="date">Date</label>
                            <input type="date" id="date" name="date" class="form-control color-dropdown">
                        </div>
                    </div>
            </div>

            <div class="modal-footer">
            
                <button type="submit" id="showToastPlacement" class="btn btn-primary d-block">Ajouter la douleur</button>
                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Annuler</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Fin du modal -->
                        
                        
                        
		    </div>
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead class="table-light">
                      <tr>
                     			 <th>Degré</th>
		                        <th>Localisation</th>
		                        <th>Sentiment</th>
		                        <th>Date</th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                      
				<c:forEach var="douleur" items="${douleurs}">
    <tr>
        <td>${douleur.degre}</td>
        <td>${douleur.localisation}</td>
        <td>${douleur.sentiment}</td>
        <td>${douleur.date}</td>

        <td class="border-0">
            <a href="" type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalCenter2-${douleur.id}">
                Modifier
            </a>
        </td>

        <!-- Modal pour le bouton Modifier une douleur -->
        <div class="modal fade" id="modalCenter2-${douleur.id}" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalAjouterDouleurTitle">Modifier la douleur</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <form action="DouleurServlet?action=updateDouleur&id_douleur=${douleur.id}" method="post">
                            <div class="row">
                                <div class="col-md-5">
                                    <label class="form-label" for="degre">Degré</label>
                                    <select name="degre" id="degre" class="form-select color-dropdown">
                                        <option value="${douleur.degre}" selected>${douleur.degre}</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                    </select>
                                </div>

                                <div class="col-md-5">
                                    <label class="form-label" for="localisation">Localisation</label>
                                    <select class="form-select placement-dropdown" id="localisation" name="localisation">
                                        <option value="${douleur.localisation}" selected>${douleur.localisation}</option>
                                        <option value="abdomen">Abdomen</option>
                                        <option value="dos">Dos</option>
                                        <option value="bras">Bras</option>
                                        <option value="jambes">Jambes</option>
                                        <option value="epaules">Epaules</option>
                                    </select>
                                </div>

                                <div class="col-md-5">
                                    <label class="form-label" for="sentiment">Sentiment</label>
                                    <select class="form-select placement-dropdown" id="sentiment" name="sentiment">
                                        <option value="${douleur.sentiment}" selected>${douleur.sentiment}</option>
                                        <option value="Dépression">Dépression</option>
                                        <option value="Anxiété">Anxiété</option>
                                        <option value="Colère">Colère</option>
                                        <option value="Frustration">Frustration</option>
                                        <option value="Inquiétude">Inquiétude</option>
                                        <option value="Isolement social">Isolement social</option>
                                        <option value="Douleur physique">Douleur physique</option>
                                    </select>
                                </div>

                                <div class="col-md-5">
                                    <label class="form-label" for="date">Date</label>
                                    <input type="date" id="date" name="date" value="${douleur.date}" class="form-control color-dropdown">
                                </div>
                            </div>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" id="showToastPlacement" class="btn btn-primary d-block">Modifier la douleur</button>
                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Annuler</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin du modal -->

        <td>
            <a href="DouleurServlet?action=deleteDouleur&id_douleur=${douleur.id}" type="button" class="btn btn-warning">
                Supprimer
            </a>
        </td>
    </tr>
</c:forEach>

                  
                    </tbody>
                  </table>
                </div>
              </div>
              <!-- Bootstrap Table with Header - Light -->


              
              
              
              
              
              
              
              
              
              
              
              
              
            </div>
            <!-- / Content -->
</div>


</div>




            <!-- Footer -->
            <footer class="content-footer footer bg-footer-theme">
              <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                <div class="mb-2 mb-md-0">
                  ©
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  , made with ❤️ by
                  <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">ThemeSelection</a>
                </div>
                <div>
                  <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">License</a>
                  <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">More Themes</a>

                  <a
                    href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                    target="_blank"
                    class="footer-link me-4"
                    >Documentation</a
                  >

                  <a
                    href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                    target="_blank"
                    class="footer-link me-4"
                    >Support</a
                  >
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
    </div>
    <!-- / Layout wrapper -->

  

    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="frontend/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="frontend/assets/vendor/libs/popper/popper.js"></script>
    <script src="frontend/assets/vendor/js/bootstrap.js"></script>
    <script src="frontend/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="frontend/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->

    <!-- Main JS -->
    <script src="frontend/assets/js/main.js"></script>

    <!-- Page JS -->

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
  </body>
</html>
