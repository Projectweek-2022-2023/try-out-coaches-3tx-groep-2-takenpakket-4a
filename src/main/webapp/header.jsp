<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>Mijn huisdieren</h1>
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"id = actual":""}>
                <a id="goHome"
                   href="Controller?command=Home">Home</a></li>
            <li ${param.actual eq 'voegToe'?"id = actual":""}>
                <a href="Controller?command=AddForm">Voeg Toe</a></li>
            <li ${param.actual eq 'Overzicht'?"id = actual":""}>
                <a href="Controller?command=Overview">Overzicht</a></li>
            <li   ${param.actual eq 'Email Versturen'?"id = actual":""}>
                <a  href="Controller?command=Emailpagina">Email Versturen</a></li>
            <li class="nav-item"  ${param.actual eq 'Pdf'?"id = actual":""}>
                <a class="nav-link"  href="Controller?command=Pdf">PDF</a></li>
          
        </ul>
    </nav>
</header>