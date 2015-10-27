<!--     Chris Boucher  -->  
<!--     faq.jsp -->
<!--     Page for viewing frequently asked questions -->
<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - FAQ</title>
</head>

<body>
<div th:fragment="content"> 
    <!-- Page Content -->
    <div class="jumbotron content">
        <div class="container">
            
            <!-- FAQ Panel -->
            <!-- Title -->
            <h2 id="productTitle">Frequently Asked Questions</h2>

            <!-- FAQ Well -->
            <div class="well">

                <!-- FAQ Question -->
                <div th:each="faq : ${faqList}" class="panel panel-default">
                    <div class="panel-heading">
                        <h2 id="subtitle" th:text="'Q: ' + ${faq.question}"></h2></div>
                    <div class="panel-body" th:text="'A: ' + ${faq.answer}"></div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>